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
	public CompanyReview postCompanyReview(Users user, CompanyReview companyReview) {
		//companyReview.setUser(user);
		
		return companyReviewDao.postCompanyReview(companyReview);
	}

	@Override
	public List<CompanyReview> getAllReviews(int companyId) {
		
		return companyReviewDao.fetchAllReviews(companyId);
	}

	@Override
	public CompanyReview getCompanyReview(String companyReviewId) {
		return companyReviewDao.getCompanyReview(companyReviewId);
	}

	@Override
	public CompanyReview updateCompanyReview(String username, String companyReviewId,
			CompanyReview companyReview) {
	
			return companyReviewDao.updateCompanyReview( companyReview);
		
	}

	@Override
	public boolean deleteReview(String username, String companyReviewId) {
		companyReviewDao.deleteReview(username, companyReviewId);
		return true;
	}


}
