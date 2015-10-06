package com.reviewSystem.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewSystem.dao.CompanyReviewDao;
import com.reviewSystem.model.CompanyReview;

@Repository("CompanyReviewDao")
public class CompanyReviewDaoImpl implements CompanyReviewDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CompanyReviewDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public CompanyReviewDaoImpl() {
		super();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int postCompanyReview(CompanyReview companyReview) {
		Session currentSession = sessionFactory.getCurrentSession();
		companyReview.setCreatedDate(new Date());
		currentSession.save(companyReview);
		return companyReview.getCompanyReviewId();
	}

	@Override
	public List<CompanyReview> fetchAllReviews(int companyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query  query = currentSession.createQuery("from CompanyReview cr where cr.company.companyId = :companyId");
		query.setInteger("companyId", companyId);
		 List<CompanyReview> companyReviews = query.list();
		return companyReviews;
	}

	@Override
	public CompanyReview getCompanyReview(int companyReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query  query = currentSession.createQuery("from CompanyReview cr where cr.companyReviewId = :companyReviewId");
		query.setInteger("companyReviewId", companyReviewId);
		CompanyReview companyReview = (CompanyReview) query.list().get(0);
		return companyReview;
	}

	@Override
	public int updateCompanyReview(CompanyReview companyReview) {
			Session currentSession = sessionFactory.getCurrentSession();
			companyReview.setUpdatedDate(new Date());
			currentSession.update(companyReview);
		return companyReview.getCompanyReviewId();
	}
	
	@Override
	public boolean deleteReview(String username,  int companyReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CompanyReview companyReview = (CompanyReview) currentSession.load(CompanyReview.class, companyReviewId);
		currentSession.delete(companyReview);
		return true;
	}

/*	@Override
	public Users getUser(int companyReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from CompanyReview cr where cr.companyReviewId =:companyReviewId";
		Query query = currentSession.createQuery(queryString);
		query.setInteger("companyReviewId", companyReviewId);
		CompanyReview companyReview = (CompanyReview) query.list().get(0);
		return companyReview.getUser();
	}*/

}
