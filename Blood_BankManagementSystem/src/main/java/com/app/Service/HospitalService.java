package com.app.Service;


import java.util.List;



import com.app.Entity.HospitalEntity;

public interface HospitalService 
{
	boolean addNewHospital(HospitalEntity entity);
	List<HospitalEntity> getAllHospitals();
	List<HospitalEntity> getHospitalLikeCity(String cityPattern);
	public void delete(int id) ;
}
