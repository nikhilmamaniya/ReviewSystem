/**
 * 
 */
package com.reviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reviewSystem.model.Company;
import com.reviewSystem.model.Department;
import com.reviewSystem.model.DepartmentReview;
import com.reviewSystem.model.Users;
import com.reviewSystem.service.DepartmentReviewService;
import com.reviewSystem.service.DepartmentService;

/**
 * @author Rushabh Soni
 *
 */
@RestController
public class DepartmentReviewController {
	@Autowired
	DepartmentReviewService departmentReviewService;
	
	@Autowired
	DepartmentService departmentService;

	public void setDepartmentReviewService(
			DepartmentReviewService departmentReviewService) {
		this.departmentReviewService = departmentReviewService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public DepartmentReviewController() {
		super();
	}

	public DepartmentReviewController(
			DepartmentReviewService departmentReviewService,
			DepartmentService departmentService) {
		super();
		this.departmentReviewService = departmentReviewService;
		this.departmentService = departmentService;
	}
	
	@RequestMapping(value = "/review/postDepartmentReview/{departmentId}", method = RequestMethod.POST)
	public int postDepartmentReview(@PathVariable(value = "departmentId") String departmentId ,@RequestBody DepartmentReview departmentReview){
		Department department = departmentService.getDepartment(Integer.parseInt(departmentId));
		departmentReview.setDepartment(department);
		int departmentReviewId = departmentReviewService.postDepartmentReview(getUser(), departmentReview);
		return departmentReviewId;/*departmentReviewService.postNewReview();*/
	}

	@RequestMapping(value = "/review/getDepartmentReviews/{departmentId}", method = RequestMethod.GET)
	public List<DepartmentReview> getdepartmentReviews(@PathVariable(value = "departmentId") String departmentId){
		return departmentReviewService.getAllReviews(Integer.parseInt(departmentId));
	}
	
	@RequestMapping(value = "/review/getdepartmentReview/{departmentReviewId}",method = RequestMethod.GET)
	public DepartmentReview getdepartmentReview(@PathVariable(value = "departmentReviewId") String departmentReviewId){
		return departmentReviewService.getDepartmentReview(Integer.parseInt(departmentReviewId));
	}
	
	@RequestMapping(value = "/review/updatedepartmentReview",method = RequestMethod.PUT)
	public int updatedepartmentReview(@RequestBody DepartmentReview departmentReview){
		int departmentReviewId = departmentReview.getDepartmentReviewId();
		int userId = 11;
		return departmentReviewService.updateDepartmentReview(userId, departmentReviewId, departmentReview);		
	}
	
	@RequestMapping(value = "/review/deleteDepartmentReview/{departmentReviewId}", method = RequestMethod.DELETE)
	public boolean deletedepartmentReview(@PathVariable(value ="departmentReviewId") String departmentReviewId ){
		int userId = 10;
		return departmentReviewService.deleteReview(userId, Integer.parseInt(departmentReviewId));
		
	}
	
	private Users getUser() {
		Users u = new Users();
		u.setUserName("user10");
		u.setUserPassword("pass10");
		return u;
	}
}
