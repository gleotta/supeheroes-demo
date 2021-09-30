package com.germanleotta.superheroes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.germanleotta.superheroes.exception.ServiceException;
import com.germanleotta.superheroes.model.Superhero;
import com.germanleotta.superheroes.repository.SuperheroRepository;
import com.germanleotta.superheroes.service.SuperheroService;



@Service
public class DefaultSuperheroService implements SuperheroService {

	private SuperheroRepository superheroRepository;

	@Autowired
	public DefaultSuperheroService(final SuperheroRepository superheroRepository) {
		this.superheroRepository = superheroRepository;
	}

	@Override
	public List<Superhero> findAllSuperheroes() {
		return superheroRepository.findAll();
	}

	@Override
	public Superhero findSuperheroById(Long superheroId) throws ServiceException {
		return superheroRepository.findById(superheroId).orElseThrow(() -> new ServiceException("Superhero not found wirh id "+superheroId));
	}

	@Override
	public Superhero updateSuperhero(Long superheroId, Superhero superheroRequest) throws ServiceException {
		Optional<Superhero> sh = superheroRepository.findById(superheroId);
		var superheroe = sh.orElseThrow(() -> new ServiceException("Superhero not found wirh id "+superheroId));
		return superheroRepository.save(superheroe);

	}
	
	@Override
	public Superhero createSuperhero(Superhero superheroRequest) {		
		return superheroRepository.save(superheroRequest);
	}

	@Override
	public void deleteSuperhero(Long superheroId) {
		superheroRepository.deleteById(superheroId);
	}

}
