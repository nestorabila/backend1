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

import com.proy.tallerDos.Model.DevolucionesModel;
import com.proy.tallerDos.Repo.DevolucionesRepo;


@RestController
public class DevolucionesControlador {

    @Autowired
    public DevolucionesRepo devolucionesRepo;

    @GetMapping("/api/listardevoluciones")
    public List<DevolucionesModel> listarDevoluciones() {
        return devolucionesRepo.findAll();
    }

    @PostMapping("/api/adddevoluciones")
    public void guardarDevoluciones(@RequestBody DevolucionesModel xdevolucion) {
        devolucionesRepo.save(xdevolucion);
    }

    @PutMapping("/api/moddevoluciones/{xcod}")
    public void modificarDevoluciones(@PathVariable Integer xcod, @RequestBody DevolucionesModel xdevolucion) {
        xdevolucion.setIddev(xcod);
        devolucionesRepo.save(xdevolucion);
    }
}