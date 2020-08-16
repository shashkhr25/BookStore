package com.cg.bookStore.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.bookStore.service.ManageBookService;
import com.cg.bookStore.web.ManageBookController;

/**************************************************************************************************
*          @author        Aishwarya
*          Description      Test class for delete book functions.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageBookController.class)
public class DeleteBookTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageBookService service;
	
	@Test
	public void testDeleteExistingBook() throws Exception {
		String categoryJson = "{\"bookId\":\"1\"}";
		String expectedResult="book already exists!";
		Mockito.when(
				service.deleteBook(Mockito.anyInt())).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/manageCategory/delete").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("")).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testDeleteBook() throws Exception {
		String categoryJson = "{\"bookId\":\"10156\"}";
		String expectedResult="book deleted";
		Mockito.when(
				service.deleteBook(Mockito.anyInt())).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/manageCategory/delete").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("")).andDo(MockMvcResultHandlers.print());
	}
	}