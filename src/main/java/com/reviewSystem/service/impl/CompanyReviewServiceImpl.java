/**
 * 
 */
package com.reviewSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.CompanyReviewDao;
import com.reviewSystem.model.CompanyReview;
import com.reviewSystem.model.Users;
import com.reviewSystem.service.CompanyReviewService;

/**
 * @author Rushabh Soni
 *
 */
@Service("CompanyReviewService")
@Transactional
public class CompanyReviewServiceImpl implements CompanyReviewService {

	@Autowired
	CompanyReviewDao companyReviewDao;
	
	public void setCompanyReviewDao(CompanyReviewDao companyReviewDao) {
		this.companyReviewDao = companyReviewDao;
	}
	
	public CompanyReviewServiceImpl() {
		super();
	}

	public CompanyReviewServiceImpl(CompanyReviewDao companyReviewDao) {
		super();
		this.companyReviewDao = companyReviewDao;
	}

	/* (non-Javadoc)
	 * @see com.reviewSystem.service.CompanyReviewService#postCompanyReview(int, int, com.reviewSystem.model.CompanyReview)
	 */
	@Override
	public int postCompanyReview(Users user, CompanyReview companyReview) {
		//companyReview.setUser(user);
		int companyReviewId = companyReviewDao.postCompanyReview(companyReview);
		return companyReviewId;
	}

	@Override
	public List<CompanyReview> getAllReviews(int companyId) {
		
		return companyReviewDao.fetchAllReviews(companyId);
	}

	@Override
	public CompanyReview getCompanyReview(int companyReviewId) {
		return companyReviewDao.getCompanyReview(companyReviewId);
	}

	@Override
	public int updateCompanyReview(String username, int companyReviewId,
			CompanyReview companyReview) {
		Users user = companyReviewDao.getUser(companyReviewId);
		if(user.getUserName().equals(username)){
			//companyReview.setUser(user);
			return companyReviewDao.updateCompanyReview( companyReview);
		}
		return 0;
	}

	@Override
	public boolean deleteReview(String username, int companyReviewId) {
		companyReviewDao.deleteReview(username, companyReviewId);
		return true;
	}


}
