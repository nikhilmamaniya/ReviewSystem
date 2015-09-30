/**
 * 
 */
package com.reviewSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rushabh Soni
 *
 */
@Entity
@Table(name = "PEER")
public class Peer {
	@Id
	@Column(name = "PEER_ID")
	private String peerId;
	@Column(name = "PEER_NAME")
	private String name;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	public String getId() {
		return peerId;
	}
	public void setId(String id) {
		this.peerId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
