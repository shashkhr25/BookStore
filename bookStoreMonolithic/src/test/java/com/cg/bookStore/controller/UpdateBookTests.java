package com.cg.bookStore.controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.bookStore.dto.BookForm;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.service.ManageBookService;
import com.cg.bookStore.web.ManageBookController;

/**************************************************************************************************
*          @author         Sachin
*          Description      This class implements the BookStoreDao interface.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageBookController.class)
public class UpdateBookTests{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageBookService service;
	
	@Test
	public void testUpdateBook() throws Exception {
		String categoryJson = "{\"bookId\":1,\"title\":\"hindi\",\"author\":\"Sachin\",\"description\":\"12th science\",\"isbnNumber\":\"1237894561232\",\"publishDate\":null,\"lastUpdateTime\":null,\"price\":100}";
		String expectedResult="book updated";
		Mockito.when(
				service.updateBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/update").accept(MediaType.APPLICATION_JSON)
				.content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("book updated")).andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void testUpdateBookNull() throws Exception {
		String categoryJson = "{}";
		String expectedResult="Some error occured, try again";
		Mockito.when(
				service.updateBook(Mockito.any(BookInformation.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageBook/update").accept(MediaType.APPLICATION_JSON)
				.content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Some error occured, try again")).andDo(MockMvcResultHandlers.print());
	}
}