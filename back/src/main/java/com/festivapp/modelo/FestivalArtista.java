
package com.festivapp.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "festival_artistas")
public class FestivalArtista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_festival")
    private Long festivalId;

    @Column(name = "id_artista")
    private Long artistaId;
    				
    
    public FestivalArtista(Long id, Long festivalId, Long artistaId) {
		super();
		this.id = id;
		this.festivalId = festivalId;
		this.artistaId = artistaId;
	}

	// Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Long festivalId) {
        this.festivalId = festivalId;
    }

    public Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Long artistaId) {
        this.artistaId = artistaId;
    }
}
