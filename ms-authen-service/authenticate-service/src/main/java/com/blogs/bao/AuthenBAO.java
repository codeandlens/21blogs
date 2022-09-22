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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.blogs.constant.AdminConstant;
import com.blogs.constant.AuthenConstant;
import com.blogs.constant.FavoritCustomerConstant;
import com.blogs.constant.MessageConstant;
import com.blogs.entity.Admin;
import com.blogs.entity.CustomerDetail;
import com.blogs.model.CheckingAndRetriveRequest;
import com.blogs.model.EventReceiverModel;
import com.blogs.model.GenerateTokenRequestModel;
import com.blogs.model.GenerateTokenResponseModel;
import com.blogs.model.JwtTokenModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.model.RetriveDataResponse;
import com.blogs.service.AuthenService;
import com.blogs.utils.PassBasedEnc;
import com.blogs.utils.RestHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class AuthenBAO {
    
    @Autowired
    private RestHttpClient restHttpClient;
    
    @Value(value = "${spring.service-name}")
    private String serviceName;
	
    @Value(value = "${message-broker.url-retrive}")
    private String messageBrokerUrlRetrive;
    
      
    @Value(value = "${jwt.secret}")
    private String jwtSecret;
    
    
    @Autowired
    private AuthenService authenService;

    public void checkingDataSubscripted() {
	RequestModel<CheckingAndRetriveRequest> request = new RequestModel<CheckingAndRetriveRequest>();
	CustomerDetail lastCustomer = authenService.getLastestCustomer();
	CheckingAndRetriveRequest criteria = new CheckingAndRetriveRequest();
	if (lastCustomer != null && lastCustomer.getLastModifiedDate() != null) {
	    criteria.setLastDataTimeStamp(lastCustomer.getLastModifiedDate().toString());
	} else {
	    criteria.setLastDataTimeStamp("1900-01-01 00:00:00.000");
	}
	criteria.setServiceName(serviceName);
	request.setCriteria(criteria);
	try {
	    ResponseEntity<RetriveDataResponse> response = restHttpClient.httpPost(messageBrokerUrlRetrive, request,
		    new ParameterizedTypeReference<RetriveDataResponse>() {
		    });
	    response.getBody().getData();
	    
	    System.out.println("########################### SET DATA CUSTOMER ###########################");
	    
	    @SuppressWarnings("unchecked")
	    List<Map<String, Object>> rawDatas = (List<Map<String, Object>>) response.getBody().getData();
	    for (Map<String, Object> raw : rawDatas) {
		ObjectMapper mapper = new ObjectMapper();
		RetriveDataResponse data = mapper.convertValue(raw, RetriveDataResponse.class);
		EventReceiverModel eventModel = mapper.convertValue(data, EventReceiverModel.class);
		receiveMessageFromBroker(eventModel);
	    }
	    System.out.println("LastStep");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @SuppressWarnings("rawtypes")
    public ResponseModel receiveMessageFromBroker(EventReceiverModel request) {
	ResponseModel response = new ResponseModel();
	try {
	    Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDateStr = dateFormat.format(date); 
	    if (FavoritCustomerConstant.createCustomer.equals(request.getEvent())) {
		ObjectMapper mapper = new ObjectMapper();
		CustomerDetail eventData = mapper.convertValue(request.getData(), CustomerDetail.class);
		CustomerDetail target = new CustomerDetail();
		BeanUtils.copyProperties(eventData, target);
		authenService.saveCustomer(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
	    } else if (FavoritCustomerConstant.updateCustomer.equals(request.getEvent())) {
		ObjectMapper mapper = new ObjectMapper();
		CustomerDetail eventData = mapper.convertValue(request.getData(), CustomerDetail.class);
		CustomerDetail target = new CustomerDetail();
		BeanUtils.copyProperties(eventData, target);
		target.setRegisterDate(currentDateStr);
		authenService.saveCustomer(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
	    } else if(AdminConstant.createAdmin.equals(request.getEvent())) {
		ObjectMapper mapper = new ObjectMapper();
		Admin eventData = mapper.convertValue(request.getData(), Admin.class);
		Admin target = new Admin();
		BeanUtils.copyProperties(eventData, target);
		authenService.saveUser(target);
		response.setCode(MessageConstant.S200);
		response.setDesc(MessageConstant.S200_DES);
	    }
	    
	    
	    return response;
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_S_CUS_01);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_S_CUS_01_DESC, MessageConstant.ERROR_QUERY));
	    return response;
	}
    }

    public ResponseModel<GenerateTokenResponseModel> generateToken(RequestModel<GenerateTokenRequestModel> request) {
	
	ResponseModel<GenerateTokenResponseModel> response = new ResponseModel<GenerateTokenResponseModel>();
	
	if (request == null || request.getCriteria() == null || request.getCriteria().getPassword() == null 
		|| StringUtils.isAllBlank(request.getCriteria().getUsername()) 
		|| StringUtils.isAllBlank(request.getCriteria().getPassword())) {
	    response.setCode(MessageConstant.E400_P_AUTHEN_01);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_AUTHEN_01_DESC, MessageConstant.ERROR_QUERY));
	    return response;
	}
	
	try {
	    GenerateTokenResponseModel model = new GenerateTokenResponseModel();
	    String authenToken = "";
	    JwtTokenModel token = new JwtTokenModel();
	    String username = request.getCriteria().getUsername(); 
	    CustomerDetail customer = authenService.findCustomerDetailByUsername(username);
	    if(customer != null) {
        	   
		boolean checkPassword = PassBasedEnc.verifyUserPassword(request.getCriteria().getPassword(), customer.getPassword(), jwtSecret);
		if(checkPassword) {
                	    token.setUserId(customer.getId().toString());
                	    token.setRole(AuthenConstant.ROLE_CUSTOMER);
                	    token.setName(customer.getFirstName()+" "+customer.getLastName());
                	    token.setUsername(customer.getUsername());
                	    authenToken = gentoken(token);
                	    model.setAuthenToken(authenToken);
        	    } else {
        		 response.setCode(MessageConstant.E400_P_AUTHEN_01);
        		 response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_AUTHEN_01_DESC, MessageConstant.ERROR_QUERY));
        		 return response;
        	    }
	    } else {
		
		Admin admin = authenService.getUserByUsername(request.getCriteria().getUsername());
		if(admin == null) {
		    response.setCode(MessageConstant.E400_P_AUTHEN_02);
		    response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_AUTHEN_02_DESC, MessageConstant.SUCC_QUERY));
		    return response;
		}
		Boolean matched = PassBasedEnc.verifyUserPassword(request.getCriteria().getPassword(), admin.getPassword(), jwtSecret); 
		if(matched) {
    			token.setUserId(admin.getAdminId().toString());
        	    	token.setRole(admin.getRoleName());
        	    	token.setName(admin.getFullName());
        	    	token.setUsername(admin.getFullName());
        	    	authenToken = gentoken(token);
        	    	model.setAuthenToken(authenToken);
		} else {
		    response.setCode(MessageConstant.E400_P_AUTHEN_01);
		    response.setDesc(MessageConstant.getDescription(MessageConstant.E400_P_AUTHEN_01_DESC, MessageConstant.SUCC_QUERY));
		    return response;
		}
	    }
	    response.setData(model);
	    response.setCode(MessageConstant.S200);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.S200_DES, MessageConstant.SUCC_QUERY));
	    return response;
	} catch (Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_CUS_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_CUS_00_DESC, MessageConstant.ERROR_QUERY));
	    return response;
	}
    }

    private String gentoken(JwtTokenModel tokens) {

	        Date now = new Date();
	        //Date exp = new Date(System.currentTimeMillis() + (1000*300)); // 300 seconds
	       
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("name", tokens.getName());
	        claims.put("userId", tokens.getUserId());
	        claims.put("role", tokens.getRole());
	        claims.put("username", tokens.getUsername());
	        
	        //String token = jwtTokenUtil.doGenerateToken(claims, tokens.getName());
	        String token = Jwts.builder()
		    .setHeaderParam("typ","JWT")
		    .setClaims(claims)
		    .setIssuedAt(now)
		    .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
		    .compact();
	        
	        //Claims cc = jwtTokenUtil.getJwtJSON(token);
	       // System.out.println("dddd");

	        
	return token;
    }
    
   


}
