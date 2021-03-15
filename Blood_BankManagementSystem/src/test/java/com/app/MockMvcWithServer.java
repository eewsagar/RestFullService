package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.Entity.BloodBankEntity;
//import com.app.pojos.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

//creates a web app context (SC) using any available random free port.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class MockMvcWithServer {
	// randomly available free port is injected in local server port
	@LocalServerPort
	private int serverPort;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testTestConroller() throws Exception {

		MvcResult result = mockMvc.perform(get("/test"))
				.andDo(print()).
				andExpect(status().isOk()).
				andReturn();
		assertEquals("Hello, REST !!!!", result.getResponse().getContentAsString());

	}

	
	/*
	 * @Test public void testgetBloodBankById() throws Exception {
	 * mockMvc.perform(get("/BloodBank/101")). andExpect(status().isOk()).
	 * andDo(print()) .andExpect(jsonPath("$.b_password").value("vishal")); }
	 */

	
	
	  @Test public void testaddNewBloodBank() throws Exception { BloodBankEntity
	  bbe = new
	  BloodBankEntity("Man","1234",15,"Lalas","Nan","MAMAMA","Mangesh@4211.com",
	 "2625354");
	  MvcResult result = mockMvc
	  .perform(post("/BloodBank/newBloodBank").contentType(MediaType.APPLICATION_JSON)
	  .content(mapper.writeValueAsString(bbe)))
	  .andDo(print()).andExpect(status().isOk()).andReturn(); // check product id
	  //of the latest added product from product table under DB n then set it's id
	  bbe.setB_id(15); assertEquals(mapper.writeValueAsString(bbe),
	  result.getResponse().getContentAsString()); }
	
	 
/*
	
	  @Test 
	  public void testAddBloodBankJson() throws Exception { BloodBankEntity bb
	  = new BloodBankEntity("Man","1234",15,"Lalas","Nan","MAMAMA","Mangesh@4211.com",
			  "2625354");
	  mockMvc.perform( post("/BloodBank").contentType(MediaType.APPLICATION_JSON).
	  content(mapper.writeValueAsString(bb))) .andDo(print()).
	  andExpect(status().isOk()). andExpect(jsonPath("$.b_name").value("Mayur"));
	  
	  }
	 
*/
}
