package com.pccth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class insProductMerchantService {
	static Logger log = Logger.getLogger(insEgpSmeSendProductMerchantService.class);

	public static void insEgpSmeSendProductMerchant(String unscspId, String subcategoryId, String merchantType,
			String merchantNo, String merchantNameTh, String merchantStatus, String certificateId, String approveDate,
			String approveDateEx, String description1, String description2, String description3, String description4,
			String description5, String description6, String description7, String description8, String description9,
			String description10, String active) {
		
		try {
			Connection conn = dbUtil.getDDBConnection();
			conn.setAutoCommit(true);
			
			String query = "INSERT INTO  EGPSME.PRODUCT_MERCHANT (\r\n"
					+ "          UNSPSC_ID,              SUBCATEGORY_ID,      MERCHANT_TYPE,     MERCHANT_NO,     MERCHANT_NAME_TH,   \r\n"
					+ "          MERCHANT_STATUS,  CERTIFICATE_ID,         APPROVE_DATE,       APPROVE_DATE_EX, \r\n"
					+ "          DESCRIPTION1,          DESCRIPTION2,           DESCRIPTION3,         DESCRIPTION4,      DESCRIPTION5, \r\n"
					+ "          DESCRIPTION6,          DESCRIPTION7,           DESCRIPTION8,         DESCRIPTION9,      DESCRIPTION10,\r\n"
					+ "          CREATE_DATE,          CREATE_BY,               CREATE_NAME,         UPD_DATE,           UPD_BY,\r\n"
					+ "          UPD_NAME,              ACTIVE\r\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, unscspId);
			preparedStmt.setString(2, subcategoryId);
			preparedStmt.setString(3, merchantType);
			preparedStmt.setString(4, merchantNo);
			preparedStmt.setString(5, merchantNameTh);
			preparedStmt.setString(6, merchantStatus);
			preparedStmt.setString(7, certificateId);
			preparedStmt.setString(8, (approveDate.trim().length() == 0 ? Tools.getLocalDate() : approveDate));
			preparedStmt.setString(9, (approveDateEx.trim().length() == 0 ? null : approveDateEx));
			preparedStmt.setString(10, description1);
			preparedStmt.setString(11, description2);
			preparedStmt.setString(12, description3);
			preparedStmt.setString(13, description4);
			preparedStmt.setString(14, description5);
			preparedStmt.setString(15, description6);
			preparedStmt.setString(16, description7);
			preparedStmt.setString(17, description8);
			preparedStmt.setString(18, description9);
			preparedStmt.setString(19, description10);
			preparedStmt.setString(20, Tools.getLocalDate());
			preparedStmt.setString(21, "SMEB0004");
			preparedStmt.setString(22, "SMEB0004");
			preparedStmt.setString(23, Tools.getLocalDate());
			preparedStmt.setString(24, "SMEB0004");
			preparedStmt.setString(25, "SMEB0004");
			preparedStmt.setString(26, active);

			preparedStmt.execute();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
