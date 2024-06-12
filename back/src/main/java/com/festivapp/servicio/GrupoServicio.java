package com.festivapp.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.festivapp.modelo.Grupo;
import com.festivapp.repositorio.GrupoRepositorio;

@Service
public class GrupoServicio {
	
	 @Autowired
	    private GrupoRepositorio grupoRepositorio;

	    public List<Grupo> obtenerTodosLosGrupos() {
	        return grupoRepositorio.findAll();
	    }
	    
	    public Grupo createGrupo(Grupo grupo) {
	        return grupoRepositorio.save(grupo);
	    }
	    public Grupo updateGrupo(Grupo grupo) {
	        return grupoRepositorio.save(grupo);
	    }
	    public Optional<Grupo> obtenerGrupoPorId(Long id) {
	        return grupoRepositorio.findById(id);
	    }
	    public void deleteGrupo(Long id) {
	    	grupoRepositorio.deleteById(id);
	    }

}
