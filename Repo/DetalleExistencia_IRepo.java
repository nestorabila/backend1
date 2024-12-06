package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proy.tallerDos.Model.DetalleExistencia_IModel;
import com.proy.tallerDos.Model.PedidosModel;


public interface DetalleExistencia_IRepo extends JpaRepository<DetalleExistencia_IModel, Integer> {

	 // Modificar la consulta para usar el campo idexi
    @Query("SELECT d FROM DetalleExistencia_IModel d WHERE d.existencia_i.idexi = :idexi")
    List<DetalleExistencia_IModel> findDetallesExistenciaByIdexi(@Param("idexi") Integer idexi);


}