package com.petshop.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.UserLoginService;

@RestController
public class UserDetailsController {

	private static final Logger LOGGER = Logger.getLogger(UserDetailsController.class);
	
	private static final String APPLICATION_XML = "application/xml";

	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private UserLoginService userLoginService;

	/**
	 * This method will get all product list from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	@ResponseBody
	public List<User> getAllUser() {
		LOGGER.info("Inside getUserList Controller --- Admin");
		List<User> userlist = null;
		try {
			userlist = userLoginService.getAllUser();
		} catch (Exception e) {
			LOGGER.error("Exception occured during get all user list : " + e);
		}
		LOGGER.info("User list size " + userlist.size());

		return userlist;
	}
	
	/**
	 * This method will delete product list from DB
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "/userDelete/{userId}", method = RequestMethod.GET, produces = {
			APPLICATION_XML, APPLICATION_JSON })
	public void userDelete(@PathVariable("userId") int userId) {
		try {
			userLoginService.deleteUser(userId);
		} catch (Exception e) {
			LOGGER.error("Error while deleting product " + e);
		}
	}
}
