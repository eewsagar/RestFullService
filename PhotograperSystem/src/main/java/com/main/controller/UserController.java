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

import com.main.dto.UserDTO;
import com.main.repository.UserRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider.*;

@RestController
public class UserController {

	

	@Autowired
	private UserRepository userRepository;
	
	
	// Get /users
	// retrieveAllUsers
	@GetMapping(path = "/jpa/users")
	public List<UserDTO> retrieveAllUsers() {
		return userRepository.findAll();
	}


	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<UserDTO> retrieveUser(@PathVariable int id) {

		Optional<UserDTO> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id"+id);
		}

		// "all-users" SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<UserDTO> entityModel = new EntityModel<UserDTO>(user.get());
		WebMvcLinkBuilder webmvclinkbuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(webmvclinkbuilder.withRel("all-users"));
		// HATEOAS
		return entityModel;
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {

		userRepository.deleteById(id);;

	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO user) {
		UserDTO savedUser = userRepository.save(user);
		// Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
