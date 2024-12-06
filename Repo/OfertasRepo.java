package com.proy.tallerDos.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proy.tallerDos.Model.OfertasModel;
import com.proy.tallerDos.Model.ProductoModel;

public interface OfertasRepo extends JpaRepository<OfertasModel, Integer> {
	@Modifying
    @Query(value = "update OfertasModel u set u.estado=?1 where u.idoferta=?2")
    public int EliminarHabilitarEstado(@Param("estado") int estado, @Param("idoferta") int idoferta);

}
