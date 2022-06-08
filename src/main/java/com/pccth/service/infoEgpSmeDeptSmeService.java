package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoEgpSmeDeptSmeService {
	static Logger log = Logger.getLogger(infoEgpSmeDeptSmeService.class);  
	public static ArrayList<Map<String, Object>>infoEgpSmeDeptSme(){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "SELECT DEPT_ID FROM EGPSME.DEPT_SME";
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
