/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Marlon.backend.Interfaces;

import com.Marlon.backend.domain.entities.Persona;
import java.util.List;
import org.json.JSONObject;

public interface PersonaService {
    List<Persona>listar();
    Persona add(JSONObject jsonObject);
    //Persona edit(Persona p);
    //Persona delete(int id);
    Persona ObtenerPersona();
    
}
