package com.zoologico.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoologico.api.DTO.AnimalesDTO;
import com.zoologico.api.servicio.AnimalesServicio;

@RestController
@RequestMapping("api/animales")
public class AnimalesControlador {

	@Autowired
	private AnimalesServicio animalesServicio;
	
	@PostMapping
	public ResponseEntity<AnimalesDTO> agregarAnimal(@RequestBody AnimalesDTO animalesDtTO){
		return new ResponseEntity<>(animalesServicio.agregarAnimal(animalesDtTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<AnimalesDTO> listarAnimales(){
		return animalesServicio.listarAnimales();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalesDTO> obtenerAnimalPorId(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(animalesServicio.obtenerAnimalPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AnimalesDTO> actualizarAnimal(@RequestBody AnimalesDTO animalesDTO ,@PathVariable(name = "id") long id){
		
		AnimalesDTO animalRespuesta = animalesServicio.actualizarAnimal(animalesDTO, id);
		
		return new ResponseEntity<>(animalRespuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarAnimal(@PathVariable(name = "id") long id){
		
		animalesServicio.eliminarAnimal(id);
		
		return new ResponseEntity<>("Animal eliminado con exito", HttpStatus.OK);
	}
}
