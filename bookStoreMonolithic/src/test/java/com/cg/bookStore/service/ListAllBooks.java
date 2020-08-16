package com.cg.bookStore.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ListAllBooks {

	@Mock
	private BookStoreDao dao;
	
	@Autowired
	private ManageBookServiceImpl service;
	
	@Test
	public void bookNotExistTest() throws BookException {
		
		List<BookInformation> bookInformation=service.displayBooks();
	assertFalse(bookInformation.isEmpty());
	}

}