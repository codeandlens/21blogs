/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.service;

import java.util.List;

import com.blogs.entity.Admin;

public interface AdminService {
	
	public List<Admin> findAll();
	public Admin findByUserId(Admin user);
	public void saveUser(Admin user);
	
	public Admin findByUsername(String username);

}
