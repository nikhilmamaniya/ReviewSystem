package com.reviewSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="company_review")
public class CompanyReview {
	private int companyReviewId;
	private Users user;
	
	private Company company;
	private String review;
	
	
	@Id
	@GeneratedValue
	@Column(name="company_review_id")
	public int getCompanyReviewId() {
		return companyReviewId;
	}
	public void setCompanyReviewId(int companyReviewId) {
		this.companyReviewId = companyReviewId;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Column(name="review")
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
