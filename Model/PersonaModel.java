package com.proy.tallerDos.Model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonaModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpersona")
    int idpersona;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "ap_paterno")
    String ap_paterno;

    @Column(name = "ap_materno")
    String ap_materno;

    @Column(name = "cedula")
    String cedula;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "genero")
    Integer genero;

    @Column(name = "direccion")
    String direccion;

    @Column(name = "referencias")
    String referencias;

    @Column(name = "antecedentes")
    String antecedentes;

    @Column(name = "edad")
    int edad;

    @Column(name = "fecha")
    Date fecha;

    @Column(name = "hora")
    Time hora;

    @Column(name = "estado")
    int estado;
    
 // Relación uno a uno con CredencialModel
    @OneToOne(mappedBy = "persona")
    private CredencialModel credencial;

    // Relación muchos a uno con RolModel
    @ManyToOne
    @JoinColumn(name = "idrol")
    private RolModel rol;

    // Relación uno a muchos con FacturaModel
    @OneToMany(mappedBy = "persona")
    private Set<FacturaModel> facturacion;
    
//    relacion Uno a muchos con carrito
    @OneToMany(mappedBy = "persona")
    private Set<CarritoModel> carrito;
    

	public RolModel getRol() {
		return rol;
	}

	public void setRol(RolModel rol) {
		this.rol = rol;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
    
}