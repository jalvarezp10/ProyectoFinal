package com.festivapp.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.festivapp.modelo.Grupo;
import com.festivapp.servicio.GrupoServicio;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://proyecto-final-festivapp.vercel.app/")
public class GrupoControlador {

    @Autowired
    private GrupoServicio grupoServicio;

    @GetMapping("/grupos")
    public List<Grupo> obtenerTodosLosFestivales() {
        return grupoServicio.obtenerTodosLosGrupos();
    }
    @PostMapping("/grupos")
	public Grupo guardarFestival(@RequestBody Grupo grupos) {
		return grupoServicio.createGrupo(grupos);
	}
    @GetMapping("/grupos/{id}")
    public ResponseEntity<Grupo> obtenerFestivalPorId(@PathVariable Long id) {
        Optional<Grupo> grupos = grupoServicio.obtenerGrupoPorId(id);
        return grupos.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/grupos/{id}")
	public ResponseEntity<Grupo> actualizarFestival(@PathVariable Long id,@RequestBody Grupo detallesGrupo){
    	Grupo grupos = grupoServicio.obtenerGrupoPorId(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el festival con el ID : " + id));
		
    	grupos.setNombre_grupo(detallesGrupo.getNombre_grupo());
    	grupos.setNum_participantes(detallesGrupo.getNum_participantes());
    	
    	
    	
    	
		
    	Grupo grupoActualizado = grupoServicio.createGrupo(grupos);
		return ResponseEntity.ok(grupoActualizado);
    }
    
    
    @DeleteMapping("/grupos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarFestival(@PathVariable Long id){
    	Grupo grupos = grupoServicio.obtenerGrupoPorId(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el grupo con el ID : " + id));
		
    	grupoServicio.deleteGrupo(grupos.getId_grupo());
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
