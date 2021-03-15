package com.app.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.*;

@Repository
public interface DonorRepository extends JpaRepository<DonorEntity, Integer> 
{
	@Query(nativeQuery = true,value = "select * from donor where d_city like CONCAT ('%',:cityPattern,'%')")
	public List<DonorEntity> findDonorCityLike(@Param("cityPattern") String cityPattern);
	
	@Query(nativeQuery = true,value = "select * from donor where d_bloodgroup like CONCAT ('%',:bloodPattern,'%') ")
	public List<DonorEntity> findDonorBloodGroupLike(@Param("bloodPattern")String bloodPattern);

	@Query(nativeQuery=true,value="select * from donor where d_username=:username and d_password=:password")
	public DonorEntity findValidDonor(@Param("username") String username,@Param("password") String password);
	
	@Query(nativeQuery = true,value = "SELECT * FROM donor  WHERE " + "d_bloodgroup LIKE CONCAT('%',:bloodPattern, '%') AND " + "d_city LIKE CONCAT('%',:cityPattern, '%')")
	public List<DonorEntity> findDonorBloodGroupCityLike(@Param("bloodPattern")String bloodPattern,@Param("cityPattern")String cityPattern);
	
	@Query(nativeQuery = true,value = "select * from donor where d_type like CONCAT ('%',:donorPattern,'%') ")
	public List<DonorEntity> findDonorByTypeLike(@Param("donorPattern")String donorPattern);
	

}
