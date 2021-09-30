package com.germanleotta.superheroes.service;

import java.util.List;

import com.germanleotta.superheroes.exception.ServiceException;
import com.germanleotta.superheroes.model.Superhero;

public interface SuperheroService {

	List<Superhero> findAllSuperheroes();

	Superhero findSuperheroById(Long superheroId) throws ServiceException;
	
	public Superhero createSuperhero(Superhero superheroRequest);

	Superhero updateSuperhero(Long superheroId, Superhero superheroRequest) throws ServiceException;

	void deleteSuperhero(Long superheroId);

}