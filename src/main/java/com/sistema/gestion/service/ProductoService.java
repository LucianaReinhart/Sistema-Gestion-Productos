package com.sistema.gestion.service;

import com.sistema.gestion.dto.ProductoDTO;
import com.sistema.gestion.mapper.Mapper;
import com.sistema.gestion.model.Categoria;
import com.sistema.gestion.model.Producto;
import com.sistema.gestion.repository.CategoriaRepository;
import com.sistema.gestion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<ProductoDTO> traerProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepository.findById(productoDTO.getIdCategoria())
                .orElseThrow(()->new RuntimeException("Categoria no encontrada con ID: "
                 + productoDTO.getIdCategoria()));
        Producto producto = Producto.builder()
                .idProducto(productoDTO.getIdProducto())
                .nombreProducto(productoDTO.getNombreProducto())
                .descripcion(productoDTO.getDescripcion())
                .precioCompra(productoDTO.getPrecioCompra())
                .precioVenta(productoDTO.getPrecioVenta())
                .stock(productoDTO.getStock())
                .stockMinimo(productoDTO.getStockMinimo())
                .categoria(categoria)
                .build();
        Producto productoGuardado = productoRepository.save(producto);
        return Mapper.toDTO(productoGuardado);
    }

    @Override
    public ProductoDTO actualizarProducto(Long idProducto, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioCompra(productoDTO.getPrecioCompra());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setStock(productoDTO.getStock());
        producto.setStockMinimo(productoDTO.getStockMinimo());
        if(productoDTO.getIdCategoria() != null){
            producto.setCategoria(categoriaRepository.findById(productoDTO.getIdCategoria()).orElse(null));
        }
        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        if(!productoRepository.existsById(idProducto)){
            throw new RuntimeException("Producto no encontrado");
        }

        productoRepository.deleteById(idProducto);
    }

    @Override
    public ProductoDTO traerPorId(Long idProducto) {
        return productoRepository.findById(idProducto)
                .map(Mapper::toDTO)
                .orElseThrow(()->new RuntimeException("No se encontro el producto"));
    }


}
