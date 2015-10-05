/**
 * 
 */
package com.reviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reviewSystem.model.JobReview;
import com.reviewSystem.service.JobReviewService;

/**
 * @author Rushabh Soni
 *
 */
@RestController
@RequestMapping(value = "/review/job")
public class JobReviewController {
	
	@Autowired
	JobReviewService jobReviewService;

	public void setJobReviewService(JobReviewService jobReviewService) {
		this.jobReviewService = jobReviewService;
	}
	
	@RequestMapping(value="/{jobId}",method = RequestMethod.POST)
	public JobReview postReview(@PathVariable(value="jobId") String jobId,@RequestBody JobReview review){
		return jobReviewService.postReview(review,jobId);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public JobReview getReview(@PathVariable(value = "id") String reviewId){
		return jobReviewService.getReview(reviewId);
	}
	
	@RequestMapping(value = "/all/{jobId}" , method = RequestMethod.GET)
	public List<JobReview> getReviews(@PathVariable(value ="jobId") String jobId){
		return jobReviewService.getReviews(jobId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public JobReview updateReview(@RequestBody JobReview review){
		return jobReviewService.updateReview(review);
	}
	
	@RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
	public boolean deleteReview(@PathVariable(value ="id") String id){
		return jobReviewService.deleteReview(id);
	}
}
