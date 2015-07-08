package com.petshop.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.core.model.Product;
import com.petshop.core.model.ProductCatagory;
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

	@Autowired
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
	@RequestMapping(value = "/productMasterAdmin", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public List<Product> getProductList() {
		LOGGER.info("Inside getProductList Controller --- Admin");
		List<Product> prodlist = null;
		try {
			prodlist = productService.getAllProduct();
		} catch (Exception e) {
			LOGGER.error("Exception occured during get all product list : " + e);
		}
		LOGGER.info("Product list size " + prodlist.size());

		return prodlist;
	}

	/**
	 * This method will get all product list from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/productAddAdmin/{prodName}/{prodPrice}/{prodQuant}/{category}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void addProduct(@PathVariable("prodName") String productName,
			@PathVariable("prodPrice") int productPrice,
			@PathVariable("prodQuant") int productQuantity,
			@PathVariable("category") int productCategory) {

		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductQuantity(productQuantity);
		ProductCatagory prodCat = new ProductCatagory();
		prodCat.setCatagoryId(productCategory);
		product.setProductCatagory(prodCat);

		try {
			productService.addProduct(product);
		} catch (Exception e) {
			LOGGER.error("Exception During Adding product " + e);
		}

	}

	/**
	 * This method will get all product list from DB
	 * 
	 * @return
	 */

	@RequestMapping(value = "/productDeleteAdmin/{prodId}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void deleteProduct(@PathVariable("prodId") int productId) {
		try {
			productService.deleteProduct(productId);
		} catch (Exception e) {
			LOGGER.error("Error while deleting product " + e);
		}
	}

	/**
	 * This method will edit product list from DB
	 * 
	 * @return
	 */

	@RequestMapping(value = "/productEditAdmin/{prodId}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void editProduct(@PathVariable("prodId") int productId) {
		try {
			productService.deleteProduct(productId);
		} catch (Exception e) {
			LOGGER.error("Error while deleting product " + e);
		}
	}

}
