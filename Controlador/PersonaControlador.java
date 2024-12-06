package com.proy.tallerDos.Controlador;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.PersonaModel;
import com.proy.tallerDos.Model.RolModel;
import com.proy.tallerDos.Repo.PersonaRepo;


import jakarta.transaction.Transactional;

@RestController
public class PersonaControlador {

    @Autowired
    public PersonaRepo personaRepo;

    @GetMapping("/api/listarpersonas")
    public List<PersonaModel> listarPersonas() {
        return personaRepo.findAll();
    }
 // Registrar persona
    @PostMapping("/api/addpersona")
    public void guardarPersona(@RequestBody PersonaModel xpersona) {
        personaRepo.save(xpersona);
    }

    // Modificar persona
    @PutMapping("/api/modpersona/{xcod}")
    public void modificarPersona(@PathVariable Integer xcod, @RequestBody PersonaModel xpersona) {
        xpersona.setIdpersona(xcod);
        personaRepo.save(xpersona);
    }
    
    /*eliminar y abilitar estado----------*/
    @Transactional
	@PutMapping("/api/modPerEst/{xcod}")
	public int ModEstadoPersona(@RequestBody PersonaModel xfall) {
		if(xfall.getEstado()==0)
			return  personaRepo.EliminarHabilitarEstado(1, xfall.getIdpersona());
		else
			return  personaRepo.EliminarHabilitarEstado(0, xfall.getIdpersona());
	}	
    
 // Listar personas con rol 'Cliente'
    @GetMapping("/api/listarclientes")
    public List<PersonaModel> listarClientes() {
        List<Integer> roles = Arrays.asList(5);  // 5 es el ID del rol 'Cliente'
        return personaRepo.findByIdrolIn(roles);
    }

    // Listar personas con roles 'Administrador', 'Preventista', 'Transportista'
    @GetMapping("/api/listarpersonal")
    public List<PersonaModel> listarPersonal() {
        List<Integer> roles = Arrays.asList(0, 1,3,  2, 4);  // IDs de 'Administrador', 'Preventista', 'Transportista'
        return personaRepo.findByIdrolIn(roles);
    }
    
    // Listar personas con roles 'Administrador', 'Preventista', 'Transportista' y cliente
    @GetMapping("/api/listarpersonalcliente")
    public List<PersonaModel> listarPesrsonalCliente() {
        List<Integer> roles = Arrays.asList(0, 1,3,  2, 4, 5);  // IDs de 'Administrador', 'Preventista', 'Transportista'
        return personaRepo.findByIdrolIn(roles);
    }


    @GetMapping("/api/listarempleadotemporal")
    public List<PersonaModel> listarEmpleadoTemporal() {
        List<Integer> roles = Arrays.asList(6);  // 6 es el ID del rol 'EmpleadoTemporal'
        return personaRepo.findByIdrolIn(roles);
    }

}
