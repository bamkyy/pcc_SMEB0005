package com.pccth.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class infoMaxRunningNoEgpSmeSendProductMerchantService {
	static Logger log = Logger.getLogger(infoMaxRunningNoEgpSmeSendProductMerchantService.class);

	public static ArrayList<Map<String, Object>> infoMaxRunningNoEgpSmeSendProductMerchant() {
		ArrayList<Map<String, Object>> list = null;
		String sql = "";

		try {
			String budgetYear = Tools.getYearTH();
			int runningNo = Integer.parseInt(budgetYear + "000000");
			sql = "SELECT 	CASE\r\n" + "WHEN MAX(RUNNING_NO) IS NULL OR MAX(RUNNING_NO) = 0 THEN " + runningNo
					+ "+1\r\n" + "ELSE MAX(RUNNING_NO)+1\r\n" + "END as maxRunningNo       \r\n"
					+ "FROM EGPSME.SEND_PRODUCT_MERCHANT\r\n" + "WHERE  RUNNING_NO  > 	" + runningNo;
			list = dbUtil.executeQueryAdv(sql);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}

		return list;

	}
}
