package com.proy.tallerDos.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.PedidosModel;

public interface PedidosRepo extends JpaRepository<PedidosModel, Integer> {
	
	   List<PedidosModel> findByCarrito_Idcarrito(int idcarrito);
}
