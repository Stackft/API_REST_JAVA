package com.zoologico.api.servicio;

import java.util.List;

import com.zoologico.api.DTO.AnimalesDTO;

public interface AnimalesServicio {

	public AnimalesDTO agregarAnimal(AnimalesDTO animalesDTO);
	
	public List<AnimalesDTO> listarAnimales();
	
	public AnimalesDTO obtenerAnimalPorId(long id);
	
	public AnimalesDTO actualizarAnimal(AnimalesDTO animalesDTO, Long id);
	
	public void eliminarAnimal(Long id);
}
