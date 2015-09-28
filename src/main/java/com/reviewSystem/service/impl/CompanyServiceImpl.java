package com.reviewSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewSystem.dao.CompanyDao;
import com.reviewSystem.model.Company;
import com.reviewSystem.service.CompanyService;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyDao companyDao;
	
	public CompanyServiceImpl(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}
	
	
	public CompanyServiceImpl() {
		super();
	}


	@Override
	public Company getCompany(int companyId) {
		Company company = companyDao.getCompany(companyId);
		return company;
	}

	

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

}
