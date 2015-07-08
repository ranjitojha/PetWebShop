package com.petshop.core.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.UserLoginDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;
import com.petshop.core.service.UserLoginService;

/**
 * User Login Service impl
 * 
 * @author ranjit
 *
 */
@Service("userLoginService")
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDao userLoginDao;

	/**
	 * This method is to check user login
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String uname, String password) throws BusinessException {

		return userLoginDao.checkUser(uname, password);
	}

	/**
	 * This method is to get all Users.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws BusinessException {
		return userLoginDao.getAllUser();
	}
	
	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteUser(int userId) throws BusinessException {

		userLoginDao.deleteUser(userId);
	}

}
