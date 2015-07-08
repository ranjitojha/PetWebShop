package com.petshop.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.ProductCatagory;
import com.petshop.core.service.CategoryService;

@RestController
public class CategoryController {

	private static final Logger LOGGER = Logger
			.getLogger(ProductController.class);
	
	private static final String APPLICATION_XML = "application/xml";

	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/productCatAdd/{catName}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void addProduct(@PathVariable("catName") String catagoryName) {

		ProductCatagory prodCatObj = new ProductCatagory();
		prodCatObj.setCatagoryName(catagoryName);
		try {
			categoryService.addCategory(prodCatObj);
		} catch (Exception e) {
			LOGGER.error("Exception During Adding product " + e);
		}

	}

	@RequestMapping(value = "/allCategoryAdmin", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public List<ProductCatagory> getAllCategory() {
		List<ProductCatagory> proCat = null;
		try {
			proCat = categoryService.getAllCategory();

		} catch (Exception e) {
			LOGGER.error("Exception During getting all category" + e);
		}
		return proCat;
	}

	@RequestMapping(value = "/productCatDeleteAdmin/{catId}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void deleteProduct(@PathVariable("catId") Long catId) {
		try {
			categoryService.deleteCategory(catId);
		} catch (Exception e) {
			LOGGER.error("Error while deleting product " + e);
		}
	}

}
