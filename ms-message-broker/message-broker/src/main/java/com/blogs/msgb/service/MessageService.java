/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.service;

import java.util.List;
import java.util.Map;

import com.blogs.msgb.model.RetriveDataResponse;

public interface MessageService {
    
	public String sendMessageToSubscribe(String mainService,List<String> des,Map<String,Object> messages);
	public List<RetriveDataResponse> retriveData(String serviceName,String lastDataTimeStamp);

}
