/**
 * 
 */
package com.reviewSystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewSystem.dao.JobReviewDao;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Job;
import com.reviewSystem.model.JobReview;

/**
 * @author Rushabh Soni
 *
 */
@Repository("JobReviewDao")
public class JobReviewDaoImpl implements JobReviewDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.JobReviewDao#postReview(com.reviewSystem.model.JobReview)
	 */
	@Override
	public JobReview postReview(JobReview review) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(review);
		return review;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.JobReviewDao#getReview(java.lang.String)
	 */
	@Override
	public JobReview getReview(String reviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from JobReview jr where jr.id = :jobReviewId";
		Query query = currentSession.createQuery(queryString );
		query.setString("jobReviewId", reviewId);
		JobReview review = (JobReview) query.list().get(0);
		return review;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.JobReviewDao#getReviews(java.lang.String)
	 */
	@Override
	public List<JobReview> getReviews(String jobId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from JobReview jr where jr.job.jobId = :jobId";
		Query query = currentSession.createQuery(queryString );
		query.setString("jobId", jobId);
		 List<JobReview> reviews=  query.list();
		return reviews;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.JobReviewDao#updateReview(com.reviewSystem.model.JobReview)
	 */
	@Override
	public JobReview updateReview(JobReview review) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(review);
		return review;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.JobReviewDao#deleteReview(java.lang.String)
	 */
	@Override
	public boolean deleteReview(String reviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		JobReview jobReview = (JobReview) currentSession.load(JobReview.class, reviewId);
		currentSession.delete(jobReview);
		return true;
	}

	@Override
	public Job getJob(String jobId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Job j where j.jobId =:jobId";
		Query query = currentSession.createQuery(queryString);
		query.setString("jobId", jobId);
		Job job = (Job) query.list().get(0);
		return job;
	}

}
