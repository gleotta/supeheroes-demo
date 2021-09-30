package com.germanleotta.superheroes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.germanleotta.superheroes.model.Superhero;




@Repository
@Transactional
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
	
	//empty

}
