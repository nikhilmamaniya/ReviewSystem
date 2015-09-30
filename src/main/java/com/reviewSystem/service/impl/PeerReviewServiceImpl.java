/**
 * 
 */
package com.reviewSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.PeerReviewDao;
import com.reviewSystem.model.Peer;
import com.reviewSystem.model.PeerReview;
import com.reviewSystem.service.PeerReviewService;

/**
 * @author Rushabh Soni
 *
 */
@Service("PeerReviewService")
@Transactional
public class PeerReviewServiceImpl implements PeerReviewService{
	
	@Autowired
	PeerReviewDao peerReviewDao;
	
	public void setPeerReviewDao(PeerReviewDao peerReviewDao) {
		this.peerReviewDao = peerReviewDao;
	}

	@Override
	public PeerReview post(PeerReview review, String peerId) {
		Peer peer = peerReviewDao.getPeer(peerId);
		review.setPeer(peer);
		return peerReviewDao.post(review);
	}

	@Override
	public PeerReview get(String reviewId) {
		
		return peerReviewDao.get(reviewId);
	}

	@Override
	public List<PeerReview> getAll(String peerId) {
		return peerReviewDao.getAll(peerId);
	}

	@Override
	public PeerReview update(PeerReview review) {
		return peerReviewDao.update(review);
	}

	@Override
	public boolean delete(String reviewId) {
		return peerReviewDao.delete(reviewId);
	}

}
