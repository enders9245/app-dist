package com.example.mscliente.service;

import com.example.mscliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> listarPorId(Integer id);
    Cliente actualizar(Cliente cliente);
    void eliminar(Integer id);
}
