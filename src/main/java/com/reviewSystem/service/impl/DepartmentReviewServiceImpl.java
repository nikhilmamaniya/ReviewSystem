/**
 * 
 */
package com.reviewSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.CompanyReviewDao;
import com.reviewSystem.dao.DepartmentReviewDao;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.DepartmentReview;
import com.reviewSystem.model.Users;
import com.reviewSystem.service.DepartmentReviewService;

/**
 * @author Rushabh Soni
 *
 */
@Service("DepartmentReviewService")
@Transactional
public class DepartmentReviewServiceImpl implements DepartmentReviewService {

	public DepartmentReviewServiceImpl() {
		super();
	}
	public DepartmentReviewServiceImpl(DepartmentReviewDao departmentReviewDao) {
		super();
		this.departmentReviewDao = departmentReviewDao;
	}

	@Autowired
	DepartmentReviewDao departmentReviewDao;
	
	public void setDepartmentReviewDao(DepartmentReviewDao departmentReviewDao) {
		this.departmentReviewDao = departmentReviewDao;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentReviewService#postDepartmentReview(com.reviewSystem.model.Users, com.reviewSystem.model.DepartmentReview)
	 */
	@Override
	public int postDepartmentReview(Users user,
			DepartmentReview departmentReview) {
		departmentReview.setUser(user);
		return departmentReviewDao.postDepartmentReview(departmentReview);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentReviewService#getAllReviews(int)
	 */
	@Override
	public List<DepartmentReview> getAllReviews(int departmentId) {
		return departmentReviewDao.fetchAllReviews(departmentId);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentReviewService#getDepartmentReview(int)
	 */
	@Override
	public DepartmentReview getDepartmentReview(int departmentReviewId) {
		return departmentReviewDao.getDepartmentReview(departmentReviewId);
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentReviewService#updateDepartmentReview(int, int, com.reviewSystem.model.DepartmentReview)
	 */
	@Override
	public int updateDepartmentReview(int userId, int departmentReviewId,
			DepartmentReview departmentReview) {
		Users user = departmentReviewDao.getUser(departmentReviewId);
		if(user.getId() == userId){
			departmentReview.setUser(user);
			return departmentReviewDao.updateDepartmentReview( departmentReview);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.DepartmentReviewService#deleteReview(int, int)
	 */
	@Override
	public boolean deleteReview(int userId, int departmentReviewId) {
		return departmentReviewDao.deleteReview(userId, departmentReviewId);
	}

}
