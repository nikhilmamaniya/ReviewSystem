package com.reviewSystem.service;

import java.util.List;

import com.reviewSystem.model.PeerReview;

public interface PeerReviewService {
	public PeerReview post(PeerReview review, String peerId);
	public PeerReview get(String reviewId);
	public List<PeerReview> getAll(String peerId);
	public PeerReview update(PeerReview review);
	public boolean delete(String reviewId);
}
