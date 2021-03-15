package com.app.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.HospitalEntity;
import com.app.Repository.*;





@Service
public class HospitalServiceImpl implements HospitalService 
{

	@Autowired
	HospitalRepository repository;
	
	@Override
	public boolean addNewHospital(HospitalEntity entity) {
		
		HospitalEntity returnEntity=repository.save(entity);
		return returnEntity != null?true:false;
	}

	@Override
	public List<HospitalEntity> getAllHospitals() {
		
		return repository.findAll();
	}

	@Override
	public List<HospitalEntity> getHospitalLikeCity(String cityPattern) {
		
		return repository.findHospitalCityLike(cityPattern);
	}
	

	public void delete(int id)   
	{  
	   repository.deleteById(id);  
	}

}
