package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.ProductoModel;

public interface ProductoRepo extends JpaRepository<ProductoModel, Integer> {
	// Método para listar productos por categoría
    List<ProductoModel> findByCategoriaIdcategoria(Integer idcategoria);
}
