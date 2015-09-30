/**
 * 
 */
package com.reviewSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rushabh Soni
 *
 */
@Entity
@Table(name = "PEER_REVIEW")
public class PeerReview {
	@Id
	@Column(name = "REVIEW_ID")
	private String id;
	@Column(name = "REVIEW")
	private String Review;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "PEER_ID")
	private Peer peer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public Peer getPeer() {
		return peer;
	}
	public void setPeer(Peer peer) {
		this.peer = peer;
	}
	
}
