/*
 * aqui van todos lps metodos de la interfaz persona
 */
package com.Marlon.backend.persistence.repositorio;


import com.Marlon.backend.Interfaces.PersonaService;
import com.Marlon.backend.domain.entities.PacienteE;
import com.Marlon.backend.domain.entities.Persona;
import com.Marlon.backend.persistence.controllers.PacientesJpaController;
import com.Marlon.backend.persistence.entities.Pacientes;
import com.Marlon.backend.persistence.entities.Personasdb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author ALEX
 */
public class PersonaRepositorio{
    PacientesJpaController objContUsu= new PacientesJpaController(Persistence.createEntityManagerFactory("com.Marlon_backend_jar_0.0.1-SNAPSHOTPU"));   
    private PersonaService objPersonaService;
    
    public PersonaRepositorio(PersonaService objPersonaService) {
        this.objPersonaService=objPersonaService;
    }
    
    public List<PacienteE> listar() {
        List<Pacientes> personadb=objContUsu.findPacientesEntities();
        List<PacienteE> ObjListPersona= new ArrayList<PacienteE>();
        for (Pacientes pacientesdb : personadb) {
            PacienteE objPersona= new PacienteE(pacientesdb.getIdPacientes(),pacientesdb.getFechaNacimiento(),pacientesdb.getSexo(),pacientesdb.getEstadoCivil(),pacientesdb.getOcupacion(),pacientesdb.getDireccion(),pacientesdb.getTelefono(),pacientesdb.getTipoSangre());
            ObjListPersona.add(objPersona);
        }     
        return ObjListPersona; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addRepositorio(PacienteE p) {
        //Persona objPersona=objPersonaService.ObtenerPersona();
        Pacientes objPersonasdb = new Pacientes();
        objPersonasdb.setIdPacientes(0);
        objPersonasdb.setFechaNacimiento(p.getFecha_nacimiento());
        objPersonasdb.setSexo(p.getSexo());
        objPersonasdb.setEstadoCivil(p.getOcupacion());
        objPersonasdb.setDireccion(p.getDireccion());
        objPersonasdb.setTelefono(p.getTelefono());
        objPersonasdb.setTipoSangre(p.getTipo_sangre());
        boolean g=true;
        return g;
    }     
}
  