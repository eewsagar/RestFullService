package com.app.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.BloodBankCampEntity;
import com.app.Repository.BloodBankCampRepository;



@Service
public class BloodBankCampServiceImpl implements BloodBankCampService 
{

	  @Autowired
	  //@Autowired: Spring provides annotation-based auto-wiring by providing @Autowired annotation. 
	  //It is used to autowire spring bean on setter methods, instance variable, and constructor.
	  //When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.
	  BloodBankCampRepository repository;
	
	  public boolean addNewBloodBankCamp(BloodBankCampEntity entity) {
		  
		  BloodBankCampEntity returnEntity=repository.save(entity);
			return returnEntity != null?true:false;
	}

	@Override
	public List<BloodBankCampEntity> getAllBloodCamp() {
		return repository.findAll();
	
	}

	@Override
	public List<BloodBankCampEntity> getBloodCampLikeCity(String cityPattern) {
	
		return repository.findBloodBankCampCityLike(cityPattern);
	}
	
	public void delete(int id)   
	{  
	repository.deleteById(id);  
	}

}
