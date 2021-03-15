package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.RequesterEntity;
import com.app.Repository.*;


@Service
public class RequesterServiceImpl implements RequesterService 
{
	@Autowired
    RequesterRepository repository;
	
	@Override
	public boolean addNewRequester(RequesterEntity entity) {
	  RequesterEntity returnEntity=repository.save(entity);
	  return returnEntity != null?true:false;
	}

	@Override
	public RequesterEntity getRequesterById(int id)
	{
		return repository.findById(id).get();	
	}

	@Override
	public List<RequesterEntity> getAllRequester() {
		return repository.findAll();
	}

	@Override
	public RequesterEntity getValidRequester(String username, String password) {
		return repository.findValidRequester(username, password);
	}
	
	public void delete(int id)   
	{  
	repository.deleteById(id);  
	}

	/*
	@Override
	public RequesterEntity updateRequester(int cid, RequesterEntity requester) {
		// TODO Auto-generated method stub
		return null;
	} */ 
	
}
