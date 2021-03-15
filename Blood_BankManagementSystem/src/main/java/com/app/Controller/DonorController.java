package com.app.Controller;

import java.awt.PageAttributes.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.DonorEntity;
import com.app.Repository.DonorRepository;
import com.app.Service.DonorService;


@RestController
@RequestMapping("/Donor")
@CrossOrigin(origins = "http://localhost:4200")
public class DonorController 
{
  @Autowired
  DonorService donorService;
  DonorRepository repository;
  
  @GetMapping("getAllDonors")
  public List<DonorEntity> getAllCategories()
  {
 	 return donorService.getAllDonors();
  }
  
  @GetMapping("getDonorByType")
  public List<DonorEntity> getDonorByType(@RequestParam(name="donorPattern") String donorPattern)
  {
 	 return donorService.getDonorByType(donorPattern );
  }
  
  @GetMapping("getDonorLikeCity")
  public List<DonorEntity> getCategoryLikeName(@RequestParam(name="cityPattern") String cityPattern)
  {
 	 return donorService.getDonorLikeCity(cityPattern);
  }
  
  @GetMapping("getDonorByBloodGroup")
  public List<DonorEntity> getDonorByBloodGroup(@RequestParam(name="bloodPattern") String bloodPattern)
  {  
	  return donorService.getDonorLikeBloodgroup(bloodPattern);
  }
  
  @GetMapping("getDonorById")
	public DonorEntity getDonorById(@RequestParam(name="id")int id)
	{
		return donorService.getDonorById(id);
	}
  
  @GetMapping("getValidDonor")
	public DonorEntity getValidDonor(@RequestParam(name="username")String username,@RequestParam(name="password")String password)
	{
		System.out.println(username +" "+ password);
		return donorService.getValidDonor(username,password);
	}
  
  // bloodPattern cityPattern
  @GetMapping("getDonor")
	public DonorEntity getDonor(@RequestParam(name="bloodPattern")String bloodPattern,@RequestParam(name="cityPattern")String cityPattern)
	{
		System.out.println(bloodPattern +" "+ cityPattern);
		return donorService.getValidDonor(bloodPattern,cityPattern);
	}
  
  
  @PostMapping("newDonor")
  public boolean insertNewDonor(@RequestBody DonorEntity entity)
  {
 	 return donorService.addNewDonor(entity);
  }
  

  @DeleteMapping("/delete/{id}")  
  private void deleteDonor(@PathVariable("id") int id)   
  {  
  donorService.delete(id);  
  } 
  
  /*
  
  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<DonorQuery> updateDonor(@PathVariable(value = "id") Integer id,
                                                @RequestBody DonorUpdate donorUpdate)
  {
      return new ResponseEntity<>(donorCommandService.updateDonor(id, donorUpdate), HttpStatus.OK);
  }
  
  
  
  //creating put mapping that updates the donor detail 
 
  @PutMapping("/update")  
  private DonorEntity update(@RequestBody DonorEntity donor,int id)   
  {  
	  donorService.saveOrUpdate(donor, id);  
      return donor;  
  }  
  
  */
  
  /*
  @PostMapping("/save")  
  private int saveDonor(@RequestBody DonorEntity donor)   
  {  
	  donorService.saveOrUpdate(donor);  
      return donorService.getD_id();  
  }  
  
  
  
  
  
  
  //not
  @DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer id)
		 {
		DonorEntity donor = repository.findById(id).get();
				
		repository.delete(donor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
 
  
  
  
  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<DonorEntity> updateDonor(@PathVariable(value = "id") Integer id,
  @RequestBody donorUpdate vehicleUpdateDTO){
      return new ResponseEntity<>(donorService.updateVehicle(id, donorUpdate), HttpStatus.OK);
  }
  
  
  */
  
  
  /*
   @PutMapping("/update/{id}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable(value = "id") Integer CustomerId,
			@Valid @RequestBody CustomerEntity customerDetails) {
		CustomerEntity customer = customerRepository.findById(CustomerId).get();
				
		customer.setC_id(customerDetails.getC_id());
		customer.setC_username(customerDetails.getC_username());
		customer.setC_password(customerDetails.getC_password());
		customer.setC_address(customerDetails.getC_address());
		customer.setC_city(customerDetails.getC_city());
		customer.setC_dob(customerDetails.getC_dob());
		customer.setC_email(customerDetails.getC_email());
		customer.setC_gender(customerDetails.getC_gender());
		customer.setC_mob_no(customerDetails.getC_mob_no());
		customer.setC_state(customerDetails.getC_state());
		customer.setLicense_no(customerDetails.getLicence_no());
		customer.setC_name(customerDetails.getC_name());
			final CustomerEntity updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
   */
  
}
