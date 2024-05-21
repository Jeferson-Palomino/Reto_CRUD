package com.reto.personas.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private int dni;

}
