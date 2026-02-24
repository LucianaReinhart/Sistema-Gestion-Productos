package com.sistema.gestion.controller;

import com.sistema.gestion.dto.CategoriaDTO;
import com.sistema.gestion.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> traerCategorias(){
        return ResponseEntity.ok(categoriaService.traerCategorias());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO dto){
        CategoriaDTO creado = categoriaService.crearCategoria(dto);
        return ResponseEntity.created(URI.create("/api/categoria" + creado.getIdCategoria())).body(creado);
    }

}
