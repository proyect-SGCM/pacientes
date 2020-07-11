/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Marlon.backend;

import com.Marlon.backend.Interfaces.PersonaService;
import com.Marlon.backend.domain.entities.PacienteE;
import com.Marlon.backend.domain.entities.Persona;
import com.Marlon.backend.domain.usecase.CrearPersona;
import com.Marlon.backend.persistence.repositorio.PersonaRepositorio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import javax.validation.Valid;
/**
 *
 * @author ALEX
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
//@RequestMapping({"/personas"})
@Controller
public class Controlador {
    @Autowired
    
   // @GetMapping//(method=RequestMethod.GET)
    @RequestMapping(value="/pacientes",method = RequestMethod.GET)
    public List<PacienteE>listar(){
        PersonaService objPersonaService = new CrearPersona();
        PersonaRepositorio objPersonaRepositorio=new PersonaRepositorio(objPersonaService);
        return objPersonaRepositorio.listar();
    }
    /*
    @RequestMapping(value="/personas",method = RequestMethod.GET)
    public List<Persona>listar(){
        PersonaService objPersonaService = new CrearPersona();
        PersonaRepositorio objPersonaRepositorio=new PersonaRepositorio(objPersonaService);
        return objPersonaRepositorio.listar();
    }
     */
    @RequestMapping(value="/paciente",method=RequestMethod.POST)
    public boolean agregar(PacienteE p){
            boolean g=false;

            PersonaService objPersonaService = new CrearPersona();
           // objPersonaService.add(jsonObject);
            PersonaRepositorio objPersonaRepositorio=new PersonaRepositorio(objPersonaService);
            g=objPersonaRepositorio.addRepositorio(p);
        
         return g;//service.add(p);
    }

     
    
    
    
    
    
}
