/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.bao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.blogs.constant.MessageConstant;
import com.blogs.entity.Admin;
import com.blogs.model.CreateAdminListRequestModel;
import com.blogs.model.CreateAdminRequestModel;
import com.blogs.model.CreateAdminResponseModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.service.AdminService;
import com.blogs.utils.PassBasedEnc;

@Component
public class AdminBAO {

    @Autowired
    private AdminService adminService;

    @Value(value = "${message-broker.url}")
    private String messageBrokerUrl;

    @Value(value = "${jwt.secret}")
    private String jwtSecret;

    public ResponseModel<List<Admin>> getAdminAll() {
	ResponseModel<List<Admin>> response = new ResponseModel<List<Admin>>();
	List<Admin> userList = new ArrayList<Admin>();
	try {
	    userList = adminService.findAll();
	    response.setCode(MessageConstant.S200);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.S200_DES, MessageConstant.SUCC_QUERY));
	    response.setData(userList);
	    return response;
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_DES, MessageConstant.ERROR_QUERY));
	    return response;
	}
    }

    public ResponseModel<CreateAdminResponseModel> createAdmin(RequestModel<CreateAdminRequestModel> request) {

	ResponseModel<CreateAdminResponseModel> response = new ResponseModel<CreateAdminResponseModel>();
	try {

	    if (request == null || request.getCriteria() == null
		    || StringUtils.isAllBlank(request.getCriteria().getUsername())
		    || StringUtils.isAllBlank(request.getCriteria().getPassword())
		    || StringUtils.isAllBlank(request.getCriteria().getRoleName())
		    || StringUtils.isAllBlank(request.getCriteria().getFullName())) {
		response.setCode(MessageConstant.E400_P_01);
		response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_01_DESC, MessageConstant.ERROR_QUERY));
		return response;
	    }
	    
	    Admin userDb = adminService.findByUsername(request.getCriteria().getUsername());
	    if(userDb == null) {
    	    	Admin user = new Admin();
    	    	String encryptedpassword = PassBasedEnc.generateSecurePassword(request.getCriteria().getPassword(),jwtSecret);
    	    	user.setPassword(encryptedpassword);
    	    	user.setRoleName(request.getCriteria().getRoleName());
    	    	user.setUsername(request.getCriteria().getUsername());
    	    	user.setFullName(request.getCriteria().getFullName());
    	    	user.setFullNameEn(request.getCriteria().getFullNameEn());
    	    	adminService.saveUser(user);
	    } else {
		String encryptedpassword = PassBasedEnc.generateSecurePassword(request.getCriteria().getPassword(),jwtSecret);
		userDb.setPassword(encryptedpassword);
		userDb.setRoleName(request.getCriteria().getRoleName());
		userDb.setUsername(request.getCriteria().getUsername());
    	    	userDb.setFullName(request.getCriteria().getFullName());
    	    	userDb.setFullNameEn(request.getCriteria().getFullNameEn());
		adminService.saveUser(userDb);
	    }

	    response.setCode(MessageConstant.S200);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.S200_DES, MessageConstant.SUCC_QUERY));
	    return response;

	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_DES, MessageConstant.ERROR_QUERY));
	    return response;
	}

    }

    public ResponseModel<CreateAdminResponseModel> createAdminList(RequestModel<CreateAdminListRequestModel> request) {

	ResponseModel<CreateAdminResponseModel> response = new ResponseModel<CreateAdminResponseModel>();
	
	try {
	    
	    if (request == null || request.getCriteria() == null) {
		response.setCode(MessageConstant.E400_P_01);
		response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_01_DESC, MessageConstant.ERROR_QUERY));
		return response;
	    }

	    for (CreateAdminRequestModel userModel : request.getCriteria().getAdminList()) {
		Admin userDb = adminService.findByUsername(userModel.getUsername());
		    if(userDb == null) {
	    	    	Admin user = new Admin();
	    	    	String encryptedpassword = PassBasedEnc.generateSecurePassword(userModel.getPassword(),jwtSecret);
	    	    	user.setPassword(encryptedpassword);
			user.setRoleName(userModel.getRoleName());
			user.setUsername(userModel.getUsername());
			user.setFullName(userModel.getFullName());
			user.setFullNameEn(userModel.getFullNameEn());
	    	    	adminService.saveUser(user);
		    } else {
			String encryptedpassword = PassBasedEnc.generateSecurePassword(userDb.getPassword(),jwtSecret);
			userDb.setPassword(encryptedpassword);
			userDb.setPassword(encryptedpassword);
			userDb.setRoleName(userModel.getRoleName());
			userDb.setUsername(userModel.getUsername());
			userDb.setFullName(userModel.getFullName());
			userDb.setFullNameEn(userModel.getFullNameEn());
			adminService.saveUser(userDb);
		    }
		
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	response.setCode(MessageConstant.S200);
	response.setDesc(MessageConstant.getDescription(MessageConstant.S200_DES, MessageConstant.SUCC_QUERY));
	return response;

    }

}
