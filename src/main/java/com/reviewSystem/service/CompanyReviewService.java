/**
 * 
 */
package com.reviewSystem.service;

import java.util.List;

import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Users;

/**
 * @author Rushabh Soni
 *
 */
public interface CompanyReviewService {
	public CompanyReview postCompanyReview(Users user, CompanyReview companyReview);
	public List<CompanyReview> getAllReviews(int companyId);
	public CompanyReview getCompanyReview(String companyReviewId);
	public CompanyReview updateCompanyReview(String username, String companyReviewId,CompanyReview companyReview);
	public boolean deleteReview(String username,String companyReviewId);
}
