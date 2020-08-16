package com.cg.bookStore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateCategory {

	@Mock
	private BookStoreDao dao;
	
	@InjectMocks
	private ManageCategoryServiceImpl service;
	
	@Test
	public void createCategoryTest() throws CategoryException {
		
		BookCategory category = new BookCategory();
		category.setCategoryName("sciensddsc");
		
		//Mocking the dao function
		when(dao.createCategory(category)).thenReturn(true);
		assertEquals("category added", service.createCategory(category));
	
	}

	
	@Test
	public void createCategoryExistsTest() throws CategoryException {
		
		BookCategory category = new BookCategory();
		category.setCategoryName("thriller");
		when(dao.categoryExists(category.getCategoryName())).thenReturn(true);
		try {
		assertEquals("category already exists", service.createCategory(category));
		}catch(CategoryException e) {
			assertEquals("category already exists", e.getMessage());
		}
	}

}
