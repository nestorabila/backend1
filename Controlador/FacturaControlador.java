package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.CredencialModel;
import com.proy.tallerDos.Model.FacturaModel;
import com.proy.tallerDos.Repo.FacturaRepo;

@RestController
public class FacturaControlador {

    @Autowired
    public FacturaRepo facturaRepo;

    @GetMapping("/api/listarfacturas")
    public List<FacturaModel> listarFacturas() {
        return facturaRepo.findAll();
    }
    
 // Registrar factura
    @PostMapping("/api/addfactura")
    public void guardarFactura(@RequestBody FacturaModel xfactura) {
        facturaRepo.save(xfactura);
    }
    
    @GetMapping("/api/ultimafactura")
    public FacturaModel obtenerUltimaFactura() {
        return facturaRepo.findLatestFactura();
    }

}