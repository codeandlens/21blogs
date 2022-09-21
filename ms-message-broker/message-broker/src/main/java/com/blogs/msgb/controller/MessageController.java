/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.msgb.constants.SubscribeMappingConstants;
import com.blogs.msgb.model.CheckingAndRetriveRequest;
import com.blogs.msgb.model.ProkeSubscribeRequest;
import com.blogs.msgb.model.RequestModel;
import com.blogs.msgb.model.ResponseModel;
import com.blogs.msgb.model.RetriveDataResponse;
import com.blogs.msgb.service.MessageService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MessageController {

    @Autowired
    private SubscribeMappingConstants subscribeCon;
    @Autowired
    private MessageService service;

    @Value(value = "${msg.service.admin-service-event-receiver}")
    private String test;

    @PostMapping(value = "/prokeSubscribe", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "prokeSubscribe", notes = "Proke to Subscribe")
	public String prokeSubscribe(@RequestBody RequestModel<ProkeSubscribeRequest> request) {
		try {
            System.out.println("Start process proke subscribe");
			List<String> subscribes = subscribeCon.mainToSubscribe.get(request.getCriteria().getMainServiceName());
			if (subscribes.size() < 1) {
				System.out.println("End process proke subscribe");
				return "Can't found subscribe service";
			} else {
				String result = service.sendMessageToSubscribe(request.getCriteria().getMainServiceName(), subscribes,
						request.getCriteria().getMessage());
				if ("Success".equals(result)) {
					System.out.println("End process proke subscribe");
					return "This message already send";
				} else {
					System.out.println("End process proke subscribe");
					return "This message cannott send";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "This message cannott send";
		}
	}

    
    
    @PostMapping(value = "/checkingQueueAndRetrive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "checkingQueueAndRetrive", notes = "Proke to Subscribe")
    public ResponseModel<List<RetriveDataResponse>> checkingQueueAndRetrive(@RequestBody RequestModel<CheckingAndRetriveRequest> request) {
    	return new ResponseModel<>(service.retriveData(request.getCriteria().getServiceName(), request.getCriteria().getLastDataTimeStamp()));
    }
    
    
    @RequestMapping(value = "/prokeMain", method = RequestMethod.POST)
    public String prokeMain() {
	System.out.println(test);
	return "custom";
    }
    
}
