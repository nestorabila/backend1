package com.proy.tallerDos.Controlador;
import java.util.Date;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.CarritoModel;
import com.proy.tallerDos.Model.PersonaModel;
import com.proy.tallerDos.Repo.CarritoRepo;

import jakarta.transaction.Transactional;

@RestController
public class CarritoControlador {

    @Autowired
    public CarritoRepo carritoRepo;

    @GetMapping("/api/listarcarrito")
    public List<CarritoModel> listarCarrito() {
        return carritoRepo.findAll();
    }
    // Método para listar carritos por persona que ha iniciado sesión
    @GetMapping("/api/listarcarritopersona")
    public List<CarritoModel> listarCarritoPorPersona(@RequestHeader("idpersona") Integer idpersona) {
        return carritoRepo.findByPersonaId(idpersona);
    }
    @PostMapping("/api/addcarrito")
    public void guardarCarrito(@RequestBody CarritoModel xcarrito) {
        carritoRepo.save(xcarrito);
    }

    @PutMapping("/api/modcarrito/{xcod}")
    public void modificarCarrito(@PathVariable Integer xcod, @RequestBody CarritoModel xcarrito) {
        xcarrito.setIdcarrito(xcod);
        carritoRepo.save(xcarrito);
    }
    
    //abilitar eliminar estado: 
    @Transactional
    @PutMapping("/api/modestadocarrito/{xcod}")
    public int ModEstadoCarrito(@PathVariable Integer xcod, @RequestBody CarritoModel xfall) {
        Optional<CarritoModel> carritoOptional = carritoRepo.findById(xcod);

        if (carritoOptional.isPresent()) {
            CarritoModel carrito = carritoOptional.get();

            if (xfall.getEstado() == 0) {
                carrito.setEstado(1);
                carrito.setFecha_entrega(new Date()); // Establece la fecha de entrega actual
                carrito.setHora(Time.valueOf(LocalTime.now())); // Establece la hora actual
            } else {
                carrito.setEstado(0);
                carrito.setFecha_entrega(null); // Opcional: puedes limpiar la fecha de entrega
                carrito.setHora(null);          // Opcional: puedes limpiar la hora
            }

            carritoRepo.save(carrito);
            return 1; // Operación exitosa
        }
        
        return 0; // No se encontró el carrito
    }
    
    // Método para filtrar carritos por estado
    @GetMapping("/api/filtrarcarrito")
    public List<CarritoModel> filtrarCarrito(@RequestParam(required = false) Integer estado) {
        if (estado == null) {
            return carritoRepo.findAll(); // Retorna todos los carritos
        } else {
            return carritoRepo.findByEstado(estado); // Filtra por estado (1=Entregado, 0=Pendiente)
        }
    }
}