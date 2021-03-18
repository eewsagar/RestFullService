package com.main.admin;

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

import com.main.controller.UserNotFoundException;
import com.main.dto.BookingDTO;
import com.main.dto.PhotgrapherDTO;
import com.main.dto.PhotoPortfolioDTO;
import com.main.repository.BookingRepository;
import com.main.repository.PhotoPortfolioRepository;
import com.main.repository.PhotographerRepository;

@RestController
public class AdminController {

	

	@Autowired
	private PhotoPortfolioRepository photoPortfolioRepository;
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PhotographerRepository photographerRepository;
	
	
	// Get /photodetails
	// photo retrival
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
	@DeleteMapping(path = "/jpa/photographers/{id}")
	public void deletephotographer(@PathVariable int id) {

		photographerRepository.deleteById(id);;

	}
	
	
	
	@GetMapping(path = "/jpa/bookings")
	public List<BookingDTO> retrieveAllbookings() {
		return bookingRepository.findAll();
	}


	@GetMapping(path = "/jpa/bookings/{id}")
	public EntityModel<BookingDTO> retrievebooking(@PathVariable int id) {

		Optional<BookingDTO> booking = bookingRepository.findById(id);
		if (!booking.isPresent()) {
			throw new UserNotFoundException("id"+id);
		}

		// "all-bookings" SERVER_PATH + "/bookings"
		// retrieveAllbookings
		EntityModel<BookingDTO> entityModel = new EntityModel<BookingDTO>(booking.get());
		WebMvcLinkBuilder webmvclinkbuilder = linkTo(methodOn(this.getClass()).retrieveAllbookings());
		entityModel.add(webmvclinkbuilder.withRel("all-bookings"));
		// HATEOAS
		return entityModel;
	}
	
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
