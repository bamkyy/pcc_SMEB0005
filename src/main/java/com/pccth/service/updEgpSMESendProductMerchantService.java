package com.pccth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class updEgpSMESendProductMerchantService {
	static Logger log = Logger.getLogger(updEgpSMESendProductMerchantService.class);

	public static void updEgpSMESendProductMerchant(String runningNo, String totalRow, String successRow,
			String errorRow) {
		try {
			Connection conn = dbUtil.getDDBConnection();
			conn.setAutoCommit(true);

			String query = "UPDATE  EGPSME.SEND_PRODUCT_MERCHANT\r\n" + "SET BATCH_STATUS = 'Y',\r\n"
					+ "      BATCH_DATE     = ?,\r\n" + "      TOTAL_ROW     = ?,\r\n" + "      SUCCESS_ROW  = ?,\r\n"
					+ "      ERROR_ROW     =  ?\r\n" + "WHERE RUNNING_NO = ? ;\r\n" + "";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, Tools.getLocalDateSeparate());
			preparedStmt.setString(2, totalRow);
			preparedStmt.setString(3, successRow);
			preparedStmt.setString(4, errorRow);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
