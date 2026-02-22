package com.sistema.gestion.service;

import com.sistema.gestion.dto.CategoriaDTO;
import com.sistema.gestion.mapper.Mapper;
import com.sistema.gestion.repository.CategoriaRepository;
import com.sistema.gestion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<CategoriaDTO> traerCategorias() {
        return categoriaRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        return null;
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long idCategoria, CategoriaDTO categoriaDTO) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long idCategoria) {

    }
}
