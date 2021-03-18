package com.main.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.dto.PhotoPortfolioDTO;
import com.main.repository.PhotoPortfolioRepository;

@RestController
public class PhotoPortfolioController {

	

	@Autowired
	private PhotoPortfolioRepository photoPortfolioRepository;
	
	
	// Get /users
	// retrieveAllUsers
	@GetMapping(path = "/jpa/photoPortfolio")
	public List<PhotoPortfolioDTO> retrieveAllUsers() {
		return photoPortfolioRepository.findAll();
	}


	@GetMapping(path = "/jpa/photoPortfolio/{id}")
	public EntityModel<PhotoPortfolioDTO> retrieveUser(@PathVariable int id) {

		Optional<PhotoPortfolioDTO> user = photoPortfolioRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id"+id);
		}

		// "all-users" SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<PhotoPortfolioDTO> entityModel = new EntityModel<PhotoPortfolioDTO>(user.get());
		WebMvcLinkBuilder webmvclinkbuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(webmvclinkbuilder.withRel("all-users"));
		// HATEOAS
		return entityModel;
	}

	@DeleteMapping(path = "/jpa/photoPortfolio/{id}")
	public void deleteUser(@PathVariable int id) {

		photoPortfolioRepository.deleteById(id);;

	}

	@PostMapping(path = "/jpa/photoPortfolio")
	public ResponseEntity<Object> createUser(@Valid @RequestBody PhotoPortfolioDTO photoPortfolioDTO) {
		PhotoPortfolioDTO savedUser = photoPortfolioRepository.save(photoPortfolioDTO);
		// Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
