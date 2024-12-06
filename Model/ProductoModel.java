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
@Table(name = "producto")
public class ProductoModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproducto")
    int idproducto;
    
    @Column(name = "nombre")
    String nombre;
    
    @Column(name = "peso")
    String peso;
    
    @Column(name = "tipo_producto")
    String tipo_producto;
    
    @Column(name = "unidad_medida")
    String unidad_medida;

    @Column(name = "imagen")
    String imagen;

    @Column(name = "descripcion")
    String descripcion;

    @Column(name = "fecha")
    Date fecha;

    //relacion de Muchos a Uno con categoria
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private CategoriaModel categoria;
    
 
    
		//relacion de uno a muchos con detalle existencia_i
    @OneToMany(mappedBy = "producto")
    private Set<DetalleExistencia_IModel> detalleexistencia_i;
    
	public String getUnidad_medida() {
			return unidad_medida;
		}

		public void setUnidad_medida(String unidad_medida) {
			this.unidad_medida = unidad_medida;
		}

	public String getPeso() {
			return peso;
		}

		public void setPeso(String peso) {
			this.peso = peso;
		}

		public String getTipo_producto() {
			return tipo_producto;
		}

		public void setTipo_producto(String tipo_producto) {
			this.tipo_producto = tipo_producto;
		}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
    
    
    
}
