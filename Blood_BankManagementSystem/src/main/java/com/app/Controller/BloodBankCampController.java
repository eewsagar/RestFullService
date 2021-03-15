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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.BloodBankCampEntity;
import com.app.Service.BloodBankCampService;



@RestController
//@RestController: It can be considered as a combination of @Controller and @ResponseBody annotations. 
//The @RestController annotation is itself annotated with the @ResponseBody annotation.
//It eliminates the need for annotating each method with @ResponseBody
@RequestMapping("/BloodBankCamp")
@CrossOrigin(origins = "http://localhost:4200")
public class BloodBankCampController 
{
 @Autowired
 BloodBankCampService service;
 
   @GetMapping("getAllBloodBankCamps")
   public List<BloodBankCampEntity> getAllBloodBankCamps()
   {
  	 return service.getAllBloodCamp();
   }
   
   @GetMapping("getBloodBankCampLikeCity")
   public List<BloodBankCampEntity> getBloodBankCampLikeName(@RequestParam(name="cityPattern") String cityPattern)
   //@RequestParam: It is used to extract the query parameters form the URL. It is also known as a query parameter.
   //It is most suitable for web applications.
   //It can specify default values if the query parameter is not present in the URL.
   {
  	 return service.getBloodCampLikeCity(cityPattern);
   }
   
   @PostMapping("newBloodBankCamp")
   public boolean insertNewBloodBankCamp(@RequestBody BloodBankCampEntity entity)
   //@RequestBody: It is used to bind HTTP request with an object in a method parameter.
   //Internally it uses HTTP MessageConverters to convert the body of the request.
   //When we annotate a method parameter with @RequestBody, the Spring framework binds the incoming HTTP request body to that parameter.
   {
  	 return service.addNewBloodBankCamp(entity);
   }
   

   @DeleteMapping("/delete/{id}")  
   private void  deleteBloodBankCamp(@PathVariable("id") int id)
   //@PathVariable: It is used to extract the values from the URI. It is most suitable for the RESTful web service,
   //where the URL contains a path variable. We can define multiple @PathVariable in a method.
   {  
	   service.delete(id);  
   } 
}
