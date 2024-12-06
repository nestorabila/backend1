package com.proy.tallerDos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.CarritoModel;
import com.proy.tallerDos.Model.DetalleExistencia_IModel;
import com.proy.tallerDos.Model.OfertasModel;
import com.proy.tallerDos.Model.PedidosModel;
import com.proy.tallerDos.Model.PromocionModel;
import com.proy.tallerDos.Repo.DetalleExistencia_IRepo;
@CrossOrigin(origins = "*")  // Permite solicitudes desde cualquier origen

@RestController
public class DetalleExistenciaControlador {

    @Autowired
    public DetalleExistencia_IRepo detalleExistenciaRepo;

    

    // Listar detalles de existencia
    @CrossOrigin(origins = "http://192.168.0.64")
    @GetMapping("/api/listardetallesexistencias")
    public List<DetalleExistencia_IModel> listarDetallesExistencias() {
        return detalleExistenciaRepo.findAll();
    }
    @CrossOrigin(origins = "http://192.168.0.64")
    @GetMapping("/api/listardetallesexistencias/{idexi}")
    public List<DetalleExistencia_IModel> listarDetallesExistenciasPorIdexi(@PathVariable Integer idexi) {
        return detalleExistenciaRepo.findDetallesExistenciaByIdexi(idexi);
    }


    // Registrar detalle de existencia
    @CrossOrigin(origins = "http://192.168.0.64")
    @PostMapping("/api/adddetalleexistencia")
    public void guardarDetalleExistencia(@RequestBody DetalleExistencia_IModel detalleExistencia) {
        // Crea un objeto OfertasModel con los atributos que necesitas
        OfertasModel ofertaDefault = new OfertasModel();
        ofertaDefault.setIdoferta(22220);
        ofertaDefault.setTipo("ofertas");
        ofertaDefault.setComentario("ninguno");
        ofertaDefault.setEstado(0);
        ofertaDefault.setPrecio_m(null); 
        ofertaDefault.setFecha_i(null); 
        ofertaDefault.setFecha_f(null);

        detalleExistencia.setOfertas(ofertaDefault);
        PromocionModel xpromo = new PromocionModel();
        xpromo.setEstado(0);
        xpromo.setTipo("promociones");
        xpromo.setComentario("ninguno");
        xpromo.setFecha_f(null);
        xpromo.setFecha_i(null);
        xpromo.setIdpromocion(2000);
        
        detalleExistencia.setPromociones(xpromo);
        
        System.out.println("ofertas: " + detalleExistencia.getOfertas().getIdoferta());
        detalleExistenciaRepo.save(detalleExistencia);
    }

    // Modificar detalle de existencia
    
    @PutMapping("/api/moddetalleexi/{xcod}")
    public void modificarDetalle(@PathVariable Integer xcod, @RequestBody DetalleExistencia_IModel xcarrito) {
        xcarrito.setIdd(xcod);
        detalleExistenciaRepo.save(xcarrito);
    }
}