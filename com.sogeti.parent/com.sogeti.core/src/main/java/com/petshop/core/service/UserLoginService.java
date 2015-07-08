package com.petshop.core.service;

import java.util.List;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;

/**
 * User login Service
 * 
 * @author ranjit
 *
 */
public interface UserLoginService {
	/**
	 * This method is to check user login
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String uname, String password) throws BusinessException;
	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws BusinessException;
	
	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteUser(int userId) throws BusinessException;
}
