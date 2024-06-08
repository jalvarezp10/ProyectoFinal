package com.festivapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.festivapp.modelo.Festival;
import com.festivapp.modelo.Usuario;
import com.festivapp.repositorio.FestivalRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalServicio {

    @Autowired
    private FestivalRepositorio festivalRepositorio;

    public List<Festival> obtenerTodosLosFestivales() {
        return festivalRepositorio.findAll();
    }
    
    public Festival createFestival(Festival festival) {
        return festivalRepositorio.save(festival);
    }
    public Festival updateFestival(Festival festival) {
        return festivalRepositorio.save(festival);
    }
    public Optional<Festival> obtenerFestivalPorId(Long id) {
        return festivalRepositorio.findById(id);
    }
    public void deleteFestival(Long id) {
    	festivalRepositorio.deleteById(id);
    }

	
}
