package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.CategoriaModel;
import com.proy.tallerDos.Repo.CategoriaRepo;

@RestController
public class CategoriaControlador {

    @Autowired
    public CategoriaRepo categoriaRepo;

    @GetMapping("/api/listarcategorias")
    public List<CategoriaModel> listarCategorias() {
        return categoriaRepo.findAll();
    }
    
 // Registrar categoría
    @PostMapping("/api/addcategoria")
    public void guardarCategoria(@RequestBody CategoriaModel xcategoria) {
        categoriaRepo.save(xcategoria);
    }

    // Modificar categoría
    @PutMapping("/api/modcategoria/{xcod}")
    public void modificarCategoria(@PathVariable Integer xcod, @RequestBody CategoriaModel xcategoria) {
        xcategoria.setIdcategoria(xcod);
        categoriaRepo.save(xcategoria);
    }
    
  //eliminar categoria
  	@DeleteMapping("/api/delcategoria/{xcod}")
  	public void deleteUsers(@PathVariable Integer xcod) {
  		categoriaRepo.deleteById(xcod);
  	}
}