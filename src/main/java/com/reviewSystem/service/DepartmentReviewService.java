/**
 * 
 */
package com.reviewSystem.service;

import java.util.List;

import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.DepartmentReview;
import com.reviewSystem.model.Users;

/**
 * @author Rushabh Soni
 *
 */
public interface DepartmentReviewService {
	public int postDepartmentReview(Users user, DepartmentReview departmentReview);
	public List<DepartmentReview> getAllReviews(int departmentId);
	public DepartmentReview getDepartmentReview(int departmentReviewId);
	public int updateDepartmentReview(int userId, int departmentReviewId,DepartmentReview departmentReview);
	public boolean deleteReview(int userId, int departmentReviewId);
}
