package com.blogs.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.blogs.constant.MessageConstant;
import com.blogs.constant.ReportConstant;
import com.blogs.entity.CustomerDetail;
import com.blogs.model.ReportModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.repository.CustomerDetailRepo;
import com.blogs.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private JdbcTemplate jdbcTemplat;
    
    @Autowired
    private CustomerDetailRepo custRepo;
    
    public ResponseModel<ReportModel> generateReport(RequestModel<ReportModel> rptModel) {
	ResponseModel<ReportModel> response = new ResponseModel<ReportModel>();
	byte[] contentBytes = null;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	try {
	    JasperPrint jsPrint = generateJasperPrint(rptModel);
	    if (ReportConstant.REPORT_TYPE_EXCEL.equals(rptModel.getCriteria().getReportType())) {
		JRXlsxExporter exporter = new JRXlsxExporter();
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setSheetNames(new String[] { ReportConstant.MAPPING_REPORT_SHEET_NAME.get(rptModel.getCriteria().getReportName()) });
		exporter.setConfiguration(configuration);
		exporter.setExporterInput(new SimpleExporterInput(jsPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
		exporter.exportReport();
		contentBytes = outputStream.toByteArray();
	    }else if(ReportConstant.REPORT_TYPE_PDF.equals(rptModel.getCriteria().getReportType())) {
		contentBytes = JasperExportManager.exportReportToPdf(jsPrint);
	    }
	    rptModel.getCriteria().setContent(contentBytes);
	    response.setCode(MessageConstant.S200);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.S200_DES, MessageConstant.SUCC_QUERY));
	    response.setData(rptModel.getCriteria());
	}catch(Exception e) {
	    e.printStackTrace();
	    response.setCode(MessageConstant.E500_U_RPT_00);
	    response.setDesc(MessageConstant.getDescription(MessageConstant.E500_U_RPT_00_DESC,e.getMessage()));
	}
	return response;
    }

    public JasperPrint generateJasperPrint(RequestModel<ReportModel> rptModel) {

	JasperPrint jasperPrint = new JasperPrint();
	Connection conn = null;
	try {
	    conn = jdbcTemplat.getDataSource().getConnection();
	    DateFormat simpleDateFormat = new SimpleDateFormat(ReportConstant.FORMAT_DATE_FROM_TO);
	    String timeZone = rptModel.getTimezone();
	    String strDateDefault = simpleDateFormat.format(Calendar.getInstance().getTime());  
	    
	    TimeZone tz = TimeZone.getTimeZone(timeZone);
	    simpleDateFormat.setTimeZone(tz);
	    String dateFromStr = (String) rptModel.getCriteria().getParameters().getOrDefault("dateFrom",strDateDefault);
	    String dateToStr = (String) rptModel.getCriteria().getParameters().getOrDefault("dateTo",strDateDefault);
	    
	    
	    
	    Date dateFrom = simpleDateFormat.parse(dateFromStr);
	    Date dateTo = simpleDateFormat.parse(dateToStr);
	    Map<String,Object> param = rptModel.getCriteria().getParameters();
	    param.put("dateFrom", dateFrom);
	    param.put("dateTo", dateTo);
	    param.put("dateFromTh", thDateYYYYMMDD(dateFrom));
	    param.put("dateToTh", thDateYYYYMMDD(dateTo));
	    ClassPathResource jasper = new ClassPathResource("report/" + rptModel.getCriteria().getReportName() + ".jrxml");
	    jasperPrint = JasperFillManager.fillReport(JasperCompileManager.compileReport(jasper.getInputStream()),
		    param, conn);
	}catch (SQLException e1) {
	    e1.printStackTrace();
	} catch (JRException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ParseException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return jasperPrint;
    }
    


    public static String thDateYYYYMMDD(Date date) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	return date != null ? sdf.format(date) : "";
    }
    
    public CustomerDetail getLastestCustomer() {
	return custRepo.getLastest();
    }
    

}
