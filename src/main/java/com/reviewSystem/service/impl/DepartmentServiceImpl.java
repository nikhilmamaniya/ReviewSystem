/**
 * 
 */
package com.reviewSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.DepartmentDao;
import com.reviewSystem.dao.DepartmentReviewDao;
import com.reviewSystem.model.Department;
import com.reviewSystem.service.DepartmentService;

/**
 * @author Rushabh Soni
 *
 */
@Service("DepartmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	public DepartmentServiceImpl() {
		super();
	}
	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentService#getDepartment(int)
	 */
	@Override
	public Department getDepartment(int departmentId) {
		Department department = departmentDao.getDepartment(departmentId);
		return department;
	}
	

}
