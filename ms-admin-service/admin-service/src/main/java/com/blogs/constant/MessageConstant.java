/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.constant;

public class MessageConstant {

    public static final String S200 = "S200";
    public static final String S200_DES = "OK,{0}";
    public static final String SUCC_QUERY = "get data is success";
    public static final String SUCC_DML = "insert/update/delete data is success";
    public static final String E500 = "E500";
    public static final String E500_DES = "Internal error, {0}";
    public static final String ERROR_QUERY = "cannot get data from database, please find more in log";
    public static final String ERROR_DML = "cannot insert/update/delete data, please find more in log";

    public static final String E400_P_01 = "E400_P_01";
    public static final String E400_P_01_DESC = "bad request";

    public static String getDescription(String desc, String message) {
	return desc.replace("{0}", message);
    }
}
