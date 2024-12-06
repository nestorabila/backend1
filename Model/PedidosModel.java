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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidosModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpedido")
    int idpedido;

    @Column(name = "cantidad")
    int cantidad;
    
    @Column(name = "cantidad_u_pedido")
    int cantidad_u_pedido;
    
    @Column(name = "tipo")
    String tipo;
    
    
  //relacion de uno a muchos con detalles existencia
  
    @ManyToOne
    @JoinColumn(name = "idd")
    private DetalleExistencia_IModel detalleexistencia_i;
    
    
//    relacion de  muchos a uno con carrito
    @ManyToOne
    @JoinColumn(name = "idcarrito")
    private CarritoModel carrito;
    
    
    //relacion de uno a muchos devoluciones
    @OneToMany(mappedBy = "pedido")
    private Set<DevolucionesModel> devoluciones;


	public int getCantidad_u_pedido() {
		return cantidad_u_pedido;
	}


	public void setCantidad_u_pedido(int cantidad_u_pedido) {
		this.cantidad_u_pedido = cantidad_u_pedido;
	}


	public int getIdpedido() {
		return idpedido;
	}



	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getTipo() {
		return tipo;
	}


	public DetalleExistencia_IModel getDetalleexistencia_i() {
		return detalleexistencia_i;
	}


	public void setDetalleexistencia_i(DetalleExistencia_IModel detalleexistencia_i) {
		this.detalleexistencia_i = detalleexistencia_i;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public CarritoModel getCarrito() {
		return carrito;
	}


	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}
   
    
}