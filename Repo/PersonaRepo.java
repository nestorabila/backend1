package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proy.tallerDos.Model.PersonaModel;
import com.proy.tallerDos.Model.RolModel;

public interface PersonaRepo extends JpaRepository<PersonaModel, Integer> {
	
	 /*-----------para eliminar y abilitar cod estado ----------*/
    @Modifying
    @Query(value = "update PersonaModel u set u.estado=?1 where u.idpersona=?2")
    public int EliminarHabilitarEstado(@Param("estado") int estado, @Param("idpersona") int idpersona);

    // Listar personas por múltiples roles
    @Query("SELECT p FROM PersonaModel p WHERE p.rol.idrol IN :roles")
    List<PersonaModel> findByIdrolIn(@Param("roles") List<Integer> roles);

}