package com.proy.tallerDos.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "devoluciones")
public class DevolucionesModel {
	
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
	    @Column(name = "iddev")
	    int iddev;
	    
	    @Column(name = "cantidad")
	    int cantidad;
	    
	    @Column(name = "descripcion")
	    String descripcion;

	    @Column(name = "fecha")
	    Date fecha;
	    
	    @Column(name = "estado")
	    int estado;
	    
	    //relacion de muchos a uno con carrito
	    @ManyToOne
	    @JoinColumn(name = "idpedido")
	    private PedidosModel pedido;

	    //relacion de uno a uno con inventario
	    @OneToOne(mappedBy = "devoluciones")
	    private InventarioModel inventario;
	    
		

		public PedidosModel getPedido() {
			return pedido;
		}

		public void setPedido(PedidosModel pedido) {
			this.pedido = pedido;
		}

		public int getIddev() {
			return iddev;
		}

		public void setIddev(int iddev) {
			this.iddev = iddev;
		}

		

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
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
