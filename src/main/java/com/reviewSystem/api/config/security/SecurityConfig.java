/**
 * 
 */
package com.reviewSystem.api.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Rushabh Soni
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
				.inMemoryAuthentication()
					.withUser("invalid").password("password").roles("USER");
	}
}
