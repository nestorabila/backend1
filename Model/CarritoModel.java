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
@Table(name = "carrito")
public class CarritoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcarrito")
    int idcarrito;
    
    @Column(name = "nombre")
    String nombre;

    @Column(name = "fecha")
    Date fecha;
    
    @Column(name = "fecha_entrega")
    Date fecha_entrega;
    
    @Column(name = "hora")
    Time hora;

    @Column(name = "estado")
    int estado;  
    
//    relacion de Muchos  Uno con persona
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaModel persona;
    
    //relacion de uno a muchos con pedido
    @OneToMany(mappedBy = "carrito")
    private Set<PedidosModel> pedido;

    //relacion de uno a uno con inventario
    @OneToOne(mappedBy = "carrito")
    private InventarioModel inventario;
    

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public int getIdcarrito() {
		return idcarrito;
	}

	public void setIdcarrito(int idcarrito) {
		this.idcarrito = idcarrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
    
    
}
