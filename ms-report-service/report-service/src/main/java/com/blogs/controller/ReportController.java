/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.bao.ReportBAO;
import com.blogs.bao.SubscriptedBAO;
import com.blogs.model.EventReceiverModel;
import com.blogs.model.ReportModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class ReportController {

    @Autowired
    private ReportBAO reportBAO;
    
    @Autowired
    private SubscriptedBAO subscriptedBAO;

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/event-receiver", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Event Receiver", notes = "")
    public ResponseModel updateInviteStatus(@RequestBody EventReceiverModel request) {
	return subscriptedBAO.receiveMessageFromBroker(request);
    }

    @PostMapping(value = "/getReport", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getReport", notes = "Get Report")
    public ResponseModel<ReportModel> getUser(@RequestBody RequestModel<ReportModel> request) {
	return reportBAO.generateReport(request);
    }

    @RequestMapping(value = "/download-report", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> downloadReport(@RequestBody RequestModel<ReportModel> request) throws IOException {
	return reportBAO.downloadReport(request);
    }
    
}
    
    

    
    
    

