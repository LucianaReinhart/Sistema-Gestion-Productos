package com.sistema.gestion.service;

import com.sistema.gestion.dto.CategoriaDTO;
import com.sistema.gestion.mapper.Mapper;
import com.sistema.gestion.model.Categoria;
import com.sistema.gestion.repository.CategoriaRepository;
import com.sistema.gestion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
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
        Categoria categoria = Categoria.builder()
                .nombreCategoria(categoriaDTO.getNombreCategoria())
                .productos(new ArrayList<>())
                .build();
        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        return Mapper.toDTO(categoriaGuardada);
    }



}
