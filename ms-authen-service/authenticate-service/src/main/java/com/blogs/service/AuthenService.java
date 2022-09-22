/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.service;

import com.blogs.entity.Admin;
import com.blogs.entity.CustomerDetail;

public interface AuthenService {
    
    public CustomerDetail getLastestCustomer();
    public void saveCustomer(CustomerDetail data);
    public CustomerDetail findCustomerDetailByUsername(String username);
    
    public void saveUser(Admin user);
    public Admin getUserByUsername(String username);

}
