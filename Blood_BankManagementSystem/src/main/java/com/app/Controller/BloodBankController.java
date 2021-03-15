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

import com.app.Entity.BloodBankEntity;
import com.app.Service.BloodBankService;


@RestController
@RequestMapping("/BloodBank")
@CrossOrigin(origins = "http://localhost:4200")
public class BloodBankController 
{
  @Autowired
  BloodBankService bloodBankService;
  
  @GetMapping("getAllBloodBanks")
  public List<BloodBankEntity> getAllBloodBanks()
  {
 	 return bloodBankService.getAllBloodBank();
  }
  @RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";//actual view name :/WEB-INF/views/index.jsp
	}
  
  @GetMapping("getBloodBankLikeCity")
  public List<BloodBankEntity> getBloodBankLikeName(@RequestParam(name="cityPattern") String cityPattern)
  {
 	 return bloodBankService.getBloodBankLikeCity(cityPattern);
  }
  
  @PostMapping("newBloodBank")
  public boolean insertNewBloodBank(@RequestBody BloodBankEntity entity)
  {
 	 return bloodBankService.addNewBloodBank(entity);
  }
  @GetMapping("getValidBloodBank")
  public BloodBankEntity getValidBloodBank(@RequestParam(name="username")String username,@RequestParam(name="password")String password)
	{
		System.out.println(username +" "+ password);
		return bloodBankService.getValidBloodBank(username, password);
	}
  
  
  @DeleteMapping("/delete/{id}")  
  private void deleteDonor(@PathVariable("id") int id)   
  {  
  bloodBankService.delete(id);  
  } 
}
