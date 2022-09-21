package com.blogs.constant;

public class MessageConstant {
    /*
     * 
     * P=PROCESS<NOT DATABASE> U=UNHANDLE S=SQL<DATABASE> E500_P_CUS_02
     * 
     * 
     */
    public static final String S200 = "S200";
    public static final String S200_DES = "OK,{0}";
    public static final String SUCC_MESSAGE = "Success";
    public static final String SUCC_QUERY = "get data is success";
    public static final String SUCC_DML = "insert/update/delete data is success";
    public static final String E500_U_CUS_00 = "E500_U_CUS_00";
    public static final String E500_U_CUS_00_DESC = "Internal error, {0}";
    public static final String E400_P_CUS_01 = "E400_P_CUS_01";
    public static final String E400_P_CUS_01_DES = "bad request";
    public static final String ERROR_QUERY = "cannot get data from database, please find more in log";
    public static final String ERROR_DML = "cannot insert/update/delete data, please find more in log";
    public static final String E500_S_CUS_01 = "E500_S_CUS_01";
    public static final String E500_S_CUS_01_DESC = "เลขบัตรประชาชนของท่านได้ทำการลงทะเบียนเรียบร้อยเเล้ว";
    public static final String SUCC_CONFIRM_BOOKING = "ยืนยันการจองเรียบร้อย";


    public static final String E500_U_RPT_ADMIN = "กรุณาติดต่อผู้ดูแลระบบ";
    public static final String E500_U_RPT_00 = "E500_U_RPT_00";
    public static final String E500_U_RPT_00_DESC = "Internal error, {0}";
    public static final String E500_S_RPT_01 = "E500_S_RPT_01";
    public static final String E500_S_RPT_01_DESC = "ไม่สามารถบันทึกแบบสอบถามได้ เนื่องจากแบบสอบถามนี้ได้ทำการบันทึกไปแล้ว";
    public static final String E500_S_RPT_02 = "E500_S_RPT_02";
    public static final String E500_S_RPT_02_DESC = "ไม่สามารถอัพเดทได้ เนื่องจากแบบสอบถามนี้ยังไม่ได้ทำการบันทึก";
    public static final String E400_P_RPT_01 = "E400_P_RPT_01";
    public static final String E400_P_RPT_01_DESC = "bad request";
    
    public static final String E400_P_AUTHEN_01 = "E400_P_AUTHEN_01";
    public static final String E400_P_AUTHEN_01_DESC = "รหัสผ่านไม่ถูกต้อง";

    public static final String E400_P_AUTHEN_02 = "E400_P_AUTHEN_02";
    public static final String E400_P_AUTHEN_02_DESC = "ชื่อผู้ใช้ไม่ถูกต้อง";

    public static String getDescription(String desc, String message) {
	return desc.replace("{0}", message);
    }
}
