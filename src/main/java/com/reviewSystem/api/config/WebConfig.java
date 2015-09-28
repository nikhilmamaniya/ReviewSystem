package com.reviewSystem.api.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.reviewSystem.dao.CompanyDao;
import com.reviewSystem.dao.CompanyReviewDao;
import com.reviewSystem.dao.impl.CompanyDaoImpl;
import com.reviewSystem.dao.impl.CompanyReviewDaoImpl;
import com.reviewSystem.model.Users;
import com.reviewSystem.service.CompanyReviewService;
import com.reviewSystem.service.CompanyService;
import com.reviewSystem.service.impl.CompanyReviewServiceImpl;
import com.reviewSystem.service.impl.CompanyServiceImpl;

@ComponentScan("com.reviewSystem")
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	 
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	 
	 
	/* @Bean(name = "dataSource")
	 public DataSource getDataSource() {
	     BasicDataSource dataSource = new BasicDataSource();
	     dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/review_system");
	     dataSource.setUsername("root1");
	     dataSource.setPassword("password");
	     return dataSource;
	 }
	 
	 @Autowired
	 @Bean(name = "sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource) {
	  
	     LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	  
	     sessionBuilder.scanPackages("com.reviewSystem");
	     
	     sessionBuilder.setProperty("hibernate.show_sql", "true");
	     
	     sessionBuilder.addProperties(getHibernateProperties());
	  
	     return sessionBuilder.buildSessionFactory();
	 }
	 
	 @Autowired
	 @Bean(name = "transactionManager")
	 public HibernateTransactionManager getTransactionManager(
	         SessionFactory sessionFactory) {
	     HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	             sessionFactory);
	  
	     return transactionManager;
	 }
	 */
/*	 @Autowired
	 @Bean(name = "companyReviewDao")
	 public CompanyReviewDao getCompanyReviewDao(SessionFactory sessionFactory) {
	     return new CompanyReviewDaoImpl(sessionFactory);
	 }
	 
	 @Autowired
	 @Bean(name = "companyReviewService")
	 public CompanyReviewService getCompanyReviewService() {
	     return new CompanyReviewServiceImpl();
	 }
	 
	 @Autowired
	 @Bean(name = "companyService")
	 public CompanyService getCompanyService() {
	     return new CompanyServiceImpl();
	 }
	 
	 @Autowired
	 @Bean(name = "companyDao")
	 public CompanyDao getCompanyDao(SessionFactory sessionFactory) {
	     return new CompanyDaoImpl(sessionFactory);
	 }
	 
	 @Autowired
	 @Bean(name = "user")
	 public Users getUser() {
	     return new Users();
	 }
	 
	 private Properties getHibernateProperties() {
		    Properties properties = new Properties();
		    properties.put("hibernate.show_sql", "true");
		    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		    return properties;
		}*/
}
