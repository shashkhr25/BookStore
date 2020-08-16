package com.cg.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.exceptions.BookStoreLoginException;

@Service
@Transactional
public class BookStoreLoginServiceImpl implements BookStoreLoginService{

	@Autowired
	private BookStoreDao bookStoreDao;
	
	public String loginAdmin(String email, String password) throws BookStoreLoginException {
		if(!bookStoreDao.checkAdminByEmail(email))
		{
			throw new BookStoreLoginException("Admin is not registered");

		}
		Admin admin=bookStoreDao.getAdminByEmail(email);
		if((admin.getPassword().equals(password)==false))
		{
			throw new BookStoreLoginException("Admin is not registered");
		}
			
		return "Logged in";
	}
}
