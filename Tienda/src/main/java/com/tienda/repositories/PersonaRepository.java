package com.tienda.repositories;

/**
 *
 * @author Antonio
 */

import com.tienda.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
    
}


