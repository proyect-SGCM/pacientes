package ec.edu.utpl.app.gstnmedicos.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_medicos;
	private String nombre;
	private String apellido;
	private int numero_consultorio;

	public Medico() {

	}

	public long getId_medicos() {
		return id_medicos;
	}

	public void setId_medicos(long id_medicos) {
		this.id_medicos = id_medicos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumero_consultorio() {
		return numero_consultorio;
	}

	public void setNumero_consultorio(int numero_consultorio) {
		this.numero_consultorio = numero_consultorio;
	}

	private static final long serialVersionUID = 1L;

}
