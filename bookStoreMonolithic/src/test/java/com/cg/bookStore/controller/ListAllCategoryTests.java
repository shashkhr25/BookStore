package com.cg.bookStore.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.service.ManageCategoryServiceImpl;
import com.cg.bookStore.web.ManageCategoryController;

/**************************************************************************************************
*          @author        Amardeep
*          Description      Test class for list all categories.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageCategoryController.class)
public class ListAllCategoryTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageCategoryServiceImpl service;
	
	@Test
	public void listAllBookTest () throws Exception{
		List<BookCategory> books = new ArrayList<BookCategory>();
		BookCategory randomBook = new BookCategory();
		randomBook.setCategoryId(451);
		randomBook.setCategoryName("thriller");
		books.add(randomBook);
		
		Mockito.when(service.listAllCategory()).thenReturn(books);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/manageCategory/displayAllCategory").accept(
				MediaType.APPLICATION_JSON);
		
		String expected = "{{\r\n" + 
				"	\"categoryId\":\"451\",\r\n" + 
				"	\"categoryName\":\"thriller\",\r\n" + 
				"	}}";
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);	
	}
	
 }
