package com.petshop.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.Order;
import com.petshop.core.service.PlaceOrderService;

@RestController
public class OrderDetailsController {
	private static final Logger LOGGER = Logger.getLogger(OrderDetailsController.class);
	
	private static final String APPLICATION_XML = "application/xml";

	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private PlaceOrderService placeOrderService;

	/**
	 * This method will get all product list from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public List<Order> getAllOrder() {
		LOGGER.info("Inside getorderlist Controller --- Admin");
		List<Order> orderlist = null;
		try {
			orderlist = placeOrderService.getAllOrder();
		} catch (Exception e) {
			LOGGER.error("Exception occured during get all orderlist list : " + e);
		}
		LOGGER.info("orderlist list size " + orderlist.size());

		return orderlist;
	}
}
