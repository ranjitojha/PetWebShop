package com.petshop.core.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.service.PlaceOrderService;





/**
 * Place order Controller
 * 
 * @author ranjit
 *
 */
@RestController
public class UserOrderPlaceController {

	private static final Logger LOGGER = Logger
			.getLogger(UserOrderPlaceController.class);

	@Autowired
	private PlaceOrderService placeOrderService;

	/**
	 * This method checkout the product and place order
	 * 
	 * @param userId
	 * @param transactionID
	 * @param totalPrice
	 * @param status
	 * @param cartItems
	 */
	@RequestMapping(value = "/paymentCheckOut/{userId}/{transactionID}/{totalPrice}/{status}/{cartItems}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public void checkOutPlaceOrder(@PathVariable("userId") String userId,
			@PathVariable("transactionID") String transactionID,
			@PathVariable("totalPrice") BigDecimal totalPrice,
			@PathVariable("status") String status,
			@PathVariable("cartItems") List<String> cartItems) {
		LOGGER.info("Inside ChekOutController" + cartItems);
		try {
			placeOrderService.productCheckOut(userId, transactionID,
					totalPrice, status, cartItems);
		} catch (Exception e) {
			LOGGER.error("Exception during order Processing " + e);
		}
	}
}
