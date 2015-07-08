package com.petshop.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

}
