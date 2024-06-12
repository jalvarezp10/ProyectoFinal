package com.festivapp.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


	@Entity
	@Table(name = "grupos")
	public class Grupo {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_grupo;

	    @Column(name = "num_participantes", length = 50, nullable = false)
	    private Long num_participantes;
	    

	    @Column(name = "nombre_grupo", length = 50, nullable = false, unique = true)
	    private String nombre_grupo;
	    
	    
	    public Grupo() {
	    }

	    
		public Grupo(Long id_grupo, Long nombre, String nombre_grupo) {
			super();
			this.id_grupo = id_grupo;
			this.num_participantes = nombre;
			this.nombre_grupo = nombre_grupo;
		
		}

		public Long getId_grupo() {
			return id_grupo;
		}

		public void setId_grupo(Long id_grupo) {
			this.id_grupo = id_grupo;
		}

		public Long getNum_participantes() {
			return num_participantes;
		}

		public void setNum_participantes(Long nombre) {
			this.num_participantes = nombre;
		}

		public String getNombre_grupo() {
			return nombre_grupo;
		}

		public void setNombre_grupo(String nombre_grupo) {
			this.nombre_grupo = nombre_grupo;
		}


	    
	    

}
