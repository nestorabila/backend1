package com.proy.tallerDos.Model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class ProveedorModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproveedor")
    int idproveedor;

    @Column(name = "nombre")
    String nombre;
    
    @Column(name = "razon_social")
    String razon_social;

    @Column(name = "email")
    String email;

    @Column(name = "direccion")
    String direccion;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "fecha")
    Date fecha;
    
    //relacion de uno a muchos con existencia_i
    @OneToMany(mappedBy = "proveedor")
    private Set<Existencia_IModel> existencia_i;



	public String getRazon_social() {
			return razon_social;
		}

		public void setRazon_social(String razon_social) {
			this.razon_social = razon_social;
		}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
    
}

