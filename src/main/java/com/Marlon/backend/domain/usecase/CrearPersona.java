/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Marlon.backend.domain.usecase;

import com.Marlon.backend.Interfaces.PersonaService;
import com.Marlon.backend.domain.entities.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ALEX
 */
public class CrearPersona implements PersonaService{
    Persona objPersona=new Persona();
    @Override
    public List<Persona> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona add(JSONObject jsonObject) {
        try {
            int id=0;
            String name=jsonObject.get("name").toString();
            String apellidos=jsonObject.get("apellidos").toString();
            this.objPersona=new Persona(id, name, apellidos);
            return objPersona;
        } catch (JSONException ex) {
            Logger.getLogger(CrearPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Persona ObtenerPersona() {
        return this.objPersona; //To change body of generated methods, choose Tools | Templates.
    }
    
}
