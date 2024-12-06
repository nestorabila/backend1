package com.proy.tallerDos.Controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.PersonaModel;
import com.proy.tallerDos.Model.PromocionModel;
import com.proy.tallerDos.Repo.PromocionRepo;

import jakarta.transaction.Transactional;

@RestController
public class PromocionControlador {

    @Autowired
    public PromocionRepo promocionesRepo;

    @GetMapping("/api/listarpromociones")
    public List<PromocionModel> listarPromociones() {
        return promocionesRepo.findAll();
    }

    @PostMapping("/api/addpromocion")
    public void guardarPromocion(@RequestBody PromocionModel xpromocion) {
        promocionesRepo.save(xpromocion);
    }

    @PutMapping("/api/modpromocion/{xcod}")
    public void modificarPromocion(@PathVariable Integer xcod, @RequestBody PromocionModel xpromocion) {
        xpromocion.setIdpromocion(xcod);
        promocionesRepo.save(xpromocion);
    }
    
    /*eliminar y abilitar estado----------*/
    @Transactional
	@PutMapping("/api/modpromocionEst/{xcod}")
	public int ModEstadoPromocion(@RequestBody PromocionModel xfall) {
		if(xfall.getEstado()==0)
			return  promocionesRepo.EliminarHabilitarEstado(1, xfall.getIdpromocion());
		else
			return  promocionesRepo.EliminarHabilitarEstado(0, xfall.getIdpromocion());
	}	
}