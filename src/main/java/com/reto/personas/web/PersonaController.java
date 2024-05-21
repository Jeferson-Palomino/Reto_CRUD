package com.reto.personas.web;

import com.reto.personas.domain.model.Persona;
import com.reto.personas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> findall(){return this.personaService.findAll();}

    @PostMapping
    public Persona create(@RequestBody Persona persona){return this.personaService.crear(persona);}

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, @RequestBody Persona persona){return this.personaService.update(id,persona);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){this.personaService.delete(id);}
}
