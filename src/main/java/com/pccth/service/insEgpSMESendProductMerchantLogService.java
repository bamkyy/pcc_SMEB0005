package com.pccth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class insEgpSMESendProductMerchantLogService {
	static Logger log = Logger.getLogger(insEgpSMESendProductMerchantLogService.class);

	public static void insEgpSMESendProductMerchantLog(String runningNo, String rowSeq, String headDetailType,
			String detailNo, String deptId, String deptSubId, String productType, String insertUpdateDeleteFlag,
			String unspscId, String productId, String merchantType, String merchantNo, String merchantNameTh,
			String merchantStatus, String certificateId, String errorDesc) {
		try {
			Connection conn = dbUtil.getDDBConnection();
			conn.setAutoCommit(true);

			String query = "INSERT INTO EGPSME.SEND_PRODUCT_MERCHANT_LOG(\r\n"
					+ "    RUNNING_NO ,           ROW_SEQ ,               HEAD_DETAIL_TYPE ,          DETAIL_NO,\r\n"
					+ "    DEPT_ID,                   DEPT_SUB_ID,           PRODUCT_TYPE,                 INSERT_UPDATE_DELETE_FLAG,\r\n"
					+ "    UNSPSC_ID,               PRODUCT_ID,            MERCHANT_TYPE,               MERCHANT_NO,\r\n"
					+ "    MERCHANT_NAME_TH,MERCHANT_STATUS,   ERROR_DESC\r\n" + ") \r\n" + ""
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, runningNo);
			preparedStmt.setString(2, rowSeq);
			preparedStmt.setString(3, headDetailType);
			preparedStmt.setString(4, detailNo);
			preparedStmt.setString(5, deptId);
			preparedStmt.setString(6, deptSubId);
			preparedStmt.setString(7, productType);
			preparedStmt.setString(8, insertUpdateDeleteFlag);
			preparedStmt.setString(9, unspscId);
			preparedStmt.setString(10, productId);
			preparedStmt.setString(11, merchantType);
			preparedStmt.setString(12, merchantNo);
			preparedStmt.setString(13, merchantNameTh);
			preparedStmt.setString(14, merchantStatus);
			preparedStmt.setString(15, errorDesc);

			preparedStmt.execute();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
