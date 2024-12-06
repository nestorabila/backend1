package com.proy.tallerDos.Controlador;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proy.tallerDos.Model.DetalleExistencia_IModel;
import com.proy.tallerDos.Model.PedidosModel;
import com.proy.tallerDos.Repo.DetalleExistencia_IRepo;
import com.proy.tallerDos.Repo.PedidosRepo;

@RestController
public class PedidoControlador {

    @Autowired
    public PedidosRepo pedidosRepo;
    
    @Autowired
    public DetalleExistencia_IRepo detalleExistenciaRepo;

    @GetMapping("/api/listarpedidoss")
    public List<PedidosModel> listarPedidos() {
        return pedidosRepo.findAll();
    }

    @PostMapping("/api/addpedido")
    public ResponseEntity<Map<String, String>> guardarPedido(@RequestBody PedidosModel xpedido) {
        // Obtén el detalle de existencia asociado al pedido
        DetalleExistencia_IModel detalleExistencia = xpedido.getDetalleexistencia_i();

        // Verifica si el detalle de existencia no es nulo
        if (detalleExistencia == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Detalle de existencia no encontrado"));
        }

        // Obtén el id del detalle de existencia
        int idDetalleExistencia = detalleExistencia.getIdd();

        // Busca el detalle de existencia en la base de datos usando su id
        Optional<DetalleExistencia_IModel> detalleExistenciaOptional = detalleExistenciaRepo.findById(idDetalleExistencia);

        // Verifica si se encontró el detalle de existencia
        if (!detalleExistenciaOptional.isPresent()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Detalle de existencia no encontrado en la base de datos"));
        }

        // Obtén la cantidad actual de existencias (cajas y unidades sueltas)
        DetalleExistencia_IModel detalleExistenciaActual = detalleExistenciaOptional.get();
        int cantidadActualCajas = detalleExistenciaActual.getCantidad_actual(); // Cajas completas
        int cantidadActualUnidades = detalleExistenciaActual.getCantidad_actual_u(); // Unidades sueltas en la última caja
        int unidadesPorCaja = detalleExistenciaActual.getCantidad_u(); // Unidades por caja (40 en tu caso)

        // Obtén la cantidad de cajas y unidades sueltas solicitadas en el pedido
        int cantidadPedidoCajas = xpedido.getCantidad(); // Cajas completas solicitadas
        int cantidadPedidoUnidades = xpedido.getCantidad_u_pedido(); // Unidades sueltas solicitadas

        // Verifica que las cantidades del pedido sean válidas
        if (cantidadPedidoCajas <= 0 && cantidadPedidoUnidades <= 0) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "La cantidad del pedido debe ser positiva"));
        }

        // Restar la cantidad de cajas solicitadas del stock actual
        int nuevaCantidadCajas = cantidadActualCajas - cantidadPedidoCajas;

        // Restar las unidades sueltas solicitadas de las unidades sueltas actuales
        int nuevasUnidadesRestantes = cantidadActualUnidades - cantidadPedidoUnidades;
        
        // Si las unidades solicitadas son mayores que las unidades restantes en la caja actual, ajusta las cajas completas
        if (nuevasUnidadesRestantes < 0) {
            nuevaCantidadCajas--; // Restamos una caja completa
            nuevasUnidadesRestantes = unidadesPorCaja + nuevasUnidadesRestantes; // Ajustamos las unidades faltantes
        }

        // Verifica que la nueva cantidad de cajas no sea negativa
        if (nuevaCantidadCajas < 0) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "La cantidad en stock no puede ser negativa"));
        }

        // Actualiza la cantidad actual de cajas y unidades sueltas en la entidad DetalleExistencia_IModel
        detalleExistenciaActual.setCantidad_actual(nuevaCantidadCajas); // Cajas completas
        detalleExistenciaActual.setCantidad_actual_u(nuevasUnidadesRestantes); // Unidades restantes en la última caja

        // Guarda el detalle de existencia actualizado en la base de datos
        detalleExistenciaRepo.save(detalleExistenciaActual);

        // Guarda el pedido en la base de datos
        pedidosRepo.save(xpedido);

        // Crear el mensaje de respuesta que indica cuántas cajas completas y cuántas unidades sueltas quedan
        String respuesta = "Cantidad Actual (Mayor): " + nuevaCantidadCajas + " cajas completas. "
                         + "Cantidad Actual (Unitario): " + nuevasUnidadesRestantes + " unidades más para completar la caja.";

        // Crea un mapa para la respuesta exitosa
        Map<String, String> response = new HashMap<>();
        response.put("message", "Pedido registrado y stock actualizado exitosamente");
        response.put("detalle", respuesta); // Incluye el detalle de cantidades restantes

        // Retorna la respuesta como JSON
        return ResponseEntity.ok(response);
    }


    
    @GetMapping("/api/listarpedidos/{idcarrito}")
    public List<PedidosModel> listarPedidosPorCarrito(@PathVariable int idcarrito) {
        return pedidosRepo.findByCarrito_Idcarrito(idcarrito);
    }
    
  //eliminar  pedido
  	@DeleteMapping("/api/delpedido/{xcod}")
  	public void deleteUsers(@PathVariable Integer xcod) {
  		pedidosRepo.deleteById(xcod);
  	}

    @PutMapping("/api/modpedido/{xcod}")
    public void modificarPedido(@PathVariable Integer xcod, @RequestBody PedidosModel xpedido) {
        xpedido.setIdpedido(xcod);
        pedidosRepo.save(xpedido);
    }
}