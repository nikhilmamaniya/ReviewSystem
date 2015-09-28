/**
 * 
 */
package com.reviewSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewSystem.model.Users;

/**
 * @author Rushabh Soni
 *
 */
abstract public class BaseController {
	@Autowired
	protected Users user;

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
