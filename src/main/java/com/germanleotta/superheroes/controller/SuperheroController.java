package com.germanleotta.superheroes.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.germanleotta.superheroes.data.ApiResponse;
import com.germanleotta.superheroes.data.SuperheroData;
import com.germanleotta.superheroes.model.Superhero;
import com.germanleotta.superheroes.service.SuperheroService;




@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
	
	@Autowired
	private SuperheroService superheroService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping
	public List<SuperheroData> getSuperheroes() {
		return superheroService.findAllSuperheroes().stream().map(sh -> modelMapper.map(sh, SuperheroData.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/{superheroId}")
	public SuperheroData getSuperheroById(@PathVariable Long superheroId) {
		
		Superhero superhero = superheroService.findSuperheroById(superheroId);
		
		// convert entity to Data
		var superheroResponse = modelMapper.map(superhero, SuperheroData.class);
		return superheroResponse;	
	}
	
	@PostMapping
	public SuperheroData createSuperhero(@RequestBody SuperheroData superheroRequest) {
		// convert data to entity
		var superhero = modelMapper.map(superheroRequest, Superhero.class);
		
		Superhero superheroUpdated = superheroService.createSuperhero(superhero);
		
		// convert entity to Data
		var superheroResponse = modelMapper.map(superheroUpdated, SuperheroData.class);
		return superheroResponse;	
	}
	
	@PutMapping("/{superheroId}")
	public SuperheroData updateSuperhero(@PathVariable Long superheroId, @Valid @RequestBody SuperheroData superheroRequest) {
		// convert data to entity
		var superhero = modelMapper.map(superheroRequest, Superhero.class);
		
		Superhero superheroUpdated = superheroService.updateSuperhero(superheroId, superhero);
		
		// convert entity to Data
		var superheroResponse = modelMapper.map(superheroUpdated, SuperheroData.class);
		return superheroResponse;	
		
	}
	
	
	
	@DeleteMapping("/{superheroId}")
	public ApiResponse deleteSuperhero(@PathVariable Long superheroId) {
		superheroService.deleteSuperhero(superheroId);
		var response = new ApiResponse(true, "superhero deleted: "+superheroId);
		return response;
	}

}
