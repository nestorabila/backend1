package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proy.tallerDos.Model.CarritoModel;

public interface CarritoRepo extends JpaRepository<CarritoModel, Integer> {
	
	/*-----------para eliminar y abilitar cod estado ----------*/
    @Modifying
    @Query(value = "update CarritoModel u set u.estado=?1 where u.idcarrito=?2")
    public int EliminarHabilitarEstado(@Param("estado") int estado, @Param("idcarrito") int idcarrito);
    
    // Método para buscar carritos por persona
    @Query("SELECT c FROM CarritoModel c WHERE c.persona.idpersona = :idpersona")
    List<CarritoModel> findByPersonaId(@Param("idpersona") Integer idpersona);

    
    // Método para buscar carritos por estado
    List<CarritoModel> findByEstado(int estado);
}