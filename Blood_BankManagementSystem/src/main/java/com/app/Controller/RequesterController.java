package com.app.Controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.RequesterEntity;
import com.app.Service.RequesterService;


@RestController
@RequestMapping("/Requester")
@CrossOrigin(origins = "http://localhost:4200")
public class RequesterController 
{
  @Autowired
  RequesterService requesterService;
private CrudRepository<RequesterEntity, Integer> repository;
  
  @GetMapping("getAllRequester")
  public List<RequesterEntity> getAllRequesters()
  {
 	 return requesterService.getAllRequester();
  }
  
  //insert in table
  @PostMapping("newRequester")
  public boolean insertNewRequester(@RequestBody RequesterEntity entity)
  {
 	 return requesterService.addNewRequester(entity);
  }
  
  
  // to read data from database
  @GetMapping("getValidRequester")
	public RequesterEntity getValidRequester(@RequestParam(name="username")String username,@RequestParam(name="password")String password)
	{
		System.out.println(username +" "+ password);
		return requesterService.getValidRequester(username, password);
	}
  
 
  
  @PostMapping("/update/{id}")
 	public ResponseEntity<RequesterEntity> updateRequester(@PathVariable(value = "id") Integer id,
 			
 	  @RequestBody RequesterEntity requesterDetails) {
 	  RequesterEntity requester = repository.findById(id).get();
 		
 	  requester.setR_username(requesterDetails.getR_username());
 	  requester.setR_password(requesterDetails.getR_password());
 	  requester.setR_id(requesterDetails.getR_id());
 	  requester.setR_name(requesterDetails.getR_name());
 	  requester.setR_city(requesterDetails.getR_city());
 	  requester.setR_address(requesterDetails.getR_address());
 	  requester.setR_contact(requesterDetails.getR_contact());
 	  requester.setR_emailid(requesterDetails.getR_emailid());
 	  requester.setR_type(requesterDetails.getR_type());
 	
 		final RequesterEntity updatedRequester =repository.save(requester);
 		return ResponseEntity.ok(updatedRequester);
 	}


  @DeleteMapping("/delete/{id}")  
  private void deleteRequester(@PathVariable("id") int id)   
  {  
  requesterService.delete(id);  
  }  
  
 
  
  
  /*
  
  @PutMapping("/update/{id}")
	public ResponseEntity<RequesterEntity> updateRequester(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody DonorEntity RequesterDetails) {
	  RequesterEntity requester = repository.findById(id).get();
				
	  requester.setD_id(requesterDetails.getD_id());
	  requester.setD_name(requesterDetails.getD_name());
	  requester.setD_username(requesterDetails.getD_username());
	  requester.setD_password(requesterDetails.getD_password());
	  requester.setD_address(requesterDetails.getD_address());
	  requester.setD_city(requesterDetails.getD_city());
	  requester.setD_emailid(requesterDetails.getD_emailid());
	  requester.setD_contact(requesterDetails.getD_contact());
	  requester.setD_age(requesterDetails.getD_age());
	  requester.setD_bloodgroup(requesterDetails.getD_bloodgroup());
		final DonorEntity updatedRequester =repository.save(requester);
		return ResponseEntity.ok(updatedRequester);
	}
  
  
  @PutMapping("/Update/{id}")
  public RequesterEntity<Requester> updateRequester(@PathVariable(value = "id") Long r_id,
       @Valid @RequestBody Requester RequesterDetails) throws ResourceNotFoundException {
	  Requester requester = RequesterRepository.findById(employeeId)
      .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

      employee.setEmailId(employeeDetails.getEmailId());
      employee.setLastName(employeeDetails.getLastName());
      employee.setFirstName(employeeDetails.getFirstName());
      final Employee updatedEmployee = employeeRepository.save(employee);
      return ResponseEntity.ok(updatedEmployee);
  }
  
  */
}
