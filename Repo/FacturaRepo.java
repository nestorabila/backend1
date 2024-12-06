package com.proy.tallerDos.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proy.tallerDos.Model.FacturaModel;

public interface FacturaRepo extends JpaRepository<FacturaModel, Integer> {
	
	@Query(value = "SELECT * FROM facturacion ORDER BY idfact DESC LIMIT 1", nativeQuery = true)
    FacturaModel findLatestFactura();
}