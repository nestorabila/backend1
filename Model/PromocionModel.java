package com.proy.tallerDos.Model;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class PromocionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpromocion")
    int idpromocion;

    @Column(name = "tipo")
    String tipo;

    @Column(name = "comentario")
    String comentario;
    
    @Column(name = "fecha_i")
    Date fecha_i;

    @Column(name = "fecha_f")
    Date fecha_f;
    
    @Column(name = "estado")
    int estado;
    
  //relacion de uno a mucho con detalles existencia_i
    @OneToMany(mappedBy = "promociones")
    private Set<DetalleExistencia_IModel> detalleexistencia_i;

	public int getIdpromocion() {
		return idpromocion;
	}
	

	public Date getFecha_i() {
		return fecha_i;
	}


	public void setFecha_i(Date fecha_i) {
		this.fecha_i = fecha_i;
	}


	public Date getFecha_f() {
		return fecha_f;
	}


	public void setFecha_f(Date fecha_f) {
		this.fecha_f = fecha_f;
	}


	public void setIdpromocion(int idpromocion) {
		this.idpromocion = idpromocion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
    
}