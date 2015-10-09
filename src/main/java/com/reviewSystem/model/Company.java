package com.reviewSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	/*private List<Department> departments;
	private List<CompanyReview> companyReviews;*/
	
	private int companyId;
	private String companyName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
/*	@OneToMany(fetch=FetchType.LAZY,mappedBy = "company")
	public List<CompanyReview> getCompanyReviews() {
		return companyReviews;
	}
	public void setCompanyReviews(List<CompanyReview> companyReviews) {
		this.companyReviews = companyReviews;
	}*/
	
}
