package com.petshop.core.daoimpl;

/**
 * User Login 
 * 
 * @author ranjit
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.UserLoginDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.User;

@Repository("userLoginDao")
public class UserLoginDaoImpl implements UserLoginDao {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * This method is to check user login
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String uname, String password)
			throws BusinessException {

		User userDetails = new User();
		String sql = "from User where USERNAME=:USERNAME and PASSWORD=:PASSWORD";
		Query query = manager.createQuery(sql);

		query.setParameter("USERNAME", uname);
		query.setParameter("PASSWORD", password);
		User user = (User) query.getSingleResult();
		if (user != null) {
			userDetails = user;
		}
		return userDetails;

	}

	/**
	 * This method is to fetch the user List
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws BusinessException {
		List<User> userList = manager.createQuery("from User", User.class)
				.getResultList();
		return userList;
	}

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteUser(int userId) throws BusinessException {
		User user = (User) manager.find(User.class, Integer.valueOf(userId));
		manager.remove(user);

	}

}
