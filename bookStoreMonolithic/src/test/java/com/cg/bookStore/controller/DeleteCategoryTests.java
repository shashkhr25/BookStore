package com.cg.bookStore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.bookStore.service.ManageCategoryService;
import com.cg.bookStore.web.ManageCategoryController;
/**************************************************************************************************
*          @author        Abhilash
*          Description      Test class for delete category functions.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/

@RunWith(SpringRunner.class)
@WebMvcTest(value = ManageCategoryController.class)
public class DeleteCategoryTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManageCategoryService service;
	
	@Test
	public void testDeleteCategoryNotExist() throws Exception {
		
		String expected="Category does not exist";
		
		Mockito.when(
				service.deleteCategory(Mockito.anyInt())).thenReturn(expected);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/manageCategory/delete/{CategoryId}",150);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string(expected)).andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void testDeleteCategoryIsEmpty() throws Exception {
		
		String expected="Books present in the category";
		
		Mockito.when(
				service.deleteCategory(Mockito.anyInt())).thenReturn(expected);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/manageCategory/delete/{CategoryId}",150);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string(expected)).andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void testDeleteCategoryIsDeleted() throws Exception {
		
		String expected="category deleted";
		
		Mockito.when(
				service.deleteCategory(Mockito.anyInt())).thenReturn(expected);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/manageCategory/delete/{CategoryId}",150);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string(expected)).andDo(MockMvcResultHandlers.print());
	}

}
