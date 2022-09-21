/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.blogs.constant.AdminConstant;
import com.blogs.entity.Admin;
import com.blogs.model.ProkeSubscribeRequest;
import com.blogs.model.RequestModel;
import com.blogs.repository.AdminRepo;
import com.blogs.service.AdminService;
import com.blogs.utils.RestHttpClient;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepo adminRepo;
    
    @Autowired
    private RestHttpClient restHttpClient;

    @Value(value = "${message-broker.url}")
    private String messageBrokerUrl;

    @Override
    public List<Admin> findAll() {
	return (List<Admin>) adminRepo.findAll();
    }

    @Override
    public Admin findByUserId(Admin user) {
	return adminRepo.findById(user.getAdminId()).orElse(null);
    }

    @Override
    public void saveUser(Admin user) {
	adminRepo.save(user);

	/*
	 * ProkeSubscribe
	 */
	Admin target = new Admin();
	BeanUtils.copyProperties(user, target);
	try {
	    RequestModel<ProkeSubscribeRequest> requestBroker = new RequestModel<ProkeSubscribeRequest>();
	    ProkeSubscribeRequest criteria = new ProkeSubscribeRequest();
	    Map<String, Object> message = new HashMap<String, Object>();
	    message.put("event", AdminConstant.createAdmin);// create-admin
	    message.put("data", target);
	    criteria.setMainServiceName(AdminConstant.mainAdminService);
	    criteria.setMessage(message);
	    requestBroker.setCriteria(criteria);
	    restHttpClient.httpPost(messageBrokerUrl, requestBroker, new ParameterizedTypeReference<String>() {
	    });
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Admin findByUsername(String username) {
	return adminRepo.findOneByUsername(username);
    }

}
