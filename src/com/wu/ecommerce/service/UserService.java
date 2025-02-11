package com.wu.ecommerce.service; 
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;
 
import com.wu.ecommerce.dto.User;

import com.wu.ecommerce.exception.DataNotFoundException;

import com.wu.ecommerce.exception.IdNotFoundException;

import com.wu.ecommerce.exception.InvalidUserIdException;
 
public interface UserService {

	public User addUser(User user) throws SQLException;

	public User getUserById(String id) throws IdNotFoundException, SQLException, InvalidUserIdException;

	public List<User> getUsers() throws DataNotFoundException, SQLException, InvalidUserIdException;

	public String removeUserById(String id) throws IdNotFoundException, SQLException, InvalidUserIdException;
	public User updateUserById(String id, User user) throws SQLException;

}

 