/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.bao.AuthenBAO;
import com.blogs.model.EventReceiverModel;
import com.blogs.model.GenerateTokenRequestModel;
import com.blogs.model.GenerateTokenResponseModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class AuthenController {

    @Autowired
    private AuthenBAO authenBao;

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/event-receiver", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Event Receiver", notes = "")
    public ResponseModel updateInviteStatus(@RequestBody EventReceiverModel request) {
	return authenBao.receiveMessageFromBroker(request);
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/generateToken", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "generateToken", notes = "for get branch detail")
    public ResponseModel<GenerateTokenResponseModel> generateToken(@RequestBody RequestModel<GenerateTokenRequestModel> request) {
	return authenBao.generateToken(request);
    }


}
