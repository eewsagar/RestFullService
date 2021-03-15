package com.app.Service;

import java.util.List;

import com.app.Controller.BloodBankCampController;
import com.app.Entity.BloodBankCampEntity;

public interface BloodBankCampService 
{
   boolean addNewBloodBankCamp(BloodBankCampEntity entity);
   List<BloodBankCampEntity> getAllBloodCamp();
   List<BloodBankCampEntity> getBloodCampLikeCity(String cityPattern);
  void delete(int id) ;

}
