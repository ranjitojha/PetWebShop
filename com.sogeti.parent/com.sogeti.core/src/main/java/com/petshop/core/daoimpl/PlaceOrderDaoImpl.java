package com.petshop.core.daoimpl;

/**
 * orderplace DAO
 * @ ranjit
 */
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.petshop.core.dao.PlaceOrderDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Order;
import com.petshop.core.model.User;

@Repository("placeOrderDao")
public class PlaceOrderDaoImpl implements PlaceOrderDao {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * This method is used for product checkout
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems) {
		Order order = new Order();
		User user = new User();
		user.setUserId(Integer.parseInt(userId));

		order.setUser(user);
		order.setTransactionId(transactionID);
		order.setTransactionStatus(status);
		order.setTransactionAmount(totalPrice);
		manager.persist(order);
		manager.flush();

	}

	public List<Order> getAllOrder() throws BusinessException {
		List<Order> orderList = manager.createQuery("from Order", Order.class)
				.getResultList();
		return orderList;
	}
}
