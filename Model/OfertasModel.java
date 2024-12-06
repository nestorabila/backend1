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
@Table(name = "ofertas")
public class OfertasModel {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idoferta")
    int idoferta;

    @Column(name = "tipo")
    String tipo;

    @Column(name = "precio_m")
    Float precio_m;


    @Column(name = "comentario")
    String comentario;

    @Column(name = "fecha_i")
    Date fecha_i;

    @Column(name = "fecha_f")
    Date fecha_f;

    @Column(name = "estado")
    int estado;
    //relacion de uno a mucho con detalles existencia_i
    
    @OneToMany(mappedBy = "ofertas")
    private Set<DetalleExistencia_IModel> detalleexistencia_i;

	public int getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getPrecio_m() {
		return precio_m;
	}

	public void setPrecio_m(Float precio_m) {
		this.precio_m = precio_m;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
 
    
}
