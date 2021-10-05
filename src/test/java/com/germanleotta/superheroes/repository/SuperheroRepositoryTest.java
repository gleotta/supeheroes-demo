package com.germanleotta.superheroes.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(
		  locations = "classpath:application-test.properties")
public class SuperheroRepositoryTest {


	@Autowired
	private SuperheroRepository superheroRepository;
	
	
	@Test
	public void findAllTest() {
		assertEquals(superheroRepository.findAll().size(), 5);
	
	}

}
