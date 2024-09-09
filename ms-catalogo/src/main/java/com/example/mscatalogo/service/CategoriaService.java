package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria>listar();
    Categoria guardar(Categoria categoria);
    Categoria actualizar(Categoria categoria);
    Optional<Categoria>listaPorld(Integer id);
    void eliminar(Integer id);
    

}
