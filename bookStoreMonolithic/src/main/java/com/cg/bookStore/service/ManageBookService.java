package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.dto.BookForm;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;

/**************************************************************************************************
 *          @author         Rohita, Aishwarya, Amardeep, Sachin
 *          Description      It is an interface containing manage book functions. implementation will 
 *          					be done in implemented class. reference is to be given of this interface to user.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
public interface ManageBookService {

	public String deleteBook(int bookId) throws BookException;
	public String createBook(BookForm book) throws BookException;
	public String updateBook(BookInformation book) throws BookException;
	public List<BookInformation> displayBooks() throws BookException;
}
