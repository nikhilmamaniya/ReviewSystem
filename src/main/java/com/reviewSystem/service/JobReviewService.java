/**
 * 
 */
package com.reviewSystem.service;

import java.util.List;

import com.reviewSystem.model.JobReview;

/**
 * @author Rushabh Soni
 *
 */
public interface JobReviewService {
	public JobReview postReview(JobReview review,String jobId);
	public JobReview getReview(String reviewId);
	public List<JobReview> getReviews(String jobId);
	public JobReview updateReview(JobReview review);
	public boolean deleteReview(String reviewId); 
}
