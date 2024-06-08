package com.festivapp.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_artista;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "genero_musical", length = 50, nullable = false)
    private String genero_musical;

    @Column(name = "descripcion", length = 255, nullable = false, unique = true)
    private String descripcion;

    

    public Artista() {

    }



	public Artista(Long id_artista, String nombre, String genero_musical, String descripcion) {
		super();
		this.id_artista = id_artista;
		this.nombre = nombre;
		this.genero_musical = genero_musical;
		this.descripcion = descripcion;
	}



	public Long getId_artista() {
		return id_artista;
	}



	public void setId_artista(Long id_artista) {
		this.id_artista = id_artista;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getGenero_musical() {
		return genero_musical;
	}



	public void setGenero_musical(String genero_musical) {
		this.genero_musical = genero_musical;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    
}
