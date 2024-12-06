package com.proy.tallerDos.Model;

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
@Table(name = "existencia_i")
public class Existencia_IModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ie")
	int ie;
	
	@Column(name = "idexi")
	int idexi;

	@Column(name = "estado")
	int estado;

	//relacion de muchos a uno con proveedor
	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private ProveedorModel proveedor;
	
	//ralacion de uno a muchos con detalle existencia_i
	@OneToMany(mappedBy = "existencia_i")
    private Set<DetalleExistencia_IModel> detalleexistencia_i;
	
	public ProveedorModel getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModel proveedor) {
		this.proveedor = proveedor;
	}

	public int getIe() {
		return ie;
	}

	public void setIe(int ie) {
		this.ie = ie;
	}

	public int getIdexi() {
		return idexi;
	}

	public void setIdexi(int idexi) {
		this.idexi = idexi;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
