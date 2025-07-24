package com.tienda.Controllers;

import com.tienda.Services.PersonaService;
import com.tienda.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Antonio
 */
@Controller
@RequestMapping("/personas")

public class PersonaController {

    @Autowired
    private PersonaService personaService;

    
@GetMapping("/lista")
public String listarPersonas (Model model) {
    model.addAttribute("personas", personaService.findAll());
    return "persona-list";
}

@GetMapping("/nuevo")
public String mostrarFormularioNuevaPersona (Model model) {
    model.addAttribute("persona", new Persona());
    return "persona-form";
}

    @PostMapping
    public String guardarPersona(Persona persona) {
        personaService.save(persona);
        return "redirect:/personas/lista"; 
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.getById(id));
        return "persona-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.delete(id);
        return "redirect:/personas/lista";
    }
}
