/**
 * 
 */
package com.reviewSystem.dao;

import org.springframework.stereotype.Repository;

import com.reviewSystem.model.Company;

/**
 * @author Rushabh Soni
 *
 */
@Repository
public interface CompanyDao {
	public Company getCompany(int companyId);
}
