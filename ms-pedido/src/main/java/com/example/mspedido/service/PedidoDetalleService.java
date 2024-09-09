package com.example.mspedido.service;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;

import java.util.List;
import java.util.Optional;

public interface PedidoDetalleService {
    List<PedidoDetalle> lista();
    PedidoDetalle guardar(PedidoDetalle pedidoDetalle);
    Optional<PedidoDetalle> listarPorid(Integer id);
    PedidoDetalle actualizar(PedidoDetalle pedidoDetalle);
    void eliminar(Integer id);
}
