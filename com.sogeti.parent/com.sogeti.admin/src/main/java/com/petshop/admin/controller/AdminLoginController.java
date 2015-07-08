package com.petshop.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.UserLoginService;

/**
 * User Login Controller
 * 
 * @author ranjit
 *
 */
@SuppressWarnings("unused")
@RestController
public class AdminLoginController {

	private static final Logger LOGGER = Logger
			.getLogger(AdminLoginController.class);

	private static final String APPLICATION_XML = "application/xml";

	private static final String APPLICATION_JSON = "application/json";

	@Autowired(required = true)
	private UserLoginService userLoginService;

	/**
	 * This method will check for user login credentials
	 * 
	 * @param uname
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/userLogin/{uname}/{password}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public User checkUser(@PathVariable("uname") String uname,
			@PathVariable("password") String password) {
		LOGGER.info("Inside checkUser");
		User user = new User();
		try {
			user = userLoginService.checkUser(uname, password);
		} catch (Exception e) {
			LOGGER.error("Exception occured inside checkUser" + e);
		}
		return user;

	}

}
