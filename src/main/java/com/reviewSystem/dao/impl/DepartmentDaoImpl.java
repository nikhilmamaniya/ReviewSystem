/**
 * 
 */
package com.reviewSystem.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewSystem.dao.DepartmentDao;
import com.reviewSystem.model.Company;
import com.reviewSystem.model.Department;


/**
 * @author Rushabh Soni
 *
 */
@Repository("DepartmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public DepartmentDaoImpl() {
		super();
	}
	public DepartmentDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/* (non-Javadoc)
	 * @see com.reviewSystem.dao.DepartmentDao#getDepartment(int)
	 */
	@Override
	public Department getDepartment(int departmentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Department c where c.departmentId = :departmentId";
		Query query = currentSession.createQuery(queryString );
		query.setInteger("departmentId", departmentId);
		Department department = (Department) query.list().get(0);
		return department;
	}

}
