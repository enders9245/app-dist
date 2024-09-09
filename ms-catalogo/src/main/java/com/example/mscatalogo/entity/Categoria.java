package com.example.mscatalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Categoria {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;


}
