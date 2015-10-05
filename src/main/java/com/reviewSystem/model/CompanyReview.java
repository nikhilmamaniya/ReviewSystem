package com.reviewSystem.model;

import java.util.Date;

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

import org.hibernate.annotations.Type;

@Entity
@Table(name="company_review")
public class CompanyReview {
	private int companyReviewId;
	private Users user;
	private Company company;
	private String review;
	private Date createdDate;
	private Date updatedDate;
	
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
	
	@Column(name = "created_date")
	@Type(type = "timestamp")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}
	@Column(name = "updated_date")
	@Type(type = "timestamp")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
