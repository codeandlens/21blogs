/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.constant;

import java.util.HashMap;
import java.util.Map;

public class ReportConstant {
    
    public static final String createAdmin = "create-admin";
    public static final String REPORT_TYPE_EXCEL = "1";
    public static final String REPORT_TYPE_PDF = "2";
    public static final String FORMAT_DATE_FROM_TO = "yyyy-MM-dd";
    
    @SuppressWarnings("serial")
    public static final Map<String,String> MAPPING_REPORT_NAME = new HashMap<String,String>(){{
	put("EXP-999","TESTING_REPORT_");
    }};
    
    @SuppressWarnings("serial")
    public static final Map<String,String> MAPPING_REPORT_SHEET_NAME = new HashMap<String,String>(){{
	put("EXP-999","ทดสอบรายงาน");
    }};
    
    

}
