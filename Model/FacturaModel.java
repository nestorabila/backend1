package com.proy.tallerDos.Model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturacion")
public class FacturaModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfact")
    int idfact;

    @Column(name = "hora")
    Time hora;

    @Column(name = "fecha")
    Date fecha;

    @Column(name = "cantidadmes")
    int cantidadmes;

    @Column(name = "anio")
    int anio;

    @Column(name = "montomes")
    float montomes;

    @Column(name = "descripcion")
    String descripcion;

    @Column(name = "horastrabajado")
    int horastrabajado;
    
       
    // Relación muchos a uno con PersonaModel

    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaModel persona;


	public int getIdfact() {
		return idfact;
	}


	public void setIdfact(int idfact) {
		this.idfact = idfact;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getCantidadmes() {
		return cantidadmes;
	}


	public void setCantidadmes(int cantidadmes) {
		this.cantidadmes = cantidadmes;
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public float getMontomes() {
		return montomes;
	}


	public void setMontomes(float montomes) {
		this.montomes = montomes;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getHorastrabajado() {
		return horastrabajado;
	}


	public void setHorastrabajado(int horastrabajado) {
		this.horastrabajado = horastrabajado;
	}


	public PersonaModel getPersona() {
		return persona;
	}


	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}


	

}