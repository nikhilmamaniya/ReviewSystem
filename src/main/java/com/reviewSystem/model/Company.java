package com.reviewSystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	private int companyId;
	private String companyName;
	/*private List<Department> departments;
	private List<CompanyReview> companyReviews;*/
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
/*	@OneToMany(fetch=FetchType.LAZY,mappedBy = "company")
	public List<CompanyReview> getCompanyReviews() {
		return companyReviews;
	}
	public void setCompanyReviews(List<CompanyReview> companyReviews) {
		this.companyReviews = companyReviews;
	}*/
	
	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}
