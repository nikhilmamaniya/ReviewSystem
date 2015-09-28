/**
 * 
 */
package com.reviewSystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewSystem.dao.DepartmentReviewDao;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.DepartmentReview;
import com.reviewSystem.model.Users;

/**
 * @author Rushabh Soni
 *
 */
@Repository("DepartmentReviewDao")
public class DepartmentReviewDaoImpl implements DepartmentReviewDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public DepartmentReviewDaoImpl() {
		super();
	}

	public DepartmentReviewDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentReviewDao#postDepartmentReview(com.reviewSystem.model.DepartmentReview)
	 */
	@Override
	public int postDepartmentReview(DepartmentReview departmentReview) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(departmentReview);
		return departmentReview.getDepartmentReviewId();
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentReviewDao#fetchAllReviews(int)
	 */
	@Override
	public List<DepartmentReview> fetchAllReviews(int departmentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query  query = currentSession.createQuery("from DepartmentReview dr where dr.department.departmentId = :departmentId");
		query.setInteger("departmentId", departmentId);
		 List<DepartmentReview> departmentReviews = query.list();
		return departmentReviews;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentReviewDao#getDepartmentReview(int)
	 */
	@Override
	public DepartmentReview getDepartmentReview(int departmentReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query  query = currentSession.createQuery("from DepartmentReview cr where cr.departmentReviewId = :departmentReviewId");
		query.setInteger("departmentReviewId", departmentReviewId);
		DepartmentReview departmentReview = (DepartmentReview) query.list().get(0);
		return departmentReview;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentReviewDao#updateDepartmentReview(com.reviewSystem.model.DepartmentReview)
	 */
	@Override
	public int updateDepartmentReview(DepartmentReview departmentReview) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(departmentReview);
		return departmentReview.getDepartmentReviewId();
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentReviewDao#deleteReview(int, int)
	 */
	@Override
	public boolean deleteReview(int userId, int departmentReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		DepartmentReview departmentReview = (DepartmentReview) currentSession.load(DepartmentReview.class, departmentReviewId);
		currentSession.delete(departmentReview);
		return true;
	}
	
	@Override
	public Users getUser(int departmentReviewId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from DepartmentReview cr where cr.departmentReviewId =:departmentReviewId";
		Query query = currentSession.createQuery(queryString);
		query.setInteger("departmentReviewId", departmentReviewId);
		DepartmentReview departmentReview = (DepartmentReview) query.list().get(0);
		return departmentReview.getUser();
	}

}
