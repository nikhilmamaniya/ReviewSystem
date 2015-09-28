package com.reviewSystem.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewSystem.dao.CompanyDao;
import com.reviewSystem.model.Company;

@Repository("CompanyDao")
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Company getCompany(int companyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Company c where c.companyId = :companyId";
		Query query = currentSession.createQuery(queryString );
		query.setInteger("companyId", companyId);
		Company company = (Company) query.list().get(0);
		return company;
	}

	public CompanyDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CompanyDaoImpl() {
		super();
	}

}
