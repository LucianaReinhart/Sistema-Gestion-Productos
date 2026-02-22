package com.sistema.gestion.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long idProducto;
    private String nombreProducto;
    private String descripcion;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Long stock;
    private Long stockMinimo;
    private Long idCategoria;
}
