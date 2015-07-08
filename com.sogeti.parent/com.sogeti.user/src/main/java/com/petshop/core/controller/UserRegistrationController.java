package com.petshop.core.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.UserRegistrationService;

/**
 * User Registration Controller
 * 
 * @author ranjit
 *
 */
@RestController
public class UserRegistrationController {

	private static final Logger LOGGER = Logger
			.getLogger(UserLoginController.class);

	@Autowired(required = true)
	private UserRegistrationService userRegistrationService;

	/**
	 * This method will register or add's user details to DB
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 */
	@RequestMapping(value = "/addNewUser/{firstname}/{lastname}/{username}/{password}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public void userRegistration(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname,
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		LOGGER.info("Inside User Controller");

		User userObj = new User();
		userObj.setFirstName(firstname);
		userObj.setLastName(lastname);
		userObj.setUserName(username);
		userObj.setPassword(password);
		userObj.setUserType("4");

		try {
			userRegistrationService.userRegistration(userObj);
		} catch (Exception e) {
			LOGGER.error("Exception during user registration " + e);
		}

	}

}
