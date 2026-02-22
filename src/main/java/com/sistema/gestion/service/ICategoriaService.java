package com.sistema.gestion.service;


import com.sistema.gestion.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> traerCategorias();

    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);
}