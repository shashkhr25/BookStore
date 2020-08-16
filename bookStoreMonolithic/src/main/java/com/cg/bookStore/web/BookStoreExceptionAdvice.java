package com.cg.bookStore.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.BookStoreLoginException;
import com.cg.bookStore.exceptions.CategoryException;

/**************************************************************************************************
 *          @author         shashwat khare
 *          Description      It is a controller class having Request Mapping functions
 *          				 for functionalities of Manage books.
 *          Version             2.0
 *          Created Date    17-July-2020
 **************************************************************************************************/
@RestControllerAdvice
public class BookStoreExceptionAdvice {
	
		@ExceptionHandler(value= {CategoryException.class, BookException.class, BookStoreLoginException.class})
		@ResponseStatus(code=HttpStatus.NOT_FOUND)
		public Map<String,String> handleException(Exception ex) {
			Map<String, String> map = new HashMap<>();
			map.put("message", ex.getMessage());
			return map;
		}
}
