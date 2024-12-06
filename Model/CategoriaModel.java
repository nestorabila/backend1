package com.proy.tallerDos.Model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategoria")
    int idcategoria;

    @Column(name = "nombre")
    String nombre;
    
    //relacion de Uno a Muchos con Producto
    @OneToMany(mappedBy = "categoria")
    private Set<ProductoModel> producto;

    

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
}
