package com.app.Service;


import java.util.List;



import com.app.Entity.DonorEntity;

public interface DonorService 
{
  boolean addNewDonor(DonorEntity entity);
  List<DonorEntity> getAllDonors();
  List<DonorEntity> getDonorByType(String donorPattern);
  List<DonorEntity> getDonorLikeCity(String cityPattern);
  
  //public DonorQuery updateDonor(Integer id, DonorUpdate);
  List<DonorEntity> getDonorLikeBloodgroup(String bloodPattern);
  DonorEntity getDonorById(int id);
  DonorEntity getValidDonor(String username,String password);
  List<DonorEntity> getDonorLikeBloodGroupAndCity(String bloodPattern,String cityPattern);
  public void delete(int id) ;
  //public void update(DonorEntity donor, int id);
  
  //updating a record 
  //void saveOrUpdate(DonorEntity donor, int id);
  
}
