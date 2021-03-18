package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dto.PhotgrapherDTO;
import com.main.dto.UserDTO;

@Repository
public interface PhotographerRepository extends JpaRepository<PhotgrapherDTO, Integer>{

}
