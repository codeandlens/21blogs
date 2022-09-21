package com.blogs.service;

import com.blogs.entity.CustomerDetail;
import com.blogs.model.ReportModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;

import net.sf.jasperreports.engine.JasperPrint;

public interface ReportService {

    public ResponseModel<ReportModel> generateReport(RequestModel<ReportModel> rptModel);
    public JasperPrint generateJasperPrint(RequestModel<ReportModel> rptModel);
    
    /*Retrive data from msgBroker*/
    public CustomerDetail getLastestCustomer();
    
}
