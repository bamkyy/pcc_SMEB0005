package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoEmailEgpRdbDeptSubService {
	static Logger log = Logger.getLogger(infoEmailEgpRdbDeptSubService.class);  
	public static ArrayList<Map<String, Object>>infoEmailEgpRdbDeptSub(String deptId,String deptSubId){
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			if(deptSubId == null || deptSubId.trim().length() == 0) {
				sql += "Select CASE WHEN DEPT_SUB_NAME IS NULL THEN '' ELSE DEPT_SUB_NAME END AS DEPT_SUB_NAME,CASE WHEN EMAIL_NAME IS NULL THEN '' ELSE EMAIL_NAME END AS EMAIL_NAME from EGPRDB.RDB_DEPT_SUB WHERE DEPT_ID ='"+deptId+"'";
			}
			else {
			sql += "Select CASE WHEN DEPT_SUB_NAME IS NULL THEN '' ELSE DEPT_SUB_NAME END AS DEPT_SUB_NAME,CASE WHEN EMAIL_NAME IS NULL THEN '' ELSE EMAIL_NAME END AS EMAIL_NAME from EGPRDB.RDB_DEPT_SUB WHERE DEPT_ID =  '"+deptId+"' AND DEPT_SUB_ID = '"+deptSubId+"'";
			}
			list = dbUtil.executeQueryAdv(sql);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		
		return list;
		
	}
}
