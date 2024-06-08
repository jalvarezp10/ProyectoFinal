package com.festivapp.controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festivapp.modelo.FestivalArtista;
import com.festivapp.servicio.FestivalArtistaServicio;

@RestController
@RequestMapping("/api/v1")
public class FestivalArtistaControlador {

    @Autowired
    private FestivalArtistaServicio festivalArtistaServicio;

    @GetMapping("festival")
    public List<FestivalArtista> getAllFestivalArtistas() {
        return festivalArtistaServicio.getAllFestivalArtistas();
    }

    @GetMapping("/festival/{festivalId}")
    public Optional<FestivalArtista> getFestivalArtistasByFestivalId(@PathVariable Long festivalId) {
        return festivalArtistaServicio.getFestivalArtistasByFestivalId(festivalId);
    }

    @PostMapping
    public FestivalArtista createFestivalArtista(@RequestBody FestivalArtista festivalArtista) {
        return festivalArtistaServicio.createFestivalArtista(festivalArtista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFestivalArtista(@PathVariable Long id) {
    	festivalArtistaServicio.deleteFestivalArtista(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/festival/{festivalId}")
    public ResponseEntity<Void> deleteFestivalArtistasByFestivalId(@PathVariable Long festivalId) {
    	festivalArtistaServicio.deleteFestivalArtistasByFestivalId(festivalId);
        return ResponseEntity.noContent().build();
    }
}
