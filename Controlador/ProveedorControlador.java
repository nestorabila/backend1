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

import com.proy.tallerDos.Model.ProveedorModel;
import com.proy.tallerDos.Repo.ProveedorRepo;

@RestController
public class ProveedorControlador {

    @Autowired
    public ProveedorRepo proveedorRepo;

    @GetMapping("/api/listarproveedores")
    public List<ProveedorModel> listarProveedores() {
        return proveedorRepo.findAll();
    }
    
 // Registrar proveedor
    @PostMapping("/api/addproveedor")
    public void guardarProveedor(@RequestBody ProveedorModel xproveedor) {
        proveedorRepo.save(xproveedor);
    }

    // Modificar proveedor
    @PutMapping("/api/modproveedor/{xcod}")
    public void modificarProveedor(@PathVariable Integer xcod, @RequestBody ProveedorModel xproveedor) {
        xproveedor.setIdproveedor(xcod);
        proveedorRepo.save(xproveedor);
    }
    
    
  //eliminar proveedor
  	@DeleteMapping("/api/delproveedor/{xcod}")
  	public void deleteUsers(@PathVariable Integer xcod) {
  		proveedorRepo.deleteById(xcod);
  	} 
}