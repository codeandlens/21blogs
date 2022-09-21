package com.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogs.model.MessageModel;
import com.blogs.model.SendMessageLineRequestModel;
import com.blogs.service.LineService;
import com.blogs.utils.RestHttpClient;
import com.google.gson.Gson;

@Service
public class LineServiceImpl implements LineService {
    
    @Value(value = "${line.line-url:https://api.line.me/v2/bot/message/push}")
    private String lineUrl;

    @Value(value = "${line.channel-access-token:AHjSqFsGpawDLGhjTxprQSifTDVYtYZ6TH5Jghw0Iiucg2joJh3+d+1EJXXPIE85E1TwwuZo6/LYRZ/e4kgJonoRA7Y1xgaPmYtlXQ5IYCmUGt9X+dZuNHNSn3VuND3L/H0pLu1jvnvDlDBby9mRFgdB04t89/1O/w1cDnyilFU=}")
    private String lineChannelAccessToken;
    
    @Value(value = "${line.welcome-message:Hello, Please reply this message for keeping your contact.}")
    private String lineWelcomeMessage;

    @Autowired
    private RestHttpClient restHttpClient;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendMessageLine1stTime(String faceBookId) {
	try {
	    Gson gson = new Gson();
	    SendMessageLineRequestModel request = new SendMessageLineRequestModel();
	    request.setTo(faceBookId);
	    List<MessageModel> messageList = new ArrayList<MessageModel>();
	    MessageModel message = new MessageModel();
	    message.setType("text");
	    message.setText(lineWelcomeMessage);
	    messageList.add(message);
	    request.setMessages(messageList);
	    log.info("API : /send message request to line:" + gson.toJson(request));
	    ResponseEntity<String> responseEntity = restHttpClient.httpPostWithLineToken(lineUrl, request,
		    new ParameterizedTypeReference<String>() {
		    }, lineChannelAccessToken);
	    log.info("API : /send message request to line:" + gson.toJson(responseEntity));
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
		log.info("API : /send message request to Line Success:" + gson.toJson(responseEntity));
	    } else {
		log.info("API : /send message request to Line Fail:" + gson.toJson(responseEntity));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void sendMessageLine(String faceBookId, String messageText) {
	try {
	    Gson gson = new Gson();
	    SendMessageLineRequestModel request = new SendMessageLineRequestModel();
	    request.setTo(faceBookId);
	    List<MessageModel> messageList = new ArrayList<MessageModel>();
	    MessageModel message = new MessageModel();
	    message.setType("text");
	    message.setText(messageText);
	    messageList.add(message);
	    request.setMessages(messageList);
	    log.info("API : /send message request to line:" + gson.toJson(request));
	    ResponseEntity<String> responseEntity = restHttpClient.httpPostWithLineToken(lineUrl, request,
		    new ParameterizedTypeReference<String>() {
		    }, lineChannelAccessToken);
	    log.info("API : /send message request to line:" + gson.toJson(responseEntity));
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
		log.info("API : /send message request to Line Success:" + gson.toJson(responseEntity));
	    } else {
		log.info("API : /send message request to Line Fail:" + gson.toJson(responseEntity));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    
}
