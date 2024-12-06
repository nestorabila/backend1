package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.Existencia_IModel;
import com.proy.tallerDos.Model.OfertasModel;
import com.proy.tallerDos.Model.PromocionModel;
import com.proy.tallerDos.Repo.Existencia_IRepo;
import com.proy.tallerDos.Repo.OfertasRepo;

import jakarta.transaction.Transactional;

@RestController
public class OfertasControlador {
	

    @Autowired
    public OfertasRepo ofertasRepo;
    
    // Listar existencias
    @GetMapping("/api/listarofertas")
    public List<OfertasModel> listarExistencias() {
        return ofertasRepo.findAll();
    }
    
    // Registrar existencia
    @PostMapping("/api/addofertas")
    public void guardarExistencia(@RequestBody OfertasModel existencia) {
        ofertasRepo.save(existencia);
    }

    // Modificar existencia
    @PutMapping("/api/modeofertas/{idoferta}")
    public void modificarExistencia(@PathVariable Integer idoferta, @RequestBody OfertasModel existencia) {
        existencia.setIdoferta(idoferta);
        ofertasRepo.save(existencia);
    }
  
    /*eliminar y abilitar estado----------*/
    @Transactional
	@PutMapping("/api/modofertaEst/{xcod}")
	public int ModEstadoPromocion(@RequestBody OfertasModel xfall) {
		if(xfall.getEstado()==0)
			return  ofertasRepo.EliminarHabilitarEstado(1, xfall.getIdoferta());
		else
			return  ofertasRepo.EliminarHabilitarEstado(0, xfall.getIdoferta());
	}	
}
