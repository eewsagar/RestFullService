package com.rest.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URIEditor;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider.*;

@RestController
public class USerREsource {

	@Autowired
	private UserDaoService service;

	// Get /users
	// retrieveAllUsers
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

//	 //Get /users/{id}
//	 //retrieveUser
//	 @GetMapping(path = "/users/{id}")
//	 public User retrieveUser(@PathVariable int  id) {
//		 
//		 return service.findOne(id);
//	 }

	// Get /users/{id}
	// retrieveUser
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {

		User user = service.findOne(id);
		if (user == null) 
			throw new UserNotFoundException("id-" + id);
		
        //"all-users"  SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> entityModel = new EntityModel<User>(user);
		WebMvcLinkBuilder webmvclinkbuilder = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(webmvclinkbuilder.withRel("all-users"));
		//HATEOAS
		return entityModel;
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {

		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}

	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> retrieveUser(@Valid @RequestBody User user) {
		User savedUser = service.Save(user);
		// Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
