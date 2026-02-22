package com.sistema.gestion.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombreProducto;
    private String descripcion;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Long stock;
    private Long stockMinimo;

    @ManyToOne
    private Categoria categoria;
}
