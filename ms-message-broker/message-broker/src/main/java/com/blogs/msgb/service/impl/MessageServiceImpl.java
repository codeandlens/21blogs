/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.blogs.msgb.constants.SubscribeMappingConstants;
import com.blogs.msgb.entity.Queue;
import com.blogs.msgb.http.RestHttpClient;
import com.blogs.msgb.model.RetriveDataResponse;
import com.blogs.msgb.repository.QueueRepository;
import com.blogs.msgb.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private SubscribeMappingConstants subscribeCon;
    @Autowired
    private RestHttpClient restHttpClient;
    @Autowired
    private QueueRepository repo;
    @Value(value = "${service-token}")
    private String token;
    @Value(value = "${sync-events}")
    private String syncEvents;

    public String sendMessageToSubscribe(String mainService, List<String> des, Map<String, Object> messages) {
	log.info("Start process send message to subscribe");
	try {
	    Queue ent = new Queue();
	    ent.setMainServiceName(mainService);
	    ent.setEvent((String) messages.get("event"));
	    ent.setData(messages.get("data").toString());
	    repo.save(ent);
	    boolean isSyncEvent = false;
	    if (syncEvents != null) {
		String e = (String) messages.get("event");
		String[] elist = syncEvents.split(",");
		for (String sevent : elist) {
		    if (sevent != null && sevent.equalsIgnoreCase(e)) {
			isSyncEvent = true;
			break;
		    }
		}
	    }
	    if (isSyncEvent) {
		send(des, messages, token, restHttpClient);
	    } else {
		new sendMessageThread(des, messages, restHttpClient).start();
	    }
	    return "Success";
	} catch (Exception e) {
	    log.error(e.getMessage());
	    e.printStackTrace();
	    return "Fail";
	}
    }

    public List<RetriveDataResponse> retriveData(String serviceName, String lastDataTimeStamp) {
	List<RetriveDataResponse> modelList = new ArrayList<RetriveDataResponse>();
	try {
	    // StringBuilder mainServiceList = new StringBuilder();
	    List<String> mainServiceList = new ArrayList<String>();
	    // System.out.println(subscribeCon.mainToSubscribeName.entrySet().size());
	    // System.out.println(subscribeCon.mainToSubscribeName.entrySet());
	    for (Map.Entry<String, List<String>> entry : subscribeCon.mainToSubscribeName.entrySet()) {

		for (String sub : entry.getValue()) {
		    if (serviceName.equals(sub)) {
			/*
			 * old version
			 */
//			if(mainServiceList.length()==0) {
//				mainServiceList.append(entry.getKey());
//			}else {
//				mainServiceList.append(",").append(entry.getKey());
//			}

			if (mainServiceList.size() == 0) {
			    mainServiceList.add(entry.getKey());
			} else {
			    mainServiceList.add(entry.getKey());
			}

		    }
		}
	    }

	    // List<Queue> ents = repo.findByMainServiceNameAndLastModifiedDate(mainServiceList.toString(),lastDataTimeStamp);
	    List<Queue> ents = repo.findByMainServiceNameListAndLastModifiedDate(mainServiceList, lastDataTimeStamp);

	    for (Queue ent : ents) {
		Map<String, Object> data = convertStringToMap(ent.getData());
		RetriveDataResponse model = new RetriveDataResponse();
		model.setEvent(ent.getEvent());
		model.setData(data);
		modelList.add(model);
	    }
	    return modelList;
	} catch (Exception e) {
	    e.printStackTrace();
	    return modelList;
	}
    }

    private Map<String, Object> convertStringToMap(String str) {
	Map<String, Object> result = new HashMap<String, Object>();
	try {
	    str = str.replace("{", "");
	    str = str.replace("}", "");
	    String[] lists = str.split(",");
	    List<String> dataList = Arrays.asList(lists);
	    for (String data : dataList) {
		String[] col = data.split("=");
		try {
		    result.put(col[0].trim().toString(), col[1].trim().toString());
		} catch (ArrayIndexOutOfBoundsException e) {
		    // skip column
		}
	    }
	    return result;
	} catch (Exception e) {
	    e.printStackTrace();
	    return result;
	}
    }

    private static synchronized void send(List<String> des, Map<String, Object> messages, String token, RestHttpClient restHttpClient) {
	log.info("Start process send message to subscribe");
	for (String destination : des) {
	    try {
		restHttpClient.httpPostWithToken(destination, messages, new ParameterizedTypeReference<String>() {
		}, token);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    log.info("Destination :" + destination + " already sent");
	}
	log.info("End process send message to subscribe");
    }

    public class sendMessageThread extends Thread {

	private List<String> des;
	private Map<String, Object> messages;
	private RestHttpClient restHttpClient;

	public sendMessageThread(List<String> des, Map<String, Object> messages, RestHttpClient restHttpClient) {
	    this.des = des;
	    this.messages = messages;
	    this.restHttpClient = restHttpClient;
	}

	public void run() {
	    send(this.des, this.messages, token, restHttpClient);
	}

    }

}

