package com.app.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.DonorEntity;
import com.app.Repository.DonorRepository;


@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	DonorRepository repository;
	
	@Override
	public boolean addNewDonor(DonorEntity entity) {
		DonorEntity returnEntity=repository.save(entity);
		return returnEntity != null?true:false;
		
	}

	@Override
	public List<DonorEntity> getAllDonors() 
	{
		return repository.findAll();
	}
	
	@Override
	public List<DonorEntity> getDonorByType(String donorPattern) 
	{
		return repository.findDonorByTypeLike(donorPattern);
	}


	@Override
	public List<DonorEntity> getDonorLikeCity(String cityPattern) 
	{
		return repository.findDonorCityLike(cityPattern);
	}

	@Override
	public List<DonorEntity> getDonorLikeBloodgroup(String bloodPattern) {
		
		return repository.findDonorBloodGroupLike(bloodPattern);
	}

	@Override
	public DonorEntity getDonorById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public DonorEntity getValidDonor(String username, String password) {
		
		return repository.findValidDonor(username, password);
	}

	@Override
	public List<DonorEntity> getDonorLikeBloodGroupAndCity(String bloodPattern, String cityPattern) {
		return repository.findDonorBloodGroupCityLike(bloodPattern, cityPattern);
	}

	public void delete(int id)   
	{  
		repository.deleteById(id);  
	} 
	
	/*

	 @Override
	 public DonorQuery updateDonor(Integer id, DonorUpdate DonorUpdate)
	 {

	      if (donorRepository.findById(id).isPresent()){
	          DonorEntity existingDonor = donorRepository.findById(id).get();

	          existingDonor.setMake(donorUpdate.getMake());
	          existingDonor.setModel(donorUpdate.getModel());

	          Donor updatedVehicle = donorRepository.save(existingDonor);

	          return new DonorQuery(updatedDonor.getId(), updatedDonor.getDonorIdentityNumber(),
	                  updatedDonor.getMake(), updatedDonor.getModel());
	     }
	     else
	     {
	          return null;
	     }
	  }
	

	//updating a record  
	public void saveOrUpdate(DonorEntity donor, int id)   
	{  
		repository.save(donor);  
	}  
 
	
	
	 * public void update(DonorEntity donor, int id)   
	{  
	  repository.save(donor);  
	} 
	
	

    @Override
    public VehicleQueryDTO updateDonorEntity(Integer id, DonorEntityUpdate donorUpdate) {

        if (vehicleRepository.findById(id).isPresent()){
            Vehicle existingVehicle = vehicleRepository.findById(id).get();

            existingVehicle.setMake(vehicleUpdateDTO.getMake());
            existingVehicle.setModel(vehicleUpdateDTO.getModel());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleQueryDTO(updatedVehicle.getId(), updatedVehicle.getVehicleIdentityNumber(),
                    updatedVehicle.getMake(), updatedVehicle.getModel());
        }else{
            return null;
        }
        
        */
}
