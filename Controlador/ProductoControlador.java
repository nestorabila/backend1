package com.proy.tallerDos.Controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proy.tallerDos.Model.ProductoModel;
import com.proy.tallerDos.Repo.ProductoRepo;
import com.proy.tallerDos.service.StorageService;

import jakarta.servlet.http.HttpServletRequest;

@RestController

@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    public ProductoRepo productoRepo;
    @Autowired
    private StorageService storageService;
    @Autowired
    private HttpServletRequest request;
    
 
    @GetMapping("/api/listarproductos")
    public List<ProductoModel> listarProductos() {
        return productoRepo.findAll();
    }
    
 // Registrar producto
    @PostMapping("/api/addproducto")
    public void guardarProducto(@RequestBody ProductoModel xproducto) {
        productoRepo.save(xproducto);
    }

    // Modificar producto
    @PutMapping("/api/modproducto/{xcod}")
    public void modificarProducto(@PathVariable Integer xcod, @RequestBody ProductoModel xproducto) {
        xproducto.setIdproducto(xcod);
        productoRepo.save(xproducto);
    }
    
  //eliminar  producto
  	@DeleteMapping("/api/delproducto/{xcod}")
  	public void deleteUsers(@PathVariable Integer xcod) {
  		productoRepo.deleteById(xcod);
  	}
  	
 // Listar productos por categoría
    @GetMapping("/api/listarproductosporcategoria/{idcategoria}")
    public List<ProductoModel> listarPorCategoria(@PathVariable Integer idcategoria) {
        return productoRepo.findByCategoriaIdcategoria(idcategoria);
    }
    
    //cargar imagen
    @CrossOrigin(origins = "*") 
    @PostMapping("/api/foto")
    public Map<String, String> uploadImage(@RequestParam("file") MultipartFile file) {
        String path = storageService.store(file);

        // Obtener la URL de la imagen cargada
        String host = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String imageUrl = host + "/" + path;

        return Map.of("imageUrl", imageUrl);
    }
    @CrossOrigin(origins = "*") 
 @GetMapping("/{imageName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        Resource image = storageService.loadAsResource(imageName);
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg", "image/png", "image/jpg" ) // Cambia el tipo de contenido según el formato de imagen
                .body(image);
    }
    
    
}