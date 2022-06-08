package com.pccth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class insEgpSmeSendProductMerchantService {
	static Logger log = Logger.getLogger(insEgpSmeSendProductMerchantService.class);

	public static void insEgpSmeSendProductMerchant(String runningNo, String deptId, String deptSubId,
			String productType, String apiFtp, String filename, String receiveStatus, String receieveCancelDesc,
			String batchStatus, String batchDate, String totalRow, String successRow, String errorRow) {
		try {
			Connection conn = dbUtil.getDDBConnection();
			conn.setAutoCommit(true);

			String query = "INSERT INTO EGPSME.SEND_PRODUCT_MERCHANT\r\n" + "(   RUNNING_NO,DEPT_ID,DEPT_SUB_ID,"
					+ "PRODUCT_TYPE, RECEIVE_DATE, FILE_NAME, " + " RECEIVE_STATUS, RECEIVE_CANCLE_DESC, BATCH_STATUS, "
					+ " BATCH_DATE, TOTAL_ROW, SUCCESS_ROW, " + " ERROR_ROW, API_FTP) \r\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" + "";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, runningNo);
			preparedStmt.setString(2, deptId);
			preparedStmt.setString(3, deptSubId);
			preparedStmt.setString(4, productType);
			preparedStmt.setString(5, Tools.getLocalDate());
			preparedStmt.setString(6, filename);
			preparedStmt.setString(7, receiveStatus);
			preparedStmt.setString(8, receieveCancelDesc);
			preparedStmt.setString(9, batchStatus);
			preparedStmt.setString(10, batchDate);
			preparedStmt.setString(11, totalRow);
			preparedStmt.setString(12, successRow);
			preparedStmt.setString(13, successRow);
			preparedStmt.setString(14, apiFtp);

			preparedStmt.execute();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
