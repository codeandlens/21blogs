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

    public static final String E400_P_RPT_03 = "E400_P_ARR_03";
    public static final String E400_P_RPT_03_DES = "หมอไม่มีในระบบ";
    public static final String E400_P_RPT_06 = "E400_P_ARR_06";
    public static final String E400_P_RPT_06_DES = "สาขาไม่มีในระบบ";
    public static final String E400_P_RPT_07 = "E400_P_ARR_07";
    public static final String E400_P_RPT_07_DES = "ช่วงเวลาที่เลือกเต็มแล้ว กรุณาเลือกช่วงเวลาใหม่";
    public static final String E400_P_RPT_47 = "E400_P_ARR_47";
    public static final String E400_P_RPT_47_DES = "ไม่ได้ระบุช่วงเวลาการทำงานของหมอ";
    public static final String E400_P_RPT_48 = "E400_P_ARR_48";
    public static final String E400_P_RPT_48_DES = "ไม่สารมารถ upload excel ได้เนื่องจากการตั้งค่าที่ sheet effort ไม่ถูกต้อง";
    public static final String E400_P_RPT_49 = "E400_P_ARR_49";
    public static final String E400_P_RPT_49_DES = "ไม่สามารถเลื่อนตารางหมอได้ เนื่องจากหมอไม่มีตารางเวลา ในวันดังกล่าว";
    public static final String E400_P_RPT_50 = "E400_P_ARR_50";
    public static final String E400_P_RPT_50_DES = "ไม่สามารถลงลาได้ เนื่องจากหมอไม่มีตารางเวลา ในวันดังกล่าว";
    public static final String E400_P_RPT_51 = "E400_P_ARR_51";
    public static final String E400_P_RPT_51_DES = "ไม่สามารถเปลี่ยนตารางหมอได้ เนื่องจากหมอไม่มีตารางเวลา ในวันดังกล่าว";

    public static final String E500_U_RPT_UPLOAD_AFFECTED_BOOKING = "กรุณาตรวจสอบข้อมูลให้ถูกต้อง";
    public static final String E500_U_RPT_UPLOAD_AFFECTED_BOOKING_DES = "เนื่องจากมีการเปลี่ยนแปลงตารางการทำงานที่กระทบกับการจองที่มีอยู่แล้ว";

    public static String getDescription(String desc, String message) {
	return desc.replace("{0}", message);
    }
}
