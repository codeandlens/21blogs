/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.bao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.blogs.constant.ReportConstant;
import com.blogs.model.ReportModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.service.ReportService;

@Component
public class ReportBAO {

    @Autowired
    private ReportService reportService;
    

    @Value(value = "${jwt.secret}")
    private String jwtSecret;
    
    @Value(value = "${message-broker.url-retrive}")
    private String messageBrokerUrlRetrive;
    
    @Value(value = "${spring.service-name}")
    private String serviceName;

    


    public ResponseModel<ReportModel> generateReport(RequestModel<ReportModel> rptModel){
	ResponseModel<ReportModel> response = new ResponseModel<ReportModel>();
	response = reportService.generateReport(rptModel);
	return response;
    }
    
    public ResponseEntity<InputStreamResource> downloadReport(RequestModel<ReportModel> rptModel) throws IOException {
	ResponseModel<ReportModel> responseModel = generateReport(rptModel);
	if (responseModel != null && responseModel.getData() != null) {
	    InputStream is = new ByteArrayInputStream(responseModel.getData().getContent());
	    Date currentDate = new Date();
	    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	    String currentDateStr = df.format(currentDate);
//	    String reportName = ReportConstant.MAPPING_REPORT_NAME.get(rptModel.getCriteria().getReportName());
	    String fileName = rptModel.getCriteria().getReportName()+"_"+currentDateStr;
	    HttpHeaders headers = new HttpHeaders();
	    if(ReportConstant.REPORT_TYPE_EXCEL.equals(rptModel.getCriteria().getReportType())) {
		headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
		headers.add("Content-Disposition", "attachment;filename="+fileName+".xlsx");
	    }else if(ReportConstant.REPORT_TYPE_PDF.equals(rptModel.getCriteria().getReportType())) {
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Content-Disposition", "filename=" + fileName + ".pdf");
	    }
	    headers.add("Access-Control-Allow-Origin", "*");
	    headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
	    headers.add("Access-Control-Allow-Headers", "Content-Type");
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
	    headers.setContentLength(is.available());
	    ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
		    new InputStreamResource(is), headers, HttpStatus.OK);
	    return response;
	} else {
	    return null;  
	}
    }
    

}
