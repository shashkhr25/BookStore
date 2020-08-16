package com.cg.bookStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dto.BookForm;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.util.BookStoreConstants;

/**************************************************************************************************
 *          @author         Rohita, Aishwarya, Amardeep, Sachin
 *          Description      This class implements the ManageBookService interface.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
@Service
@Transactional
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	private BookStoreDao bookStoreDao;
	
	/*******************************************
	 * Method: deleteBook
     *Description: To write business logic for delete book 
	 * @param name              - bookId.
	 * @returns shows(String)   - Message that book deleted or not
	 * @throws BookException - When that book does not exists in database, exception is thrown. 
                *Created By                              - Aishwarya srivastava
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	@Override
	public String deleteBook(int bookId) throws BookException {
		if(bookStoreDao.bookExists(bookId)) {
			bookStoreDao.deleteBook(bookId);
			return BookStoreConstants.BOOK_DELETED;
		}
		throw new BookException(BookStoreConstants.BOOK_DOES_NOT_EXIST);
	}
	
	/*******************************************
	 * Method: createBook
     *Description: To write create book business logic. 
	 * @param name              - book.
	 * @returns shows(String)   - Message that book added or not
	 * @throws BookException - When that book does already exists in database, exception is thrown. 
                *Created By                              - Rohita Rani
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	public String createBook(BookForm book) throws BookException{
		BookInformation binfo=new BookInformation();
		BookCategory cinfo=bookStoreDao.viewCategory(book.getCategoryId());
		
		binfo.setTitle(book.getTitle());
		binfo.setAuthor(book.getAuthor());
		binfo.setDescription(book.getDescription());
		binfo.setPrice(book.getPrice());
		binfo.setIsbnNumber(book.getIsbnNumber());
		binfo.setPublishDate(book.getPublishDate());
		binfo.setCategory(cinfo);
		
		
		if (cinfo == null)
		{
			throw new BookException(BookStoreConstants.CATEGORY_DOES_NOT_EXIST);
		}
	
		if(bookStoreDao.bookExists(book.getTitle())) {
			throw new BookException(BookStoreConstants.BOOK_EXISTS);
		}
		if(book.getTitle().isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_TITLE_EMPTY);
		}
		
		if(book.getTitle().length()<10 ||book.getTitle().length()>128 ) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_TITLE);
		}
		
		if(book.getAuthor().length()<5 ||book.getAuthor().length()>64 ) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_AUTHOR_);
		}
		if(book.getAuthor().isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_AUTHOR_EMPTY);
		}
		
		if(book.getDescription().length()<200 ||book.getDescription().length()>2000 ) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_DECRIPTION_);
		}
		if(book.getDescription().isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_DESSCRIPTION_EMPTY);
		}
		
		if(book.getIsbnNumber().length()<10 ||book.getIsbnNumber().length()>15 ) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_ISBN_);
		}
		if(book.getIsbnNumber().isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_VALIDATION_ISBN_EMPTY);
		}

		bookStoreDao.addBook(binfo);
		return BookStoreConstants.BOOK_ADDED;
	}
	
	/*******************************************
	 * Method: updateBook
     *Description: To write business logic for update book.
	 * @param name              - book.
	 * @returns shows(String)   - Message that book update or not
	 * @throws BookException - When that book does already exists/ or not in database, exception is thrown. 
                *Created By                              - Sachin kumar
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	public String updateBook(BookInformation book) throws BookException{	
		if(bookStoreDao.bookExists(book.getTitle())) {
			throw new BookException(BookStoreConstants.BOOK_EXISTS);
		}
		else {
			if(bookStoreDao.updateBookInfo(book)) {
				return BookStoreConstants.BOOK_UPDATED;
			}
		}
		throw new BookException(BookStoreConstants.BOOK_ERROR);
	}
	
	/*******************************************
	 * Method: updateBook
     *Description: To write business logic for displaying all books.
	 * @param name              - book.
	 * @returns shows(String)   - Message that book update or not
	 * @throws BookException - When that book does already exists/ or not in database, exception is thrown. 
                *Created By                              - Sachin kumar
                *Created Date                            - 17-Jul-2020                           	 
	 ********************************************/
	public List<BookInformation> displayBooks() throws BookException{
		List<BookInformation>  allBooks= bookStoreDao.listAllBooks();
		if(allBooks.isEmpty()) {
			throw new BookException(BookStoreConstants.BOOK_DOES_NOT_EXIST);
		}
		
		return allBooks;
			
	}

}
