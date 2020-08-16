package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookStore.dto.ResponseMessage;
import com.cg.bookStore.exceptions.BookStoreLoginException;
import com.cg.bookStore.service.BookStoreLoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private BookStoreLoginService bookStoreService;
	
	@GetMapping("/adminlogin/{email}/{password}")
	public ResponseMessage adminlogin(@PathVariable("email")String email, @PathVariable("password")String password) throws BookStoreLoginException {
		ResponseMessage message = new ResponseMessage();
		message.setMessage(bookStoreService.loginAdmin(email, password));
		return message;
	}
}
