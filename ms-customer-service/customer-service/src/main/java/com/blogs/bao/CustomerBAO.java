/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.bao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.blogs.constant.MessageConstant;
import com.blogs.entity.Address;
import com.blogs.entity.CustomerDetail;
import com.blogs.model.AddressModel;
import com.blogs.model.CustomerDetailModel;
import com.blogs.model.CustomerSearchRequestModel;
import com.blogs.model.ProkeSubscribeRequest;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.service.AddressService;
import com.blogs.service.CustomerService;
import com.blogs.utils.RestHttpClient;

@Component
public class CustomerBAO {

    @Autowired
    private CustomerService service;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RestHttpClient restHttpClient;

    @Value(value = "${message-broker.url}")
    private String messageBrokerUrl;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ResponseModel<List<CustomerDetailModel>> searchCustomer(RequestModel<CustomerSearchRequestModel> request) {
	ResponseModel<List<CustomerDetailModel>> response = new ResponseModel<List<CustomerDetailModel>>();
	try {
	    if (request == null || request.getPage() == null || request.getSize() == null
		    || request.getCriteria() == null) {
		response.setCode(MessageConstant.E400_P_CUS_01);
		response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		return response;
	    } else {
		response = service.searchCustomer(request);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
		return response;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, e.getMessage()));
	    return response;
	}
    }

    public ResponseModel<CustomerDetailModel> getCustomerById(RequestModel<CustomerDetailModel> request) {
	ResponseModel<CustomerDetailModel> response = new ResponseModel<CustomerDetailModel>();
	try {
	    if (request == null || request.getCriteria() == null || request.getCriteria().getId() == null) {
		response.setCode(MessageConstant.E400_P_CUS_01);
		response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		return response;
	    } else {
		CustomerDetail serviceResult = service.getCustomerById(request.getCriteria().getId());
		if (serviceResult != null) {
		    Address addressResult = addressService.getAddressByCustomerId(request.getCriteria().getId());
		    AddressModel address = new AddressModel();
		    if (addressResult != null) {
			BeanUtils.copyProperties(addressResult, address);
		    }
		    CustomerDetailModel target = new CustomerDetailModel();
		    BeanUtils.copyProperties(serviceResult, target);
		    target.setAddress(address);
		    response.setData(target);
		}
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
		return response;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, e.getMessage()));
	    return response;
	}
    }

    @Transactional
    public ResponseModel<CustomerDetailModel> createCustomer(RequestModel<CustomerDetailModel> request) {
	ResponseModel<CustomerDetailModel> response = new ResponseModel<CustomerDetailModel>();
	try {
	    if (request == null || request.getCriteria() == null) {
		response.setCode(MessageConstant.E400_P_CUS_01);
		response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		return response;
	    } else {
		CustomerDetail entity = new CustomerDetail();
		BeanUtils.copyProperties(request.getCriteria(), entity);
		entity.setId(null);
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String currentDateStr = dateFormat.format(date); 
		
		if (StringUtils.isNotBlank(entity.getPhoto())) {
		    String base64PhotoImage = entity.getPhoto();
		    base64PhotoImage = base64PhotoImage.replace("data:image/gif;base64,", "")
			    .replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", "")
			    .replace("data:image/jpg;base64,", "");
		    entity.setPhoto(base64PhotoImage);
		}
		entity.setLatestInviteDate(currentDateStr);
		entity.setRegisterDate(currentDateStr);
		
		CustomerDetail serviceResult = new CustomerDetail();
		try {
		    serviceResult = service.saveCustomer(entity);
		} catch (DataIntegrityViolationException e) {
		    response.setCode(MessageConstant.E500_S_CUS_01);
		    response.setDesc(MessageConstant.E500_S_CUS_01_DESC);
		    return response;
		}
		CustomerDetailModel target = new CustomerDetailModel();
		BeanUtils.copyProperties(serviceResult, target);
		if (request.getCriteria().getAddress() != null) {
		    Address addressEntity = new Address();
		    BeanUtils.copyProperties(request.getCriteria().getAddress(), addressEntity);
		    addressEntity.setCustomerId(serviceResult.getId());
		    Address addressResult = addressService.saveAddress(addressEntity);
		    AddressModel addressTarget = new AddressModel();
		    BeanUtils.copyProperties(addressResult, addressTarget);
		    target.setAddress(addressTarget);
		}
		response.setData(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
		try {
		    RequestModel<ProkeSubscribeRequest> requestBroker = new RequestModel<ProkeSubscribeRequest>();
		    ProkeSubscribeRequest criteria = new ProkeSubscribeRequest();
		    Map<String, Object> message = new HashMap<String, Object>();
		    message.put("event", "create-customer");// create-customer //update-customer
		    target.setAddress(null);
		    message.put("data", target);
		    criteria.setMainServiceName("customer-service");
		    criteria.setMessage(message);
		    requestBroker.setCriteria(criteria);
		    restHttpClient.httpPost(messageBrokerUrl, requestBroker, new ParameterizedTypeReference<String>() {
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return response;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, e.getMessage()));
	    return response;
	}
    }

    public ResponseModel<CustomerDetailModel> updateCustomer(RequestModel<CustomerDetailModel> request) {
	ResponseModel<CustomerDetailModel> response = new ResponseModel<CustomerDetailModel>();
	try {
	    if (request == null || request.getCriteria() == null || request.getCriteria().getId() == null) {
		response.setCode(MessageConstant.E400_P_CUS_01);
		response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		return response;
	    } else {
		CustomerDetail checkCustomer = service.getCustomerById(request.getCriteria().getId());
		if (checkCustomer == null) {
		    response.setCode(MessageConstant.E400_P_CUS_01);
		    response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		    return response;
		}

		CustomerDetail entity = new CustomerDetail();
		BeanUtils.copyProperties(request.getCriteria(), entity);
		entity.setRegisterDate(checkCustomer.getRegisterDate());
		entity.setLatestInviteDate(checkCustomer.getLatestInviteDate());
		entity.setLastModifiedDate(new Date());
		if (StringUtils.isNotBlank(entity.getPhoto())) {
		    String base64PhotoImage = entity.getPhoto();
		    base64PhotoImage = base64PhotoImage.replace("data:image/gif;base64,", "")
			    .replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", "")
			    .replace("data:image/jpg;base64,", "");
		    entity.setPhoto(base64PhotoImage);
		}
		CustomerDetail serviceResult = new CustomerDetail();
		try {
		    serviceResult = service.saveCustomer(entity);
		} catch (DataIntegrityViolationException e) {
		    response.setCode(MessageConstant.E500_S_CUS_01);
		    response.setDesc(MessageConstant.E500_S_CUS_01_DESC);
		    return response;
		}
		CustomerDetailModel target = new CustomerDetailModel();
		BeanUtils.copyProperties(serviceResult, target);
		if (request.getCriteria().getAddress() != null) {
		    addressService.deleteAddressByCustomerId(serviceResult.getId());
		    Address addressEntity = new Address();
		    BeanUtils.copyProperties(request.getCriteria().getAddress(), addressEntity);
		    addressEntity.setCustomerId(serviceResult.getId());
		    Address addressResult = addressService.saveAddress(addressEntity);
		    AddressModel addressTarget = new AddressModel();
		    BeanUtils.copyProperties(addressResult, addressTarget);
		    target.setAddress(addressTarget);
		}
		response.setData(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
		try {
		    RequestModel<ProkeSubscribeRequest> requestBroker = new RequestModel<ProkeSubscribeRequest>();
		    ProkeSubscribeRequest criteria = new ProkeSubscribeRequest();
		    Map<String, Object> message = new HashMap<String, Object>();
		    message.put("event", "update-customer");// create-customer //update-customer
		    target.setAddress(null);
		    message.put("data", target);
		    criteria.setMainServiceName("customer-service");
		    criteria.setMessage(message);
		    requestBroker.setCriteria(criteria);
		    restHttpClient.httpPost(messageBrokerUrl, requestBroker, new ParameterizedTypeReference<String>() {
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return response;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, e.getMessage()));
	    return response;
	}
    }

    public ResponseModel<CustomerDetailModel> deleteCustomerById(RequestModel<CustomerDetailModel> request) {
	ResponseModel<CustomerDetailModel> response = new ResponseModel<CustomerDetailModel>();
	try {
	    if (request == null || request.getCriteria() == null || request.getCriteria().getId() == null) {
		response.setCode(MessageConstant.E400_P_CUS_01);
		response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		return response;
	    } else {
		CustomerDetail serviceResult = service.getCustomerById(request.getCriteria().getId());
		if (serviceResult != null) {
		    service.deleteCustomerById(request.getCriteria().getId());
		    addressService.deleteAddressByCustomerId(request.getCriteria().getId());
		    response.setCode(MessageConstant.S200);
		    response.setDesc(MessageConstant.S200_DES);
		} else {
		    response.setCode(MessageConstant.E400_P_CUS_01);
		    response.setDesc(MessageConstant.E400_P_CUS_01_DES);
		}
		return response;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, e.getMessage()));
	    return response;
	}
    }


}
