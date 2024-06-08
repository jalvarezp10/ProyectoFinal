package com.festivapp.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name = "festivales")
public class Festival {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_festival;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "fecha_inicio", length = 50, nullable = false)
    private Date fecha_inicio;

    @Column(name = "fecha_finalizacion", length = 50, nullable = false)
    private Date fecha_finalizacion;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;
    
    public Festival() {
    }

	public Festival(Long id_festival, String nombre, Date fecha_inicio, Date fecha_finalizacion, String ubicacion,
			String descripcion) {
		super();
		this.id_festival = id_festival;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_finalizacion = fecha_finalizacion;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
	}

	public Long getId_festival() {
		return id_festival;
	}

	public void setId_festival(Long id_festival) {
		this.id_festival = id_festival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_finalizacion() {
		return fecha_finalizacion;
	}

	public void setFecha_finalizacion(Date fecha_finalizacion) {
		this.fecha_finalizacion = fecha_finalizacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    
}

