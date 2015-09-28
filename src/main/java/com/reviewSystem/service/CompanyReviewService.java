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
	public int postCompanyReview(Users user, CompanyReview companyReview);
	public List<CompanyReview> getAllReviews(int companyId);
	public CompanyReview getCompanyReview(int companyReviewId);
	public int updateCompanyReview(String username, int companyReviewId,CompanyReview companyReview);
	public boolean deleteReview(String username, int companyReviewId);
}
