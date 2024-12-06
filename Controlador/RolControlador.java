package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.RolModel;
import com.proy.tallerDos.Repo.RolRepo;


@RestController
public class RolControlador {

    @Autowired
    public RolRepo rolRepo;

    @GetMapping("/api/listarrol")
    public List<RolModel> listarRoles() {
        return rolRepo.findAll();
    }
    
    // Modificar rol
    @PutMapping("/api/modrol/{xcod}")
    public void modificarRol(@PathVariable Integer xcod, @RequestBody RolModel xrol) {
        xrol.setIdrol(xcod);
        rolRepo.save(xrol);
    }
}