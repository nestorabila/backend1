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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleexistencia_i")
public class DetalleExistencia_IModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	    @Column(name = "idd")
	    int idd;
	 
	   @Column(name = "lote")
	    int lote;

	    @Column(name = "comentario")
	    String comentario;

	    @Column(name = "fecha_v")
	    Date fecha_v;
	    
	    @Column(name = "peso")
	    String peso;
	    
	    @Column(name = "envase")
	    String envase;
	   
	    @Column(name = "cantidad_t")
	    int cantidad_t;
	    
	    @Column(name = "cantidad_actual")
	    int cantidad_actual;
	    
	    @Column(name = "cantidad_actual_u")
	    int cantidad_actual_u;
	    
	    @Column(name = "cantidad_u")
	    int cantidad_u;

	    @Column(name = "precio_c")
	    float precio_c;

	    @Column(name = "precio_v")
	    float precio_v;
	    
	    @Column(name = "precio_unitario_v")
	    float precio_unitario_v;

	    @Column(name = "hora")
	    java.sql.Time hora;

	    @Column(name = "fecha_r")
	    Date fecha_r;

	    @Column(name = "estado")
	    int estado;
	    
	    
	    //relacion de uno a uno con pedidos
	   
	    @OneToMany(mappedBy = "detalleexistencia_i")
	    private Set<PedidosModel> pedido;
	    
	    //relacion de muchos a uno con existencia_i
	    @ManyToOne
		@JoinColumn(name = "ie")
		private Existencia_IModel existencia_i;
	    
	  //relacion de uno a uno con producto
	    @ManyToOne
		@JoinColumn(name = "idproducto")
		private ProductoModel producto;
	    
	  //relacion de muchos a uno con ofertas
	
	    @ManyToOne
	    @JoinColumn(name = "idoferta")
	    private OfertasModel ofertas;
	    
	    
	  //relacion de muchos a uno con promociones
	    @ManyToOne
	    @JoinColumn(name = "idpromocion")
	    private PromocionModel promociones;
//	    
	    

		public OfertasModel getOfertas() {
			return ofertas;
		}

		public ProductoModel getProducto() {
			return producto;
		}

		public void setProducto(ProductoModel producto) {
			this.producto = producto;
		}

		public float getPrecio_unitario_v() {
			return precio_unitario_v;
		}

		public void setPrecio_unitario_v(float precio_unitario_v) {
			this.precio_unitario_v = precio_unitario_v;
		}

		public int getCantidad_actual_u() {
			return cantidad_actual_u;
		}

		public void setCantidad_actual_u(int cantidad_actual_u) {
			this.cantidad_actual_u = cantidad_actual_u;
		}

		public int getCantidad_actual() {
			return cantidad_actual;
		}

		public void setCantidad_actual(int cantidad_actual) {
			this.cantidad_actual = cantidad_actual;
		}

		public PromocionModel getPromociones() {
			return promociones;
		}

		public void setPromociones(PromocionModel promociones) {
			this.promociones = promociones;
		}

		public void setOfertas(OfertasModel ofertas) {
			this.ofertas = ofertas;
		}


		public Existencia_IModel getExistencia_i() {
			return existencia_i;
		}

		

		public void setExistencia_i(Existencia_IModel existencia_i) {
			this.existencia_i = existencia_i;
		}

		public int getLote() {
			return lote;
		}

		public void setLote(int lote) {
			this.lote = lote;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public Date getFecha_v() {
			return fecha_v;
		}

		public void setFecha_v(Date fecha_v) {
			this.fecha_v = fecha_v;
		}

		public String getPeso() {
			return peso;
		}

		public void setPeso(String peso) {
			this.peso = peso;
		}

		public String getEnvase() {
			return envase;
		}

		public void setEnvase(String envase) {
			this.envase = envase;
		}

		public int getCantidad_t() {
			return cantidad_t;
		}

		public void setCantidad_t(int cantidad_t) {
			this.cantidad_t = cantidad_t;
		}

		public int getCantidad_u() {
			return cantidad_u;
		}

		public void setCantidad_u(int cantidad_u) {
			this.cantidad_u = cantidad_u;
		}

		public float getPrecio_c() {
			return precio_c;
		}

		public int getIdd() {
			return idd;
		}

		public void setIdd(int idd) {
			this.idd = idd;
		}

		public void setPrecio_c(float precio_c) {
			this.precio_c = precio_c;
		}

		public float getPrecio_v() {
			return precio_v;
		}

		public void setPrecio_v(float precio_v) {
			this.precio_v = precio_v;
		}

		public java.sql.Time getHora() {
			return hora;
		}

		public void setHora(java.sql.Time hora) {
			this.hora = hora;
		}

		public Date getFecha_r() {
			return fecha_r;
		}

		public void setFecha_r(Date fecha_r) {
			this.fecha_r = fecha_r;
		}

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}


}
