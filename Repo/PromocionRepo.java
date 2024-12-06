package com.proy.tallerDos.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proy.tallerDos.Model.PromocionModel;

public interface PromocionRepo extends JpaRepository<PromocionModel, Integer> {
	 /*-----------para eliminar y abilitar cod estado ----------*/
	 /*-----------para eliminar y abilitar cod estado ----------*/
    @Modifying
    @Query(value = "update PromocionModel u set u.estado=?1 where u.idpromocion=?2")
    public int EliminarHabilitarEstado(@Param("estado") int estado, @Param("idpromocion") int idpromocion);
}