package com.tienda.Services;

import com.tienda.entities.Persona;
import java.util.List; 
import java.util.Optional;

/**
 *
 * @author XSF
 */
public interface IPersonaService {

    public List<Persona> findAll();

    public Persona save(Persona persona);

    public Optional<Persona> getById(Long Id);

    public Optional<Persona> delete(Long Id);

    public Optional<Persona> update(Long id, Persona persona);

}
