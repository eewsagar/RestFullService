package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dto.BookingDTO;
import com.main.dto.UserDTO;

@Repository
public interface BookingRepository extends JpaRepository<BookingDTO, Integer>{

}
