package com.app.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.BloodBankEntity;
import com.app.Repository.BloodBankRepository;



@Service
//@Service: It is also used at class level. It tells the Spring that class contains the business logic.
public class BloodBankServiceImpl implements BloodBankService
{
	@Autowired
	BloodBankRepository repository;

	@Override
	public boolean addNewBloodBank(BloodBankEntity entity) {
		BloodBankEntity returnEntity=repository.save(entity);
		return returnEntity != null?true:false;
	}

	@Override
	public List<BloodBankEntity> getAllBloodBank() {
		return repository.findAll();
	}

	@Override
	public List<BloodBankEntity> getBloodBankLikeCity(String cityPattern) {
		
		return repository.findBloodBankCityLike(cityPattern);
	}

	@Override
	public BloodBankEntity getValidBloodBank(String username, String password) {
		
		return repository.findValidBloodBank(username, password);
	}
	
	public void delete(int id)   
	{  
	   repository.deleteById(id);  
	}

}
