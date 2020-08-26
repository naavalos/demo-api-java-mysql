package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @GetMapping(value = "/persona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPersonas() {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.listarTodos());
    }

    @GetMapping(value = "/persona/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPersona(@PathVariable(value = "dni") Integer dni) {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.listarPersona(dni));
    }

    @PostMapping(value = "/persona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPersona(@RequestBody Persona persona) {
        //El metodo save es propio de la clase JpaRepository
        personaRepository.save(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/persona/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putPersona(@PathVariable(value = "dni") Integer dni, @RequestBody Persona persona) {
        personaService.modificarPersona(dni, persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/persona/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePersona(@PathVariable(value = "dni") Integer dni) {
        //El metodo delete es propio de la clase JpaRepository
        personaRepository.delete(personaRepository.findByDni(dni).get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaService personaService;
}
