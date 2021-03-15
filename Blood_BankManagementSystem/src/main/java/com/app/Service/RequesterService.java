package com.app.Service;

import java.util.List;



import com.app.Entity.RequesterEntity;

public interface RequesterService 
{
	 boolean addNewRequester(RequesterEntity entity);
	 RequesterEntity getRequesterById(int id);
	 List<RequesterEntity> getAllRequester();
	 RequesterEntity getValidRequester(String username,String password);
	 public void delete(int id) ;
//	RequesterEntity updateRequester(int cid, RequesterEntity requester);
	
	
}