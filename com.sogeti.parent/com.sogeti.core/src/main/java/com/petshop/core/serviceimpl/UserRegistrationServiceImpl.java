package com.petshop.core.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.UserRegistrationDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;
import com.petshop.core.service.UserRegistrationService;

/**
 * User Registration impl
 * 
 * @author ranjit
 *
 */
@Service("userRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationDao userRegistrationDao;

	/**
	 * This method is for registering user to shopping cart.
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void userRegistration(User user) throws BusinessException {
		userRegistrationDao.userRegistration(user);
	}

}
