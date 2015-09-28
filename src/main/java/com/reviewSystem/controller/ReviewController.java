/*package com.reviewSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reviewSystem.model.Company;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.service.CompanyReviewService;
import com.reviewSystem.service.CompanyService;

@RestController
public class ReviewController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyReviewService companyReviewService;
	
	@RequestMapping(value = "/review/postCompanyReview/{companyId}", method = RequestMethod.POST)
	public CompanyReview postCompanyReview(@PathVariable(value = "companyId") String companyId ,@RequestBody CompanyReview companyReview){
		Company company = companyService.getCompany(Integer.parseInt(companyId));
		companyReviewService.postCompanyReview(userId, companyReview);
		return null;CompanyReviewService.postNewReview();
	}
}
*/