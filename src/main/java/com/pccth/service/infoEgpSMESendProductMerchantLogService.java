package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoEgpSMESendProductMerchantLogService {
	static Logger log = Logger.getLogger(infoEgpSMESendProductMerchantLogService.class);  
	public static ArrayList<Map<String, Object>>infoEgpSMESendProductMerchantLog(String runningNo){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "SELECT \r\n"
					+ "    RUNNING_NO ,           ROW_SEQ ,               HEAD_DETAIL_TYPE ,          DETAIL_NO,\r\n"
					+ "    DEPT_ID,                   DEPT_SUB_ID,           PRODUCT_TYPE,                 INSERT_UPDATE_DELETE_FLAG,\r\n"
					+ "    UNSPSC_ID,               PRODUCT_ID,            MERCHANT_TYPE,               MERCHANT_NO,\r\n"
					+ "    MERCHANT_NAME_TH,MERCHANT_STATUS,   ERROR_DESC\r\n"
					+ "FROM EGPSME.SEND_PRODUCT_LOG \r\n"
					+ "WHERE RUNNING_NO =     '"+runningNo+"'\r\n"
					+ "ORDER BY ROW_SEQ\r\n"
					+ "";
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
