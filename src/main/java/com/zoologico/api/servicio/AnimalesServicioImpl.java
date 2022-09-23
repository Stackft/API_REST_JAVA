package com.zoologico.api.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoologico.api.DTO.AnimalesDTO;
import com.zoologico.api.entidad.Animales;
import com.zoologico.api.excepcion.ResourceNotFoundException;
import com.zoologico.api.repositorio.AnimalesRepositorio;

@Service
public class AnimalesServicioImpl implements AnimalesServicio{

	@Autowired
	private AnimalesRepositorio animalesRepositorio;
	
	@Override
	public AnimalesDTO agregarAnimal(AnimalesDTO animalesDTO) {
		
		Animales animales = mapearEntidad(animalesDTO);
		Animales nuevoAnimal = animalesRepositorio.save(animales);
		AnimalesDTO animalRespuesta = mapearDTO(nuevoAnimal);
		
		return animalRespuesta;
	}
	
	@Override
	public List<AnimalesDTO> listarAnimales() {

		List<Animales> listaAnimales = animalesRepositorio.findAll();
		
		return listaAnimales.stream().map(animales -> mapearDTO(animales)).collect(Collectors.toList());
	}
	
	@Override
	public AnimalesDTO obtenerAnimalPorId(long id) {

		Animales animales = animalesRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("animal", "id", id));
		
		return mapearDTO(animales);
	}

	@Override
	public AnimalesDTO actualizarAnimal(AnimalesDTO animalesDTO, Long id) {

		Animales animales = animalesRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("animal", "id", id));
		animales.setNombre(animalesDTO.getNombre());
		animales.setEspecie(animalesDTO.getEspecie());
		animales.setEdad(animalesDTO.getEdad());
		animales.setPeso(animalesDTO.getPeso());
		animales.setAltura(animalesDTO.getAltura());
		animales.setEstado(animalesDTO.getEstado());
		
		Animales animalActualizado = animalesRepositorio.save(animales);
		
		return mapearDTO(animalActualizado);
	}

	@Override
	public void eliminarAnimal(Long id) {

		Animales animales = animalesRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("animal", "id", id));
		
		animalesRepositorio.delete(animales);
	}
	

	private AnimalesDTO mapearDTO (Animales animales) {
		
		AnimalesDTO animalesDTO = new AnimalesDTO();
		
		animalesDTO.setId(animales.getId());
		animalesDTO.setNombre(animales.getNombre());
		animalesDTO.setEspecie(animales.getEspecie());
		animalesDTO.setEdad(animales.getEdad());
		animalesDTO.setPeso(animales.getPeso());
		animalesDTO.setAltura(animales.getAltura());
		animalesDTO.setEstado(animales.getEstado());
		
		return animalesDTO;
	}
	
	private Animales mapearEntidad (AnimalesDTO animalesDTO) {
		
		Animales animales = new Animales();
		
		animales.setNombre(animalesDTO.getNombre());
		animales.setEspecie(animalesDTO.getEspecie());
		animales.setEdad(animalesDTO.getEdad());
		animales.setPeso(animalesDTO.getPeso());
		animales.setAltura(animalesDTO.getAltura());
		animales.setEstado(animalesDTO.getEstado());
		
		return animales;
		
	}

}
