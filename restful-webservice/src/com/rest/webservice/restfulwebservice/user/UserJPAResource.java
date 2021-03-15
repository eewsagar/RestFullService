package com.rest.webservice.restfulwebservice.user;

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
public class UserJPAResource {

	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	// Get /users
	// retrieveAllUsers
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
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
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		// "all-users" SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<User> entityModel = new EntityModel<User>(user.get());
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
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable Integer id) {
		Optional<User> userOptional =  userRepository.findById(id);
		 if(!userOptional.isPresent()) {
			 throw new UserNotFoundException("id-" + id);
		 }
		
		return userOptional.get().getPosts();
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id,@RequestBody Post post) {
		Optional<User> savedUser = userRepository.findById(id);
		 if(!savedUser.isPresent()) {
			 throw new UserNotFoundException("id-" + id);
		 }
		 
		 User user = savedUser.get();
		 post.setUser(user);
		 
		 postRepository.save(post);
		 
		 
		
		// Created
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
