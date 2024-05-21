package com.reto.personas.service;

import com.reto.personas.domain.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    List<Persona> findAll ();
    Persona crear (Persona persona);
    Persona update(Long id, Persona persona);
    void delete(Long id);
}
