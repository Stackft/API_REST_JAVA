package com.zoologico.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoologico.api.entidad.Animales;

public interface AnimalesRepositorio extends JpaRepository<Animales, Long>{

}
