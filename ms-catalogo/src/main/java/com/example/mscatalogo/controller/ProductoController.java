package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import com.example.mscatalogo.service.CategoriaService;
import com.example.mscatalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> listar(){
        return ResponseEntity.ok(productoService.listar());
    }

    @PostMapping
    public ResponseEntity<Producto>guardar(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @PutMapping
    public ResponseEntity<Producto>actualizar(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizar(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(productoService.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Producto>>eliminar(@PathVariable(required = true) Integer id){
        productoService.eliminar(id);
        return ResponseEntity.ok(productoService.listar());
    }
}
