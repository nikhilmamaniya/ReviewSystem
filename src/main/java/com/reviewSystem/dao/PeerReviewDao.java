package com.reviewSystem.dao;

import java.util.List;

import com.reviewSystem.model.Peer;
import com.reviewSystem.model.PeerReview;

public interface PeerReviewDao {
	public PeerReview post(PeerReview review);
	public PeerReview get(String reviewId);
	public List<PeerReview> getAll(String peerId);
	public PeerReview update(PeerReview review);
	public boolean delete(String reviewId);
	public Peer getPeer(String peerId);
}
