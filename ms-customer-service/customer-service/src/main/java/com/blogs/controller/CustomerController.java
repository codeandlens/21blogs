/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.bao.CustomerBAO;
import com.blogs.model.CustomerDetailModel;
import com.blogs.model.CustomerSearchRequestModel;
//import com.blogs.model.FaceBookCallbackRequestModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
//import com.blogs.model.SendMessageFbToCustomerModel;
//import com.blogs.model.SendMessageLineToCustomerModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class CustomerController {

    @Autowired
    private CustomerBAO customerBao;

    @PostMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Customer By ID", notes = "id require")
    public ResponseModel<CustomerDetailModel> getCustomer(@RequestBody RequestModel<CustomerDetailModel> request) {
	return customerBao.getCustomerById(request);
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Customer", notes = "search criteria require")
    public ResponseModel<List<CustomerDetailModel>> searchCustomer(@RequestBody RequestModel<CustomerSearchRequestModel> request) {
	return customerBao.searchCustomer(request);
    }

    @PostMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete By Id", notes = "id require")
    public ResponseModel<CustomerDetailModel> delete(@RequestBody RequestModel<CustomerDetailModel> request) {
	return customerBao.deleteCustomerById(request);
    }

    @PostMapping(value = "/createCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Customer", notes = "")
    public ResponseModel<CustomerDetailModel> create(@RequestBody RequestModel<CustomerDetailModel> request) {
	return customerBao.createCustomer(request);
    }
    
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Customer", notes = "")
    public ResponseModel<CustomerDetailModel> update(@RequestBody RequestModel<CustomerDetailModel> request) {
	return customerBao.updateCustomer(request);
    }
    
  
}
