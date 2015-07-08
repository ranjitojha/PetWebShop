package com.petshop.core.service;

import java.math.BigDecimal;
import java.util.List;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Order;

/**
 * Product order service
 * 
 * @author ranjit
 *
 */
public interface PlaceOrderService {
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
	 * This Method is used to fetch the Order from shopping cart
	 * 
	
	 * @throws Exception
	 */
	public List<Order> getAllOrder() throws BusinessException;
}
