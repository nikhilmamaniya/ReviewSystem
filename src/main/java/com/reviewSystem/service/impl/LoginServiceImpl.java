/**
 * 
 */
package com.reviewSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewSystem.dao.LoginDao;
import com.reviewSystem.service.LoginService;

/**
 * @author Rushabh Soni
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.LoginService#checkLogin(java.lang.String, java.lang.String)
	 */
	 @Autowired
	 private LoginDao loginDAO;

	   public void setLoginDAO(LoginDao loginDAO) {
              this.loginDAO = loginDAO;
       }
      
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(userName, userPassword);
       }

}
