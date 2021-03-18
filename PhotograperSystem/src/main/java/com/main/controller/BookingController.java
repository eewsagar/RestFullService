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

import com.main.dto.BookingDTO;
import com.main.repository.BookingRepository;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider.*;

@RestController
public class BookingController {

	

	@Autowired
	private BookingRepository bookingRepository;
	
	
	// Get /bookings
	// retrieveAllbookings
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

	@DeleteMapping(path = "/jpa/bookings/{id}")
	public void deletebooking(@PathVariable int id) {

		bookingRepository.deleteById(id);;

	}

	@PostMapping(path = "/jpa/bookings")
	public ResponseEntity<Object> createbooking(@Valid @RequestBody BookingDTO booking) {
		BookingDTO savedbooking = bookingRepository.save(booking);
		// Created
		// /booking/{id} savedbooking.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedbooking.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
