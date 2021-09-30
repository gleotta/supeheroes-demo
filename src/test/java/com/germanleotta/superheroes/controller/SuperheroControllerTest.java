package com.germanleotta.superheroes.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.germanleotta.superheroes.model.Superhero;
import com.germanleotta.superheroes.service.SuperheroService;

@WebMvcTest(SuperheroController.class)
public class SuperheroControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private SuperheroService superheroService;

	@Test
	public void getCarShouldReturnCarDetails() throws Exception {
		
	    var superman = new Superhero(1l, "Superman", "Clark","Kent");
	    var batman = new Superhero(2l, "Batman", "Bruce","Wayne");

	    Mockito.when(superheroService.findAllSuperheroes())
	      .thenReturn(new ArrayList<Superhero>(Arrays.asList(new Superhero[]{superman, batman})));
	    
		mvc.perform(get("/api/superheroes").accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("$[0].name", is(superman.getName())))
	      .andExpect(jsonPath("$[1].name", is(batman.getName())));
    	
	}

}
