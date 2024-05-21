package com.reto.personas.service.impl;

import com.reto.personas.domain.model.Persona;
import com.reto.personas.repository.PersonaRepository;
import com.reto.personas.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaServiceImpl implements PersonaService {

    private  final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return this.personaRepository.findAll();
    }

    @Override
    public Persona crear(Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    public Persona update(Long id, Persona persona) {
        Optional<Persona> personaOptional = this.personaRepository.findById(id);
        if(!personaOptional.isPresent()){
            throw new RuntimeException("Persona no encontrada con id: "+ id);
        }
        Persona persona1 =  personaOptional.get();
        persona1.setNombre(persona.getNombre());
        persona1.setApellido(persona.getApellido());
        persona1.setFecha_nacimiento(persona.getFecha_nacimiento());
        persona1.setDni(persona.getDni());
        return this.personaRepository.save(persona1);
    }

    @Override
    public void delete(Long id) {
        Optional<Persona>  personaOptional = this.personaRepository.findById(id);
        if (!personaOptional.isPresent()){
            throw new RuntimeException("No se encontro a la persona con id : " + id);
        }
        this.personaRepository.deleteById(id);
    }
}
