package com.proy.tallerDos.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.CarritoModel;
import com.proy.tallerDos.Model.DevolucionesModel;

public interface DevolucionesRepo extends JpaRepository<DevolucionesModel, Integer> {
}