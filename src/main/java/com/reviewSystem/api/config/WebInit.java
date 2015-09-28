package com.reviewSystem.api.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		// Creates the root application context
		AnnotationConfigWebApplicationContext appContext =
			      new AnnotationConfigWebApplicationContext();
		
		// Registers the application configuration with the root context
		appContext.register(AppConfig.class);
		
		// Creates the Spring Container shared by all Servlets and Filters
		servletContext.addListener(new ContextLoaderListener(appContext));
		
		 // Create the dispatcher servlet's Spring application context
	      AnnotationConfigWebApplicationContext dispatcherContext =
	        new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(WebConfig.class);

	      ServletRegistration.Dynamic dispatcher =
	    		  servletContext.addServlet("spring-mvc-dispatcher",
	    	              new DispatcherServlet(dispatcherContext));
	    	dispatcher.setLoadOnStartup(1);
	    	dispatcher.addMapping("/");
	}

}
