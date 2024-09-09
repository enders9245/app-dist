package com.example.mspedido.dto;

import lombok.Data;

@Data

public class ClienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String phone;
}
