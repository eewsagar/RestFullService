package com.main.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URIEditor;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.main.dto.PhotgrapherDTO;
import com.main.repository.PhotographerRepository;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider.*;

@RestController
public class PhotographerController {

	

	@Autowired
	private PhotographerRepository photographerRepository;
	
	
	// Get /photographers
	// retrieveAllphotographers
	@GetMapping(path = "/jpa/photographers")
	public List<PhotgrapherDTO> retrieveAllphotographers() {
		return photographerRepository.findAll();
	}


	@GetMapping(path = "/jpa/photographers/{id}")
	public EntityModel<PhotgrapherDTO> retrievephotographer(@PathVariable int id) {

		Optional<PhotgrapherDTO> photographer = photographerRepository.findById(id);
		if (!photographer.isPresent()) {
			throw new UserNotFoundException("id"+id);
		}

		// "all-photographers" SERVER_PATH + "/photographers"
		// retrieveAllphotographers
		EntityModel<PhotgrapherDTO> entityModel = new EntityModel<PhotgrapherDTO>(photographer.get());
		WebMvcLinkBuilder webmvclinkbuilder = linkTo(methodOn(this.getClass()).retrieveAllphotographers());
		entityModel.add(webmvclinkbuilder.withRel("all-photographers"));
		// HATEOAS
		return entityModel;
	}

	

	@PostMapping(path = "/jpa/photographers")
	public ResponseEntity<Object> createphotographer(@Valid @RequestBody PhotgrapherDTO photographer) {
		PhotgrapherDTO savedphotographer = photographerRepository.save(photographer);
		// Created
		// /photographer/{id} savedphotographer.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedphotographer.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
