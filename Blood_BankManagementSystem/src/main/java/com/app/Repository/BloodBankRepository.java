package com.app.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.*;


@Repository
public interface BloodBankRepository extends JpaRepository<BloodBankEntity, Integer> 
{
	@Query(nativeQuery = true,value = "select * from bloodbank where b_city like CONCAT ('%',:cityPattern,'%')")
	public List<BloodBankEntity> findBloodBankCityLike(@Param("cityPattern") String cityPattern);
	
	@Query(nativeQuery=true,value="select * from bloodbank where b_username=:username and b_password=:password")
	public BloodBankEntity findValidBloodBank(@Param("username") String username,@Param("password") String password);
 
}
