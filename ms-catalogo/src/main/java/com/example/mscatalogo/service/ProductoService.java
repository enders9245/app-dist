package com.example.mscatalogo.service;


import com.example.mscatalogo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();
    Producto guardar(Producto producto);
    Producto actualizar(Producto producto);
    Optional<Producto> listaPorld(Integer id);
    void eliminar(Integer id);
}
