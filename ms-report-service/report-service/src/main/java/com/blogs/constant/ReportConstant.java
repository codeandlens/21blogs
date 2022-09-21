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
	put("RPT-001", "การจองคิว");
	put("RPT-002", "สรุปการจองคิว");
	put("RPT-003", "คำเชิญราย");
	put("RPT-004", "สรุปยอดโอน");
	put("RPT-005", "สรุปรายการที่จองเรียบร้อยแล้ว");
	put("RPT-006", "รายการเข้ารับบริการ");
	put("EMMA_CONSENT_FORM", "แบบคัดกรองสุขภาพ");
    }};
    
    @SuppressWarnings("serial")
    public static final Map<String,String> MAPPING_REPORT_SHEET_NAME = new HashMap<String,String>(){{
	put("EXP-999","ทดสอบรายงาน");
	put("RPT-001", "การจองคิว");
	put("RPT-002", "สรุปการจองคิว");
	put("RPT-003", "คำเชิญราย");
	put("RPT-004", "สรุปยอดโอน");
	put("RPT-005", "สรุปรายการที่จองเรียบร้อยแล้ว");
	put("RPT-006", "รายการเข้ารับบริการ");
	put("EMMA_CONSENT_FORM", "แบบคัดกรองสุขภาพ");
    }};
    
    @SuppressWarnings("serial")
    public static final Map<String,String> MAPPING_REPORT_NAME_BRANCH_ID = new HashMap<String,String>(){{
	put("RPT-005", "สรุปรายการที่จองเรียบร้อยแล้ว");
	put("RPT-006", "รายการเข้ารับบริการ");
    }};
    

}
