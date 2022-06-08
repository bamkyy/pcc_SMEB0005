package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoEgpSmeAdminEmailService {
	static Logger log = Logger.getLogger(infoEgpSmeAdminEmailService.class);  
	public static ArrayList<Map<String, Object>>infoEgpSmeAdminEmail(){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "SELECT EMAIL_NAME FROM EGPSME.ADMIN_EMAIL";
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
