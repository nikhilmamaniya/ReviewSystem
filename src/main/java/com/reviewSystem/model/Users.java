package com.reviewSystem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
@SuppressWarnings("serial")
public class Users implements Serializable {
	

	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	/*public List<CompanyReview> getCompanyReviews() {
		return companyReviews;
	}

	public void setCompanyReviews(List<CompanyReview> companyReviews) {
		this.companyReviews = companyReviews;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy = "users")
	private List<CompanyReview> companyReviews;*/
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
