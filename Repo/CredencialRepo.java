package com.proy.tallerDos.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.tallerDos.Model.CredencialModel;

public interface CredencialRepo extends JpaRepository<CredencialModel, String> {
	
	// Método para buscar por usuario y contraseña
    Optional<CredencialModel> findByUsuarioAndContrasena(String usuario, String contrasena);
 // Método para buscar solo por usuario
    Optional<CredencialModel> findByUsuario(String usuario);

}