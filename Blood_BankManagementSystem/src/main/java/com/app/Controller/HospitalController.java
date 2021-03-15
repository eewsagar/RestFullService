package com.app.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.HospitalEntity;
import com.app.Service.HospitalService;




@RestController
@RequestMapping("/Hospital")
@CrossOrigin(origins = "http://localhost:4200")

public class HospitalController 
{
  @Autowired
  HospitalService hospitalService;
  
  @GetMapping("getAllHospitals")
  public List<HospitalEntity> getAllHospitals()
  {
 	 return hospitalService.getAllHospitals();
  }
  
  @GetMapping("getHospitalLikeCity")
  public List<HospitalEntity> getHospitalLikeName(@RequestParam(name="cityPattern") String cityPattern)
  {
 	 return hospitalService.getHospitalLikeCity(cityPattern);
  }
  
  @PostMapping("newHospital")
  public boolean insertNewHospital(@RequestBody HospitalEntity entity)
  {
 	 return hospitalService.addNewHospital(entity);
  }
  

  @DeleteMapping("/delete/{id}")  
  private void deleteHospital(@PathVariable("id") int id)   
  {  
	  hospitalService.delete(id);  
  } 
}
