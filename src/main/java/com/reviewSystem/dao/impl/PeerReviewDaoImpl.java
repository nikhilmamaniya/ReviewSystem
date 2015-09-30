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

import com.reviewSystem.dao.PeerReviewDao;
import com.reviewSystem.model.Peer;
import com.reviewSystem.model.PeerReview;

/**
 * @author Rushabh Soni
 *
 */
@Repository("PeerReviewDao")
public class PeerReviewDaoImpl implements PeerReviewDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public PeerReview post(PeerReview review) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(review);
		return review;
	}

	@Override
	public PeerReview get(String reviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from PeerReview pr where pr.id = :peerReviewId";
		Query query = currentSession.createQuery(queryString );
		query.setString("peerReviewId", reviewId);
		PeerReview review = (PeerReview) query.list().get(0);
		return review;
	}

	@Override
	public List<PeerReview> getAll(String peerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from PeerReview pr where pr.peer.id = :peerId";
		Query query = currentSession.createQuery(queryString );
		query.setString("peerId", peerId);
		 List<PeerReview> reviews=  query.list();
		return reviews;
	}

	@Override
	public PeerReview update(PeerReview review) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(review);
		return review;
	}

	@Override
	public boolean delete(String reviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		PeerReview peerReview = (PeerReview) currentSession.load(PeerReview.class, reviewId);
		currentSession.delete(peerReview);
		return true;
	}

	@Override
	public Peer getPeer(String peerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Peer p where p.peerId =:peerId";
		Query query = currentSession.createQuery(queryString);
		query.setString("peerId", peerId);
		Peer peer = (Peer) query.list().get(0);
		return peer;
	}
	
}
