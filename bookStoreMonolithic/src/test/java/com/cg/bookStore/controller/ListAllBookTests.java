package com.cg.bookStore.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.cg.bookStore.BookStoreMonolithicApplicationTests;

/**************************************************************************************************
*          @author        Amardeep
*          Description      Test class for list all books functions.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
public class ListAllBookTests extends BookStoreMonolithicApplicationTests {

	


	@Autowired
	private WebApplicationContext webApplicationContext;

	
	//@InjectMocks
	//private OrderInformationController orderInformationController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	
	}
	
	@Test
	public void listAllBooks() throws Exception
	{

		try
		{
			MediaType contentType = null;
			mockMvc.perform((RequestBuilder) ((ResultActions) get("/listAllBooks").contentType(contentType))
			.andExpect(status().isInternalServerError())
			.andExpect(content().string("Books are not available"))
			.andDo(print()));}
			catch(Exception e)
			{
				
			}
	
	
	}

	  @Test
	    public void listAllData() throws Exception {
		  
		  String json = "{\n" 
	        		+" \"title\": \"author\" \n"
	    			+ "}";

	        mockMvc.perform(get("/listAllBooks")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(json))
	                .andExpect(status().isOk())
	                .andDo(MockMvcResultHandlers.print());
	    }
	   

	}