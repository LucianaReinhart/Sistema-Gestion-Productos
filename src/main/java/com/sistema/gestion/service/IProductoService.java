package com.sistema.gestion.service;

import com.sistema.gestion.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long idProducto,ProductoDTO productoDTO);
    void eliminarProducto(Long idProducto);
    ProductoDTO traerPorId(Long idProducto);
    List<ProductoDTO> buscarPorNombre(String nombreProducto);
}
