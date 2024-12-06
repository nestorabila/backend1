package com.proy.tallerDos.Model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class RolModel {
	
	 @Id
	    @Column(name = "idrol")
	    int idrol;

	    @Column(name = "nombre")
	    String nombre;

	    @Column(name = "estado")
	    int estado;
	    


	 // Relación uno a muchos con PersonaModel
	    @OneToMany(mappedBy = "rol")
	    private Set<PersonaModel> persona;

		public int getIdrol() {
			return idrol;
		}


		public void setIdrol(int idrol) {
			this.idrol = idrol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}

}
