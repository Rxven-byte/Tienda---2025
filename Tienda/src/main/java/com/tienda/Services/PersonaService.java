package com.tienda.Services;

import com.tienda.entities.Persona;
import com.tienda.repositories.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XSF
 */
@Service
public class PersonaService implements IPersonaService{
 
    @Autowired //Inyecta las dependencias
private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) this.personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> getById(Long id) {
        return this.personaRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Persona> delete(Long id) {
        Optional<Persona> persona = this.getById(id);
        if (persona.isPresent()) {
            this.personaRepository.deleteById(id);
        }
        return persona;
    }


    @Override
    @Transactional
    public Optional<Persona> update(Long id, Persona persona) {
        Optional<Persona> persona1 = this.getById(id);

        if (persona1.isPresent()) {
            // El uso de orElseThrow() para lanzar una excepción en caso de que no se
            // encuentre el producto
            Persona perso = persona1.orElseThrow();

            perso.setNombre(persona.getNombre());
            perso.setApellido(perso.getApellido());
        }
        return Optional.of((this.personaRepository.save(persona)));

    }
}