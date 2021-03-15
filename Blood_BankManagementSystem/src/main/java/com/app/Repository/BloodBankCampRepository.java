package com.app.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.*;


@Repository
//@Repository: It is a class-level annotation. The repository is a DAOs (Data Access Object) that access the database directly.
//The repository does all the operations related to the database
public interface BloodBankCampRepository extends JpaRepository<BloodBankCampEntity, Integer> {

	
	@Query(nativeQuery = true,value = "select * from bloodbankcamp where bloodcamp_city like CONCAT ('%',:cityPattern,'%')")
	public List<BloodBankCampEntity> findBloodBankCampCityLike(@Param("cityPattern") String cityPattern);
}
