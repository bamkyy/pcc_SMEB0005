package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoEgpSMESendProductMerchantService {
	static Logger log = Logger.getLogger(infoEgpSMESendProductMerchantService.class);  
	public static ArrayList<Map<String, Object>>infoEgpSMESendProductMerchant(){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "Select  RUNNING_NO, \r\n"
					+ "          DEPT_ID, \r\n"
					+ "          DEPT_SUB_ID, \r\n"
					+ "          PRODUCT_TYPE, \r\n"
					+ "          FILE_NAME ,\r\n"
					+ "          RECEIVE_DATE\r\n"
					+ "from EGPSME.SEND_PRODUCT_MERCHANT WHERE BATCH_STATUS = 'W'\r\n"
					+ "";
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
