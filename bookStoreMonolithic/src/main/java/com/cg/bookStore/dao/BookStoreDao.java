package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
/**************************************************************************************************
*          @author         Rohita, Aishwarya, Amardeep, Sachin, Vainkatesh, Abhilash, Shashwat
*          Description      It is an interface containing dao functions. implementation will 
*          					be done in implemented class. reference is to be given of this interface to user.
*          Version             2.0
*          Created Date    17-July-2020
**************************************************************************************************/
public interface BookStoreDao {

	public boolean createCategory(BookCategory category);
	
	public boolean deleteBook(int bookId);
	public boolean addBook(BookInformation bookInfo);
	public List<BookInformation> listAllBooks();
	
	public boolean updateBookInfo(BookInformation bookInfo);
	
	public boolean updateCategory(BookCategory category);
	public boolean deleteCategory(int categoryId);
	
	public boolean categoryExists(String categoryName);
	public boolean categoryExists(int categoryId);
	public boolean bookExists(int bookId);
	public boolean bookExists(String bookName);
	public List<BookCategory> listAllCategory();
	public BookCategory viewCategory(Integer categoryId);
	boolean categoryContainsBook(int categoryId);

	public Admin getAdminByEmail(String email);
	boolean checkAdminByEmail(String email);
}
