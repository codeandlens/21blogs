package com.blogs.constant;

public class UploadConstant {

    public static final String STANDARD_SHEET_NAME = "standard";
    public static final String STANDARD_SLOT_SHEET_NAME = "standard_slot";
    public static final String DOCTOR_SHEET_NAME = "Doctor";
    public static final String BRANCH_SHEET_NAME = "Branch";
    public static final String LEAVE_SHEET_NAME = "leave";
    public static final String EFFORT_SHEET_NAME = "effort";
    
    public static final String SUCCESS_CODE = "S200";
    
    /*STANDARD SHEET*/
    public static final String DATE = "date";
    public static final String DATE_OF_WEEK = "dayOfweek";
    public static final String YEAR = "YEAR";
    public static final int SHEET_STAND_CONFIG_MAX_COLUMN_PER_YEAR = 14;
    public static final String PREFIX_STANDARD_REF_CODE = "STD";
    public static final String PREFIX_EXCEPTION_REF_CODE = "EXC";
    
    public static final String LEAVE_SHEET_COLUMN_0 = "ชื่อหมอ";
    public static final String LEAVE_SHEET_COLUMN_1 = "วันตั้งต้น";
    public static final String LEAVE_SHEET_COLUMN_2 = "วันทดแทน";
    public static final String LEAVE_SHEET_COLUMN_3 = "สาขาที่มาทำงาน";
    public static final String LEAVE_SHEET_COLUMN_4 = "เวลาเริ่ม";
    public static final String LEAVE_SHEET_COLUMN_5 = "เวลาสิ้นสุด";
    public static final String LEAVE_SHEET_COLUMN_6 = "ปรึกษา/fu";
    public static final String LEAVE_SHEET_COLUMN_7 = "ศัลยกรรม";
    public static final String LEAVE_SHEET_COLUMN_8 = "ผิว";
    public static final String LEAVE_SHEET_COLUMN_9 = "ประเภท";
    
    public static final String EFFORT_SHEET_COLUMN_0 = "หมอ";
    public static final String EFFORT_SHEET_COLUMN_1 = "ระยะเวลาในการผ่าตัด";
    public static final String EFFORT_SHEET_COLUMN_2 = "ระยะเวลาในการปรึกษา";
    public static final String EFFORT_SHEET_COLUMN_3 = "ระยะเวลาในการทำหัตถการ";
    
    /*STANDARD SLOT SHEET*/
    public static final String VALID_YEAR = "valid year";
    public static final String TIME_SLOT_HEADER = "ออกตรวจ";
    public static final String SERVICE_CLASS_GDO = "ปรึกษา/fu";
    public static final String SERVICE_CLASS_GSG = "ศัลยกรรม";
    public static final String SERVICE_CLASS_GSK = "ผิว";
    public static final int SHEET_SLOT_CONFIG_MAX_COLUMN_PER_YEAR = 4;
    public static final int SHEET_SLOT_MAX_COLUMN_HEADER = 8;
    
    /*MERGE EXCEPTION STEP*/
    public static final String EXC_LEAVE_CASE = "ลา";
    public static final String EXC_MOVE_CASE = "ย้าย";
    public static final String EXC_REPLACE_CASE = "เพิ่ม";
}
