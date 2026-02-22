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
        return null;
    }

    @Override
    public void eliminarProducto(Long idProducto) {

    }

    @Override
    public ProductoDTO traerPorId(Long idProducto) {
        return null;
    }

    @Override
    public List<ProductoDTO> buscarPorNombre(String nombreProducto) {
        return List.of();
    }
}
