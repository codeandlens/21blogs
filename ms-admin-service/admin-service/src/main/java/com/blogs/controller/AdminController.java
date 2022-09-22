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

import com.blogs.bao.AdminBAO;
import com.blogs.entity.Admin;
import com.blogs.model.CreateAdminListRequestModel;
import com.blogs.model.CreateAdminRequestModel;
import com.blogs.model.CreateAdminResponseModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class AdminController {

    @Autowired
    private AdminBAO adminBAO;

    @PostMapping(value = "/getAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getAdmin", notes = "Get Admin")
    public ResponseModel<List<Admin>> getUser(@RequestBody Admin request) {
	return adminBAO.getAdminAll();
    }

    @PostMapping(value = "/createAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "createAdmin", notes = "Create Admin")
    public ResponseModel<CreateAdminResponseModel> createAdmin(@RequestBody RequestModel<CreateAdminRequestModel> request) {
	return adminBAO.createAdmin(request);
    }
    
    @PostMapping(value = "/createAdminList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "createAdminList", notes = "Create Admin List")
    public ResponseModel<CreateAdminResponseModel> createAdminList(@RequestBody RequestModel<CreateAdminListRequestModel> request) {
	return adminBAO.createAdminList(request);
    }
    

}
