package com.reviewSystem.dao;

import java.util.List;

import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Users;

public interface CompanyReviewDao {
	public int postCompanyReview(CompanyReview companyReview);
	public List<CompanyReview> fetchAllReviews(int companyId);
	public CompanyReview getCompanyReview(int companyReviewId);
	public int updateCompanyReview(  CompanyReview companyReview);
	public boolean deleteReview(String username,int companyReviewId);
	
}
