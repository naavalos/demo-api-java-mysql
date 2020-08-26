package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    public String listarTodos(){
        List<Persona> listaPersonas = personaRepository.findAll();
        String jsonResponse;

        jsonResponse = "{";
        for(int i=0; i<listaPersonas.size(); i++)
        {
            jsonResponse+="{\"dni\":\"" + listaPersonas.get(i).getDni() + "\"" + ",";
            jsonResponse+="\"nombre\":\"" + listaPersonas.get(i).getNombre() + "\"" + ",";
            jsonResponse+="\"apellido\":\"" + listaPersonas.get(i).getApellido() + "\"}";

            if(listaPersonas.size()!=i+1) { jsonResponse+=",";
            }
        }
        jsonResponse+="}";

        return jsonResponse;
    }

    public String listarPersona(Integer dni){

        Optional<Persona> personaExistente = personaRepository.findByDni(dni);
        String jsonResponse;

        jsonResponse = "{\"dni\":\"" + personaExistente.get().getDni() + "\"" + ",";
        jsonResponse += "\"nombre\":\"" + personaExistente.get().getNombre() + "\"" + ",";
        jsonResponse += "\"apellido\":\"" + personaExistente.get().getApellido() + "\"}";

        return jsonResponse;
    }

    public void modificarPersona(Integer dni, Persona persona){
        persona.setDni(dni);
        persona.setNombre(persona.getNombre());
        persona.setApellido(persona.getApellido());
        personaRepository.save(persona);
    }

    @Autowired
    PersonaRepository personaRepository;
}
