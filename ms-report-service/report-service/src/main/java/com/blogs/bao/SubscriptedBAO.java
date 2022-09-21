/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.bao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.blogs.constant.AdminConstant;
import com.blogs.constant.MessageConstant;
import com.blogs.entity.CustomerDetail;
import com.blogs.entity.User;
import com.blogs.model.CheckingAndRetriveRequest;
import com.blogs.model.CustomerDetailModel;
import com.blogs.model.EventReceiverModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.model.RetriveDataResponse;
import com.blogs.service.CustomerService;
import com.blogs.service.ReportService;
//import com.blogs.service.SubscriptedService;
import com.blogs.utils.RestHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SubscriptedBAO {
    
    @Autowired
    private RestHttpClient restHttpClient;
    
    @Value(value = "${message-broker.url-retrive}")
    private String messageBrokerUrlRetrive;
    
    @Value(value = "${spring.service-name}")
    private String serviceName;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ReportService reportService;
    
//    @Autowired
//    private SubscriptedService subscriptedService;
    

    
    
    
    @SuppressWarnings("rawtypes")
    public ResponseModel receiveMessageFromBroker(EventReceiverModel request) {
	ResponseModel response = new ResponseModel();
	try {
	    if(AdminConstant.createAdmin.equals(request.getEvent())) {
		ObjectMapper mapper = new ObjectMapper();
		User eventData = mapper.convertValue(request.getData(), User.class);
		User target = new User();
		BeanUtils.copyProperties(eventData, target);
//		subscriptedService.saveUser(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
	    }
	    return response;
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_RPT_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_RPT_00_DESC, e.getMessage()));
	    return response;
	}
    }
    
    public void checkingDataCustomerSubscripted() {
	RequestModel<CheckingAndRetriveRequest> request = new RequestModel<CheckingAndRetriveRequest>();
	/* Start Retrieve Customer */
	try {
	    CustomerDetail lastCustomer = reportService.getLastestCustomer();
	    CheckingAndRetriveRequest criteria = new CheckingAndRetriveRequest();
	    if (lastCustomer != null && lastCustomer.getLastModifiedDate() != null) {
		criteria.setLastDataTimeStamp(lastCustomer.getLastModifiedDate().toString());
	    } else {
		criteria.setLastDataTimeStamp("1900-01-01 00:00:00.000");
	    }
	    criteria.setServiceName(serviceName);
	    request.setCriteria(criteria);
	    ResponseEntity<RetriveDataResponse> response = restHttpClient.httpPost(messageBrokerUrlRetrive, request,
		    new ParameterizedTypeReference<RetriveDataResponse>() {
		    });
	    response.getBody().getData();
	    @SuppressWarnings("unchecked")
	    List<Map<String, Object>> rawDatas = (List<Map<String, Object>>) response.getBody().getData();
	    for (Map<String, Object> raw : rawDatas) {
		ObjectMapper mapper = new ObjectMapper();
		RetriveDataResponse data = mapper.convertValue(raw, RetriveDataResponse.class);
		EventReceiverModel eventModel = mapper.convertValue(data, EventReceiverModel.class);
		receiveMessageFromBroker(eventModel);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	/* End Retrieve Customer */
    }

  
    public void checkingDataBookingSubscripted() {
	RequestModel<CheckingAndRetriveRequest> request = new RequestModel<CheckingAndRetriveRequest>();
	/* Start Retrieve Booking */
	try {
	    
//	    Booking lastBooking = subscriptedService.getLastestBooking();
	    
	    CheckingAndRetriveRequest criteria = new CheckingAndRetriveRequest();
//	    if (lastBooking != null && lastBooking.getLastModifiedDate() != null) {
//		criteria.setLastDataTimeStamp(lastBooking.getLastModifiedDate().toString());
//	    } else {
//		criteria.setLastDataTimeStamp("1900-01-01 00:00:00.000");
//	    }
	    criteria.setServiceName(serviceName);
	    request.setCriteria(criteria);
	    ResponseEntity<RetriveDataResponse> response = restHttpClient.httpPost(messageBrokerUrlRetrive, request,
		    new ParameterizedTypeReference<RetriveDataResponse>() {
		    });
	    response.getBody().getData();
	    @SuppressWarnings("unchecked")
	    List<Map<String, Object>> rawDatas = (List<Map<String, Object>>) response.getBody().getData();
	    for (Map<String, Object> raw : rawDatas) {
		ObjectMapper mapper = new ObjectMapper();
		RetriveDataResponse data = mapper.convertValue(raw, RetriveDataResponse.class);
		EventReceiverModel eventModel = mapper.convertValue(data, EventReceiverModel.class);
		receiveMessageFromBroker(eventModel);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	/* End Retrieve Booking */
	
    }




}
