/**
 * 
 */
package com.reviewSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.JobReviewDao;
import com.reviewSystem.model.Job;
import com.reviewSystem.model.JobReview;
import com.reviewSystem.service.JobReviewService;

/**
 * @author Rushabh Soni
 *
 */
@Service("JobReviewService")
@Transactional
public class JobReviewServiceImpl implements JobReviewService {

	@Autowired
	JobReviewDao jobReviewDao;

	public void setJobReviewDao(JobReviewDao jobReviewDao) {
		this.jobReviewDao = jobReviewDao;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.JobReviewService#postReview(com.reviewSystem.model.JobReview)
	 */
	@Override
	public JobReview postReview(JobReview review, String jobId) {
		Job job = jobReviewDao.getJob(jobId);
		review.setJob(job);
		return jobReviewDao.postReview(review);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.JobReviewService#getReview(java.lang.String)
	 */
	@Override
	public JobReview getReview(String reviewId) {
		// TODO Auto-generated method stub
		return jobReviewDao.getReview(reviewId);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.JobReviewService#getReviews(java.lang.String)
	 */
	@Override
	public List<JobReview> getReviews(String jobId) {
		// TODO Auto-generated method stub
		return jobReviewDao.getReviews(jobId);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.JobReviewService#updateReview(com.reviewSystem.model.JobReview)
	 */
	@Override
	public JobReview updateReview(JobReview review) {
		// TODO Auto-generated method stub
		return jobReviewDao.updateReview(review);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.JobReviewService#deleteReview(com.reviewSystem.model.JobReview)
	 */
	@Override
	public boolean deleteReview(String reviewId) {
		// TODO Auto-generated method stub
		return jobReviewDao.deleteReview(reviewId);
	}

}
