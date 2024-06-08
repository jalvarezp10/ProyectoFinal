package com.festivapp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festivapp.excepciones.ExcepcionesUsuario;
import com.festivapp.modelo.Festival;
import com.festivapp.modelo.Usuario;
import com.festivapp.servicio.FestivalServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class FestivalControlador {

    @Autowired
    private FestivalServicio festivalServicio;

    @GetMapping("/festivales")
    public List<Festival> obtenerTodosLosFestivales() {
        return festivalServicio.obtenerTodosLosFestivales();
    }
    @PostMapping("/festivales")
	public Festival guardarFestival(@RequestBody Festival festival) {
		return festivalServicio.createFestival(festival);
	}
    @GetMapping("/festivales/{id}")
    public ResponseEntity<Festival> obtenerFestivalPorId(@PathVariable Long id) {
        Optional<Festival> festival = festivalServicio.obtenerFestivalPorId(id);
        return festival.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/festivales/{id}")
	public ResponseEntity<Festival> actualizarFestival(@PathVariable Long id,@RequestBody Festival detallesFestival){
    	Festival festival = festivalServicio.obtenerFestivalPorId(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el festival con el ID : " + id));
		
    	festival.setNombre(detallesFestival.getNombre());
    	festival.setFecha_inicio(detallesFestival.getFecha_inicio());
    	festival.setFecha_finalizacion(detallesFestival.getFecha_finalizacion());
    	festival.setUbicacion(detallesFestival.getUbicacion());
    	festival.setDescripcion(detallesFestival.getDescripcion());
    	
		
    	Festival festivalActualizado = festivalServicio.createFestival(festival);
		return ResponseEntity.ok(festivalActualizado);
    }
    
    
    @DeleteMapping("/festivales/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarFestival(@PathVariable Long id){
    	Festival festival = festivalServicio.obtenerFestivalPorId(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el festival con el ID : " + id));
		
		festivalServicio.deleteFestival(festival.getId_festival());
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
