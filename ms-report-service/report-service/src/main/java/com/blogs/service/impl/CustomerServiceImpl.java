/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entity.CustomerDetail;
import com.blogs.repository.CustomerDetailRepo;
import com.blogs.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerDetailRepo custRepo;
    
    
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
    

}
