/**
 * 
 */
package com.reviewSystem.dao;

import java.util.List;

import com.reviewSystem.model.Job;
import com.reviewSystem.model.JobReview;

/**
 * @author Rushabh Soni
 *
 */
public interface JobReviewDao {
	public JobReview postReview(JobReview review);
	public JobReview getReview(String reviewId);
	public List<JobReview> getReviews(String jobId);
	public JobReview updateReview(JobReview review);
	public boolean deleteReview(String reviewId);
	public Job getJob(String jobId);
}
