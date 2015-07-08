package com.petshop.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.core.model.Product;
import com.petshop.core.service.ProductService;

/**
 * Product Controller
 * 
 * @author ranjit
 *
 */
@RestController
public class ProductController {

	private static final Logger LOGGER = Logger
			.getLogger(ProductController.class);
	private static final String APPLICATION_XML = "application/xml";

	private static final String APPLICATION_JSON = "application/json";

	@Autowired(required = true)
	private ProductService productService;

	/**
	 * This method sets default view on load of application
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
		return new ModelAndView("default");
	}

	/**
	 * This method will get all product list from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/productMaster", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public List<Product> getProductList() {
		LOGGER.info("Inside getProductList Controller");
		List<Product> prodlist = null;
		try {
			prodlist = productService.getAllProduct();
		} catch (Exception e) {
			LOGGER.error("Exception occured during get all product list : " + e);
		}
		LOGGER.info("Product list size " + prodlist.size());

		return prodlist;
	}
	
	

}
