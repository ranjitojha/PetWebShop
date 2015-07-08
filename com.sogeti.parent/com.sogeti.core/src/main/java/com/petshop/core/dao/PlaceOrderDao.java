package com.petshop.core.dao;

import java.math.BigDecimal;
import java.util.List;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Order;

/**
 * Product CheckOut
 * 
 * @author ranjit
 *
 */
public interface PlaceOrderDao {
	/**
	 * This Method is used to checkout the product from shopping cart
	 * 
	 * @param userId
	 * @param transactionID
	 * @param totalPrice
	 * @param status
	 * @param cartItems
	 * @throws Exception
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems)
			throws BusinessException;
	
	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Order> getAllOrder() throws BusinessException;
}
