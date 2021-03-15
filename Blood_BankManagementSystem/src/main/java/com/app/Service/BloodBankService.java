package com.app.Service;

import java.util.List;


import com.app.Entity.BloodBankEntity;


import com.app.Entity.*;

public interface BloodBankService 
{
	 boolean addNewBloodBank(BloodBankEntity entity);
	 List<BloodBankEntity> getAllBloodBank();
	 List<BloodBankEntity> getBloodBankLikeCity(String cityPattern);
	 BloodBankEntity getValidBloodBank(String username,String password);
	 public void delete(int id) ;
}
