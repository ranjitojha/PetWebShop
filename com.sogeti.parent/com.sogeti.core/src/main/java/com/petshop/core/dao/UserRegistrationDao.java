package com.petshop.core.dao;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;

/**
 * User registration
 * 
 * @author ranjit
 *
 */
public interface UserRegistrationDao {

	/**
	 * This method is for registering user to shopping cart.
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void userRegistration(User user) throws BusinessException;

}
