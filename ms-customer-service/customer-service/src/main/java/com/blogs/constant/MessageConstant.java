/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.constant;

public class MessageConstant {
    /* 
     * 
     * P=PROCESS<NOT DATABASE>
     * U=UNHANDLE
     * S=SQL<DATABASE>
     * E500_P_CUS_02
     * 
     * 
     * */
    public static final String S200 = "S200";
    public static final String S200_DES = "OK,{0}";
    public static final String SUCC_QUERY = "get data is success";
    public static final String SUCC_DML = "insert/update/delete data is success";
    public static final String E500_U_CUS_00 = "E500_U_CUS_00";
    public static final String E500_U_CUS_00_DESC = "Internal error, {0}";
    public static final String E400_P_CUS_01 = "E400_P_CUS_01";
    public static final String E400_P_CUS_01_DES = "bad request";
    public static final String E400_P_CUS_02 = "E400_P_CUS_02";
    public static final String E400_P_CUS_02_DES = "ลูกค้ายังไม่ได้ตอบรับข้อความเฟสบุค";
    
    public static final String E400_P_CUS_03 = "E400_P_CUS_03";
    public static final String E400_P_CUS_03_DES = "ลูกค้ายังไม่ได้ลงทะเบียนด้วย line";
    
    public static final String ERROR_QUERY = "cannot get data from database, please find more in log";
    public static final String ERROR_DML = "cannot insert/update/delete data, please find more in log";
    public static final String E500_S_CUS_01 = "E500_S_CUS_01";
    public static final String E500_S_CUS_01_DESC = "เลขบัตรประชาชนของท่านได้ทำการลงทะเบียนเรียบร้อยเเล้ว";

    public static String getDescription(String desc, String message) {
	return desc.replace("{0}", message);
    }
}
