package com.example.mspedido.service;

import com.example.mspedido.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> lista();
    Pedido guardar(Pedido pedido);
    Optional<Pedido> listarPorid(Integer id);
    Pedido actualizar(Pedido pedido);
    void eliminar(Integer id);
}
