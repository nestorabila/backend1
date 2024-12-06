package com.proy.tallerDos.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class InventarioModel {
	
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
	    @Column(name = "idinventario")
	    int idinventario;
	  
	    @Column(name = "fecha")
	    Date fecha;
	    
	    @Column(name = "estado")
	    int estado;

	    //relacion de uno a uno con carrito
	    @OneToOne
	    @JoinColumn(name = "idcarrito")
	    private CarritoModel carrito;
	  //relacion de uno a uno con devoluciones
	    @OneToOne
	    @JoinColumn(name = "iddev")
	    private DevolucionesModel devoluciones;
	    
	    
	    
		public CarritoModel getCarrito() {
			return carrito;
		}

		public void setCarrito(CarritoModel carrito) {
			this.carrito = carrito;
		}

		public DevolucionesModel getDevoluciones() {
			return devoluciones;
		}

		public void setDevoluciones(DevolucionesModel devoluciones) {
			this.devoluciones = devoluciones;
		}

		public int getIdinventario() {
			return idinventario;
		}

		public void setIdinventario(int idinventario) {
			this.idinventario = idinventario;
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
	    
}
