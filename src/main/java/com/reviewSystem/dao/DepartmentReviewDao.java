/**
 * 
 */
package com.reviewSystem.dao;

import java.util.List;



import com.reviewSystem.model.DepartmentReview;
import com.reviewSystem.model.Users;

/**
 * @author Rushabh Soni
 *
 */
public interface DepartmentReviewDao {
	public int postDepartmentReview(DepartmentReview departmentReview);
	public List<DepartmentReview> fetchAllReviews(int departmentId);
	public DepartmentReview getDepartmentReview(int departmentReviewId);
	public int updateDepartmentReview(  DepartmentReview departmentReview);
	public boolean deleteReview(int userId,int departmentReviewId);
	public Users getUser(int departmentReviewId);
}
