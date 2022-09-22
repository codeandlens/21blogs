package com.blogs.service;

import java.util.List;

import com.blogs.entity.CustomerDetail;
import com.blogs.model.CustomerDetailModel;
import com.blogs.model.CustomerSearchRequestModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;

public interface CustomerService {

    public CustomerDetail saveCustomer(CustomerDetail entity);

    public CustomerDetail getCustomerById(Integer id);

    public void deleteCustomerById(Integer id);

    public ResponseModel<List<CustomerDetailModel>> searchCustomer(RequestModel<CustomerSearchRequestModel> param);

}
