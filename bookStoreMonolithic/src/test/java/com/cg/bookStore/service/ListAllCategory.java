package com.cg.bookStore.service;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.exceptions.CategoryException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListAllCategory {
	@Mock
	private BookStoreDao dao;
	
	@Autowired
	private ManageCategoryServiceImpl service;
	
	@Test
	public void categoryNotExistTest() throws  CategoryException {
		
		List<BookCategory> categoryInformation=service.listAllCategory();
	assertFalse(categoryInformation.isEmpty());
	}
}
