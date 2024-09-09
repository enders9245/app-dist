package com.example.mspedido.controller;

import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoDetalle")

public class PedidoDetalleController {
    @Autowired
    private PedidoDetalleService pedidoDetalleService;

    @GetMapping
    ResponseEntity<List<PedidoDetalle>> list() {
        return ResponseEntity.ok(pedidoDetalleService.lista());
    }

    @PostMapping
    ResponseEntity<PedidoDetalle> guardar(@RequestBody PedidoDetalle pedidoDetalle) {
        return ResponseEntity.ok(pedidoDetalleService.guardar(pedidoDetalle));
    }

    @GetMapping("/{id}")
    ResponseEntity<PedidoDetalle> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(pedidoDetalleService.listarPorid(id).get());
    }

    @PutMapping
    ResponseEntity<PedidoDetalle> actualizar(@RequestBody PedidoDetalle pedidoDetalle) {
        return ResponseEntity.ok(pedidoDetalleService.actualizar(pedidoDetalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<PedidoDetalle>> eliminar(@PathVariable(required = true) Integer id) {
        pedidoDetalleService.eliminar(id);
        return ResponseEntity.ok(pedidoDetalleService.lista());
    }
}
