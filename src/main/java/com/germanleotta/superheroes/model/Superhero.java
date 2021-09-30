package com.germanleotta.superheroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "superheroes")
public class Superhero {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Size(max = 15)
	@Column(name = "name")
	private String name;

	@NotBlank
	@Size(max = 25)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Size(max = 25)
	@Column(name = "last_name")
	private String lastName;

	
	public Superhero() {
		super();
	}


	public Superhero(Long id, @NotBlank @Size(max = 15) String name, @NotBlank @Size(max = 25) String firstName,
			@NotBlank @Size(max = 25) String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
