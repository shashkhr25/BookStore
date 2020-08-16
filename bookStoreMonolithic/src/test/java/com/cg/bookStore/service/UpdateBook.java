package com.cg.bookStore.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.bookStore.dao.BookStoreDaoImpl;
import com.cg.bookStore.entities.BookInformation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateBook {
	@Autowired
	ManageBookServiceImpl bookServiceTest;
	
	@MockBean
	BookStoreDaoImpl bookDaoTest;
	
	@Mock
	BookInformation bookInfo;
	
	@Test
	public void daoTesting()throws Exception {
		BookInformation bookInfo=new BookInformation();
		bookInfo.setBookId(1);
		bookInfo.setAuthor("Sachin");
		bookInfo.setDescription("Science");
		bookInfo.setIsbnNumber("123");
		bookInfo.setLastUpdateTime(null);
		bookInfo.setPublishDate(null);
		bookInfo.setTitle("Science");
		Mockito.when(bookDaoTest.updateBookInfo(bookInfo)).thenReturn(true);
		assertThat(bookServiceTest.updateBook(bookInfo)).isEqualTo("book updated");
	}
	@Test
	public void daoBookTesting()throws Exception {
		assertThat(bookServiceTest.updateBook(bookInfo)).isEqualTo("Some error occured, try again");
	}
}