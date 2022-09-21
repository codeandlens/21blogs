/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entity.Admin;
import com.blogs.entity.CustomerDetail;
import com.blogs.repository.AdminRepo;
import com.blogs.repository.CustomerDeatilRepo;
import com.blogs.service.AuthenService;

@Service
public class AuthenServiceImpl implements AuthenService {
    
    @Autowired
    private CustomerDeatilRepo custRepo;

    @Autowired
    private AdminRepo adminRepo;
    
    @Override
    public CustomerDetail getLastestCustomer() {
	return custRepo.getLastest();
    }
    
    public void saveCustomer(CustomerDetail data) {
	custRepo.save(data);
    }

    @Override
    public CustomerDetail getCustomerDetailByCitizenId(String citizenId) {
	return custRepo.getCustomerDetailByCitizenId(citizenId);
    }

    @Override
    public void saveUser(Admin user) {
	adminRepo.save(user);
    }

    @Override
    public Admin getUserByUsername(String username) {
	return adminRepo.findByUsername(username);
    }

}
