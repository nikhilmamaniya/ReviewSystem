package com.reviewSystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="company_review")
@PrimaryKeyJoinColumn(name = "review_id")
public class CompanyReview extends Review{
	
	private Company company;
	private List<QuestionAnswer> questionAnswers;
	
	@OneToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "review_id")
	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}
	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
