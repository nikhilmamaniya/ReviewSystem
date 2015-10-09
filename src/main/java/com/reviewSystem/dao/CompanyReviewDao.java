package com.reviewSystem.dao;

import java.util.List;

import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Users;

public interface CompanyReviewDao {
	public CompanyReview postCompanyReview(CompanyReview companyReview);
	public List<CompanyReview> fetchAllReviews(int companyId);
	public CompanyReview getCompanyReview(String companyReviewId);
	public CompanyReview updateCompanyReview(  CompanyReview companyReview);
	public boolean deleteReview(String username,String companyReviewId);
	
}
