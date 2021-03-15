package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.RequesterEntity;
import com.app.Repository.*;

@Repository
public interface RequesterRepository extends JpaRepository<RequesterEntity, Integer> {

	@Query(nativeQuery=true,value="select * from requester where r_username=:username and r_password=:password")
	public RequesterEntity findValidRequester(@Param("username") String username,@Param("password") String password);

	


	
}
