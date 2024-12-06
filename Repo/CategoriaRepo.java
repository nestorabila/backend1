package com.proy.tallerDos.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.CategoriaModel;

public interface CategoriaRepo extends JpaRepository<CategoriaModel, Integer> {
}

