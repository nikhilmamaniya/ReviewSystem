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
@Table(name = "JOB_REVIEW")
public class JobReview {
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "REVIEW")
	private String review;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID")
	private Job job;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
		
}
