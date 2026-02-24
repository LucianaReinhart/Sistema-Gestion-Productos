package com.sistema.gestion.controller;

import com.sistema.gestion.dto.ProductoDTO;
import com.sistema.gestion.service.IProductoService;
import com.sistema.gestion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> traerProducto(){
        return ResponseEntity.ok(productoService.traerProductos());
    };

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO dto){
        ProductoDTO creado = productoService.crearProducto(dto);
        return ResponseEntity.created(URI.create("/api/producto" + creado.getIdProducto())).body(creado);
    }

    @PutMapping("{idProducto}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long idProducto, @RequestBody ProductoDTO dto){
        return ResponseEntity.ok(productoService.actualizarProducto(idProducto, dto));
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> borrarArticulo(@PathVariable Long idProducto){
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }
}

