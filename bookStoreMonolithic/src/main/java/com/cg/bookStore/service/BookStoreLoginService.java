package com.cg.bookStore.service;

import com.cg.bookStore.exceptions.BookStoreLoginException;

public interface BookStoreLoginService {

	public String loginAdmin(String email, String password) throws BookStoreLoginException;
}
