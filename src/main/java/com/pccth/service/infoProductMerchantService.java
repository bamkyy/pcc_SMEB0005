package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoProductMerchantService {
	static Logger log = Logger.getLogger(infoProductMerchantService.class);  
	public static ArrayList<Map<String, Object>>infoProductMerchant(String unscspId, String subcategoryId, String merchantType, String merchantNo){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "Select UNSPSC_ID,  SUBCATEGORY_ID,  MERCHANT_TYPE,  MERCHANT_NO,  MERCHANT_NAME_TH,   \r\n"
					+ "          MERCHANT_STATUS, CERTIFICATE_ID, APPROVE_DATE, APPROVE_DATE_EX, \r\n"
					+ "          DESCRIPTION1, DESCRIPTION2, DESCRIPTION3, DESCRIPTION4, DESCRIPTION5, DESCRIPTION6, DESCRIPTION7, \r\n"
					+ "          DESCRIPTION8, DESCRIPTION9, DESCRIPTION10,ACTIVE\r\n"
					+ "from EGPSME.PRODUCT_MERCHANT \r\n"
					+ "WHERE UNSPSC_ID = '"+unscspId+"'  AND SUBCATEGORY_ID = '"+subcategoryId+"' AND MERCHANT_TYPE = '"+merchantType+"'  AND MERCHANT_NO = '"+merchantNo+"'";
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
