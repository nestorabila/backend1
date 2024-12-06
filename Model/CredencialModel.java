package com.proy.tallerDos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "credencial")
public class CredencialModel {

    @Id
    @Column(name = "usuario")
    String usuario;

    @Column(name = "contrasena")
    String contrasena;

    @Column(name = "estado")
    int estado;

   
 // Relación uno a uno con PersonaModel
    @OneToOne
    @JoinColumn(name = "idpersona")
    private PersonaModel persona;
    
    

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
    
    
}