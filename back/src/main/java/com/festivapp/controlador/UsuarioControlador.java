package com.festivapp.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.festivapp.modelo.Usuario;
import com.festivapp.repositorio.UsuarioRepositorio;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://proyecto-final-festivapp.vercel.app")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio repositorio;

	//este metodo sirve para listar todos los empleados
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosEmpleados() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el empleado
	
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}
    
	//este metodo sirve para buscar un empleado
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
		Usuario usuario = repositorio.findById(id)
					            .orElseThrow(() -> new ExcepcionesUsuario("No existe el usuario con el ID : " + id));
			return ResponseEntity.ok(usuario);
	}
	
	//este metodo sirve para actualizar empleado
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> actualizarEmpleado(@PathVariable Long id,@RequestBody Usuario detallesUsuario){
		Usuario usuario = repositorio.findById(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el empleado con el ID : " + id));
		
		usuario.setNombre(detallesUsuario.getNombre());
		usuario.setApellidos(detallesUsuario.getApellidos());
		usuario.setEmail(detallesUsuario.getEmail());
		
		Usuario usuarioActualizado = repositorio.save(usuario);
		return ResponseEntity.ok(usuarioActualizado);
    }
	
	
	
	//este metodo sirve para eliminar un empleado
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarUsuarios(@PathVariable Long id){
		Usuario usuario = repositorio.findById(id)
				            .orElseThrow(() -> new ExcepcionesUsuario("No existe el empleado con el ID : " + id));
		
		repositorio.delete(usuario);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}