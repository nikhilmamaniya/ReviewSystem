package com.reviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reviewSystem.model.Company;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Users;
import com.reviewSystem.service.CompanyReviewService;
import com.reviewSystem.service.CompanyService;

@RestController
@RequestMapping(value = "/review/company")
public class CompanyReviewController{

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyReviewService companyReviewService;
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	public void setCompanyReviewService(CompanyReviewService companyReviewService) {
		this.companyReviewService = companyReviewService;
	}

	@RequestMapping(value = "/{companyId}", method = RequestMethod.POST)
	public CompanyReview postCompanyReview(@PathVariable(value = "companyId") String companyId ,@RequestBody CompanyReview companyReview){
		Company company = companyService.getCompany(Integer.parseInt(companyId));
		companyReview.setCompany(company);
		
		return companyReviewService.postCompanyReview(getUser(), companyReview);
	}

	@RequestMapping(value = "/all/{companyId}", method = RequestMethod.GET)
	public List<CompanyReview> getCompanyReviews(@PathVariable(value = "companyId") String companyId){
		return companyReviewService.getAllReviews(Integer.parseInt(companyId));
	}
	
	@RequestMapping(value = "/{reviewId}",method = RequestMethod.GET)
	public CompanyReview getCompanyReview(@PathVariable(value = "reviewId") String reviewId){
		return companyReviewService.getCompanyReview(reviewId);
	}
	
	@RequestMapping(value="/{reviewId}",method = RequestMethod.PUT)
	public CompanyReview updateCompanyReview(@PathVariable(value = "reviewId")String reviewId, @RequestBody CompanyReview companyReview){
		String username = "user9";
		return companyReviewService.updateCompanyReview(username, reviewId, companyReview);		
	}
	
	@RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
	public boolean deleteCompanyReview(@PathVariable(value ="reviewId") String reviewId ){
		String username="user12";
		return companyReviewService.deleteReview(username, reviewId);
	}
	
	private Users getUser() {
		Users u = new Users();
		u.setUserName("user9");
		u.setUserPassword("pass9");
		
		return u;
	}
}
