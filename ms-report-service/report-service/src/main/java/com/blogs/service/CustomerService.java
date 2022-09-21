/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.service;

import com.blogs.entity.CustomerDetail;

public interface CustomerService {
    
    public CustomerDetail getLastestCustomer();
    public void saveCustomer(CustomerDetail data);
    public CustomerDetail getCustomerDetailByCitizenId(String citizenId);


}
