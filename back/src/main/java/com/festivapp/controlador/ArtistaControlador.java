package com.festivapp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festivapp.excepciones.ExcepcionesUsuario;
import com.festivapp.modelo.Artista;
import com.festivapp.modelo.Festival;
import com.festivapp.servicio.ArtistaServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://proyecto-final-festivapp.vercel.app")
public class ArtistaControlador {

    @Autowired
    private ArtistaServicio artistaServicio;

    @GetMapping("/artistas")
    public List<Artista> obtenerTodosLosArtistas() {
        return artistaServicio.obtenerTodosLosArtista();
    }

    @GetMapping("/artistas/{id}")
    public ResponseEntity<Artista> obtenerFestivalPorId(@PathVariable Long id) {
        Optional<Artista> artista = artistaServicio.obtenerArtistaPorId(id);
        return artista.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/artistas/{id}")
   	public ResponseEntity<Artista> actualizarArtista(@PathVariable Long id,@RequestBody Artista detallesArtista){
       	Artista artista = artistaServicio.obtenerArtistaPorId(id)
   				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el artista con el ID : " + id));
   		
       	artista.setNombre(detallesArtista.getNombre());
       	artista.setGenero_musical(detallesArtista.getGenero_musical());
       	artista.setDescripcion(detallesArtista.getDescripcion());
       	
   		
       	Artista artistaActualizado = artistaServicio.createArtista(artista);
   		return ResponseEntity.ok(artistaActualizado);
       }
       
       
       @DeleteMapping("/artistas/{id}")
   	public ResponseEntity<Map<String,Boolean>> eliminarFestival(@PathVariable Long id){
    	   Artista artista = artistaServicio.obtenerArtistaPorId(id)
   				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el festival con el ID : " + id));
   		
       	artistaServicio.deleteArtista(artista.getId_artista());
   		Map<String, Boolean> respuesta = new HashMap<>();
   		respuesta.put("eliminar",Boolean.TRUE);
   		return ResponseEntity.ok(respuesta);
       }
}
