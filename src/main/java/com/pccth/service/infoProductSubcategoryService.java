package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.dbUtil;

public class infoProductSubcategoryService {
	static Logger log = Logger.getLogger(infoProductSubcategoryService.class);

	public static ArrayList<Map<String, Object>> infoProductSubcategory(String productType, String unscspId,
			String deptId, String deptSubId, String productId) {
		ArrayList<Map<String, Object>> list = null;
		String sql = "";
		try {
			sql += "SELECT * FROM EGPSME.PRODUCT_SUBCATEGORY " 
					+ "WHERE   PRODUCT_TYPE = '" + productType+"' AND " 
					+ " UNSCSP_ID = '" + unscspId + "'   AND "
					+ " DEPT_ID     = '" + deptId + "' AND " 
					+ " DEPT_SUB_ID = '" + deptSubId
					+ "' AND PRODUCT_ID  = '" + productId + "'";
			list = dbUtil.executeQueryAdv(sql);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}

		return list;

	}
}
