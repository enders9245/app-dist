package com.example.mspedido.controller;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")

public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping
    ResponseEntity<List<Pedido>> list(){
        return ResponseEntity.ok(pedidoService.lista());
    }
    @PostMapping
    ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.guardar(pedido));
    }
    @GetMapping("/{id}")
    ResponseEntity<Pedido> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(pedidoService.listarPorid(id).get());
    }
    @PutMapping
    ResponseEntity<Pedido> actualizar(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.actualizar(pedido));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Pedido>> eliminar(@PathVariable(required = true) Integer id){
        pedidoService.eliminar(id);
        return ResponseEntity.ok(pedidoService.lista());
    }
}
