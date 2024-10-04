package com.example.lab6_20216256.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaId")
    private int peliculaId;

    @Column(nullable = false)
    @Size(min = 3, max = 100,message = "El nombre debe tener entre 3 y 100 caracteres")
    @NotBlank
    private String titulo;


    @Column(nullable = false, name = "fechaEstreno")
    @NotBlank
    private Date fechaEstreno;

    @Column(nullable = false, name = "duracionMinutos")
    @NotBlank
    @Min(value = 0, message = "Debe ser un número positivo")
    private int duracionMinutos;
}
