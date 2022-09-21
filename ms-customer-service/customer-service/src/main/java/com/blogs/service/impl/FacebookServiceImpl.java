package com.blogs.service.impl;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogs.model.MessageModel;
import com.blogs.model.RecipientFbMessageModel;
import com.blogs.model.SendMessageFBRequestModel;
import com.blogs.service.FacebookService;
import com.blogs.utils.RestHttpClient;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;

@Service
public class FacebookServiceImpl implements FacebookService {
    
    @Value(value = "${fb.client-token:7960ebb9b96fa38a139350ffc486cae6}")
    private String clientToken;
    
    @Value(value = "${fb.page-id:105410972046646}")
    private String pageId;
    
    @Value(value = "${fb.app-id:3085028211785862}")
    private String appID;
    
    @Value(value = "${fb.fb-url:https://graph.facebook.com/v12.0/me/messages?access_token=}")
    private String fbUrl;
    
    @Value(value = "${fb.channel-access-token:EAAr10RqvgIYBAMOvY8F2PxuRdD8ox7RoEMztrBXXZAxWdELki1SkvBgiehRJ2bWIavNVVlMPpGKxitfXYocjAkUPLFAX3GU4EtISNgtB9EBix6S3ysfnE0C7fBxsllEhrg9Cw2p8oSZAgM82DZC7vpuAhm6EQBgGRGvOkGFquZBMY0QxZB6hf}")
    private String fbChannelAccessToken;
    
    @Value(value = "${fb.welcome-message:Hello, Please reply this message for keeping your contact.}")
    private String fbWelcomeMessage;

    @Autowired
    private RestHttpClient restHttpClient;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String generateLoginId(String asId) {
	byte[] hmacSha256 = null;
	try {
	    Mac mac = Mac.getInstance("HmacSHA256");
	    String messageString = "umc_" + asId + "_" + appID + "_" + pageId;
	    SecretKeySpec secretKeySpec = new SecretKeySpec(clientToken.getBytes(), "HmacSHA256");
	    mac.init(secretKeySpec);
	    hmacSha256 = mac.doFinal(messageString.getBytes());
	    String login_id = Hashing.hmacSha256(clientToken.getBytes(StandardCharsets.UTF_8))
		    .hashString(messageString, StandardCharsets.UTF_8).toString();
	    return login_id;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
    
    @Override
    public void sendMessageFacebook1stTime(String loginId) {
	try {
	    Gson gson = new Gson();
	    SendMessageFBRequestModel request = new SendMessageFBRequestModel();
	    RecipientFbMessageModel recipient = new RecipientFbMessageModel();
	    recipient.setLogin_id(loginId);
	    MessageModel message = new MessageModel();
	    message.setText(fbWelcomeMessage);
	    request.setRecipient(recipient);
	    request.setMessage(message);
	    log.info("API : /send message request to FB:" + gson.toJson(request));

	    ResponseEntity<Object> responseEntity = restHttpClient.httpPost(fbUrl + fbChannelAccessToken,
		    request, new ParameterizedTypeReference<Object>() {
		    });
	    log.info("API : /send message request to FB:" + gson.toJson(responseEntity));
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
		log.info("API : /send message request to FB Success:" + gson.toJson(responseEntity));
	    } else {
		log.info("API : /send message request to FB Fail:" + gson.toJson(responseEntity));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void sendMessageFacebook(String senderId, String messageText) {
	try {
	    Gson gson = new Gson();
	    SendMessageFBRequestModel request = new SendMessageFBRequestModel();
	    RecipientFbMessageModel recipient = new RecipientFbMessageModel();
	    recipient.setId(senderId);
	    MessageModel message = new MessageModel();
	    message.setText(messageText);
	    request.setRecipient(recipient);
	    request.setMessage(message);
	    log.info("API : /send message request to FB:" + gson.toJson(request));

	    ResponseEntity<Object> responseEntity = restHttpClient.httpPost(fbUrl + fbChannelAccessToken,
		    request, new ParameterizedTypeReference<Object>() {
		    });
	    log.info("API : /send message request to FB:" + gson.toJson(responseEntity));
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
		log.info("API : /send message request to FB Success:" + gson.toJson(responseEntity));
	    } else {
		log.info("API : /send message request to FB Fail:" + gson.toJson(responseEntity));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    

}
