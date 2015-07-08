package com.petshop.core.service;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;

/**
 * User Registration
 * 
 * @author ranjit
 *
 */
public interface UserRegistrationService {
	/**
	 * This method is for registering user to shopping cart.
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void userRegistration(User user) throws BusinessException;
}
