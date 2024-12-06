package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.Existencia_IModel;
import com.proy.tallerDos.Model.ProductoModel;
import com.proy.tallerDos.Model.ProveedorModel;

import com.proy.tallerDos.Repo.Existencia_IRepo;
import com.proy.tallerDos.Repo.ProductoRepo;
import com.proy.tallerDos.Repo.ProveedorRepo;


@RestController
public class ExistenciaControlador {

    @Autowired
    public Existencia_IRepo existenciaRepo;
  

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private ProveedorRepo proveedorRepo;

    // Listar existencias
    @GetMapping("/api/listarexistencias")
    public List<Existencia_IModel> listarExistencias() {
        return existenciaRepo.findAll();
    }
    // Listar solo la última existencia registrada
 // Controlador
    @GetMapping("/api/ultimaexistencia")
    public Existencia_IModel obtenerUltimaExistencia() {
        List<Existencia_IModel> ultimasExistencias = existenciaRepo.findLastExistence(PageRequest.of(0, 1)); // Limitar a 1
        return ultimasExistencias.isEmpty() ? null : ultimasExistencias.get(0);
    }


    // Registrar existencia
    @PostMapping("/api/addexistencia")
    public void guardarExistencia(@RequestBody Existencia_IModel existencia) {
    	 System.out.println("Datos recibidos: " + existencia);
        existenciaRepo.save(existencia);
    }

    // Modificar existencia
    @PutMapping("/api/modexistencia/{idexi}")
    public void modificarExistencia(@PathVariable Integer idexi, @RequestBody Existencia_IModel existencia) {
        existencia.setIdexi(idexi);
        existenciaRepo.save(existencia);
    }
 // 
}