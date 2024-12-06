package com.proy.tallerDos.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.CredencialModel;
import com.proy.tallerDos.Repo.CredencialRepo;

@RestController
public class CredencialControlador {

    @Autowired
    public CredencialRepo credencialRepo;

    @GetMapping("/api/listarcredenciales")
    public List<CredencialModel> listarCredenciales() {
        return credencialRepo.findAll();
    }
    
 // Registrar credencial
    @PostMapping("/api/addcredencial")
    public void guardarCredencial(@RequestBody CredencialModel xcredencial) {
        credencialRepo.save(xcredencial);
    }

    // Modificar credencial
    @PutMapping("/api/modcredencial/{usuario}")
    public void modificarCredencial(@PathVariable String usuario, @RequestBody CredencialModel xcredencial) {
        xcredencial.setUsuario(usuario);
        credencialRepo.save(xcredencial);
    }
    
 // Método para el login
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody CredencialModel credenciales) {
        Optional<CredencialModel> credencialOpt = credencialRepo.findByUsuarioAndContrasena(
                credenciales.getUsuario(), credenciales.getContrasena());

        if (credencialOpt.isPresent()) {
            CredencialModel credencial = credencialOpt.get();
            
            // Verifica si la credencial está activa
            if (credencial.getEstado() == 1) {
                return ResponseEntity.ok("Login exitoso");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cuenta deshabilitada");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
    
}