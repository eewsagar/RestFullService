package com.app.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.HospitalEntity;
import com.app.Repository.*;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> 
{

	@Query(nativeQuery = true,value = "select * from hospital where h_city like CONCAT ('%',:cityPattern,'%')")
	public List<HospitalEntity> findHospitalCityLike(@Param("cityPattern") String cityPattern);
}
