package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proy.tallerDos.Model.Existencia_IModel;

public interface Existencia_IRepo extends JpaRepository<Existencia_IModel, Integer> {
	
	 // Método para obtener el último registro basado en el ID
    @Query("SELECT e FROM Existencia_IModel e ORDER BY e.ie DESC")
    List<Existencia_IModel> findLastExistence(Pageable pageable);


}