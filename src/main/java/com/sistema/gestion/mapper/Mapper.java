package com.sistema.gestion.mapper;

import com.sistema.gestion.dto.CategoriaDTO;
import com.sistema.gestion.dto.ProductoDTO;
import com.sistema.gestion.model.Categoria;
import com.sistema.gestion.model.Producto;

public class Mapper {

    public static ProductoDTO toDTO (Producto producto){
        if(producto == null) return null;

        return ProductoDTO.builder()
                .idProducto(producto.getIdProducto())
                .nombreProducto(producto.getNombreProducto())
                .descripcion(producto.getDescripcion())
                .precioCompra(producto.getPrecioCompra())
                .precioVenta(producto.getPrecioVenta())
                .stock(producto.getStock())
                .stockMinimo(producto.getStockMinimo())
                .idCategoria(producto.getCategoria().getIdCategoria())
                .build();

    }

    public static CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) return null;

        Long primerId = (categoria.getProductos() != null && !categoria.getProductos().isEmpty())
                ? categoria.getProductos().get(0).getIdProducto()
                : null;

        return CategoriaDTO.builder()
                .idCategoria(categoria.getIdCategoria())
                .nombreCategoria(categoria.getNombreCategoria())
                .idProducto(primerId)
                .build();
    }
}
