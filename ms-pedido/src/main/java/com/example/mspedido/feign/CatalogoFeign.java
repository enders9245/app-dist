package com.example.mspedido.feign;

import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="ms-catalogo-service",path = "/producto")
public interface CatalogoFeign {
    /*@GetMapping("/{id}")
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallBackProducto")
    ResponseEntity<ProductoDto> listaPorld(@PathVariable(required = true) Integer id);
    default ResponseEntity<ProductoDto>fallBackProducto(Integer id, Exception e) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(9000000);
        return  ResponseEntity.ok(productoDto);
    }*/

}
