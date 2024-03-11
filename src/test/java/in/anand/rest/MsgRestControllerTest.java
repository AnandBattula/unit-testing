package in.anand.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.anand.controller.MsgRestController;
import in.anand.service.MsgService;

@WebMvcTest(controllers = MsgRestController.class)
public class MsgRestControllerTest {

	@MockBean
	private MsgService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGreetMsg() throws Exception {
		when(service.getGreetMsg()).thenReturn("Dummy text");
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/greet");
		
		MvcResult result = mockMvc.perform(req).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void testWelcomeMsg() throws Exception {
		
		// define mock obj behavior
		when(service.getWelcomeMsg()).thenReturn("Good Evening...");
		
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");
		
		MvcResult result = mockMvc.perform(req).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String contentAsString = response.getContentAsString();
		System.out.println(contentAsString);
		
		int status = response.getStatus();
		
		assertEquals(200, status);
	}
}
