package com.germanleotta.superheroes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.germanleotta.superheroes.model.Superhero;
import com.germanleotta.superheroes.repository.SuperheroRepository;
import com.germanleotta.superheroes.service.impl.DefaultSuperheroService;

@SpringBootTest(classes={DefaultSuperheroService.class})
public class SuperheroServiceTest {
	
	
	@Autowired
	private DefaultSuperheroService superheroService;
	
	
	@MockBean
	private SuperheroRepository superheroRepository;
	
	

	
	@Test
	public void findAllSuperheroesTest() {
	    var superman = new Superhero(1l, "Superman", "Clark","Kent");
	    var batman = new Superhero(2l, "Batman", "Bruce","Wayne");

	    Mockito.when(superheroRepository.findAll())
	      .thenReturn(new ArrayList<Superhero>(Arrays.asList(new Superhero[]{superman, batman})));
		
	    assertEquals(superheroService.findAllSuperheroes().size(), 2);
	
	}

	
	

}
