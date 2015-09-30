/**
 * 
 */
package com.reviewSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rushabh Soni
 *
 */
@Entity
@Table(name="DEPARTMENT_REVIEW")
public class DepartmentReview {
	private int departmentReviewId;
	private Users user;
	private Department department;
	private String review;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="department_review_id")
	public int getDepartmentReviewId() {
		return departmentReviewId;
	}
	public void setDepartmentReviewId(int departmentReviewId) {
		this.departmentReviewId = departmentReviewId;
	}
	@ManyToOne
	@JoinColumn(name = "user_name")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Column(name="review")
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
}
