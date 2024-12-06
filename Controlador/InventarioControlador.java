package com.proy.tallerDos.Controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.InventarioModel;
import com.proy.tallerDos.Repo.InventarioRepo;

@RestController
public class InventarioControlador {

    @Autowired
    public InventarioRepo inventarioRepo;

    @GetMapping("/api/listarinventario")
    public List<InventarioModel> listarInventario() {
        return inventarioRepo.findAll();
    }

    @PostMapping("/api/addinventario")
    public void guardarInventario(@RequestBody InventarioModel xinventario) {
        inventarioRepo.save(xinventario);
    }

    @PutMapping("/api/modinventario/{xcod}")
    public void modificarInventario(@PathVariable Integer xcod, @RequestBody InventarioModel xinventario) {
        xinventario.setIdinventario(xcod);
        inventarioRepo.save(xinventario);
    }
}