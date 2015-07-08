package com.petshop.core.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.PlaceOrderDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Order;
import com.petshop.core.service.PlaceOrderService;

/**
 * Product order service
 * 
 * @author ranjit
 *
 */
@Service("placeOrderService")
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

	@Autowired
	private PlaceOrderDao placeOrderDao;

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
			throws BusinessException {
		placeOrderDao.productCheckOut(userId, transactionID, totalPrice,
				status, cartItems);

	}

	/**
	 * This method is to get all Orders.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Order> getAllOrder() throws BusinessException {
		// TODO Auto-generated method stub
		return placeOrderDao.getAllOrder();
	}

}
