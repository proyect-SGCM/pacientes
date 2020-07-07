/*
 * aqui van todos lps metodos de la interfaz persona
 */
package com.Marlon.backend.persistence.repositorio;


import com.Marlon.backend.Interfaces.PersonaService;
import com.Marlon.backend.domain.entities.Persona;
import com.Marlon.backend.persistence.controllers.PersonasdbJpaController;
import com.Marlon.backend.persistence.entities.Personasdb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author ALEX
 */
public class PersonaRepositorio{
    PersonasdbJpaController objContUsu= new PersonasdbJpaController(Persistence.createEntityManagerFactory("com.Marlon_backend_jar_0.0.1-SNAPSHOTPU"));   
    private PersonaService objPersonaService;
    
    public PersonaRepositorio(PersonaService objPersonaService) {
        this.objPersonaService=objPersonaService;
    }
    
    public List<Persona> listar() {
        List<Personasdb> personadb=objContUsu.findPersonasdbEntities();
        List<Persona> ObjListPersona= new ArrayList<Persona>();
        for (Personasdb personasdb : personadb) {
            Persona objPersona= new Persona(personasdb.getId(),personasdb.getName(),personasdb.getApellidos());
            ObjListPersona.add(objPersona);
        }     
        return ObjListPersona; //To change body of generated methods, choose Tools | Templates.
    }



    public boolean addRepositorio() {
        Persona objPersona=objPersonaService.ObtenerPersona();
        Personasdb objPersonasdb = new Personasdb();
        objPersonasdb.setId(objPersona.getId());
        objPersonasdb.setName(objPersona.getName());
        objPersonasdb.setApellidos(objPersona.getApellidos());
        objContUsu.create(objPersonasdb);
        boolean g=true;
        return g;
    }   
    
}
  