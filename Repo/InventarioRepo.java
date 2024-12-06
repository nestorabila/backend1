package com.proy.tallerDos.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.CarritoModel;
import com.proy.tallerDos.Model.InventarioModel;

public interface InventarioRepo extends JpaRepository<InventarioModel, Integer> {
}