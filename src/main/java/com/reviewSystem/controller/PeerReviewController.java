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

import com.reviewSystem.model.PeerReview;
import com.reviewSystem.service.PeerReviewService;

/**
 * @author Rushabh Soni
 *
 */
@RestController
@RequestMapping(value = "/review/peer")
public class PeerReviewController {
	@Autowired
	PeerReviewService peerReviewService;

	public void setPeerReviewService(PeerReviewService peerReviewService) {
		this.peerReviewService = peerReviewService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public PeerReview post(@PathVariable(value = "id")String peerId , @RequestBody PeerReview review ){
		return peerReviewService.post(review, peerId);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public PeerReview getReview(@PathVariable(value = "id") String reviewId){
		return peerReviewService.get(reviewId);
	}
	
	@RequestMapping(value = "/all/{peerId}" , method = RequestMethod.GET)
	public List<PeerReview> getReviews(@PathVariable(value ="peerId") String peerId){
		return peerReviewService.getAll(peerId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public PeerReview updateReview(@RequestBody PeerReview review){
		return peerReviewService.update(review);
	}
	
	@RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
	public boolean deleteReview(@PathVariable(value ="id") String id){
		return peerReviewService.delete(id);
	}
}
