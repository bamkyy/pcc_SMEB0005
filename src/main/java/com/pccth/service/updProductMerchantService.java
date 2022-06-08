package com.pccth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.pccth.util.Tools;
import com.pccth.util.dbUtil;

public class updProductMerchantService {
	static Logger log = Logger.getLogger(updProductMerchantService.class);

	public static void updProductMerchant(String unscspId, String subcategoryId, String merchantType,
			String merchantNo, String merchantNameTh, String merchantStatus, String certificateId, String approveDate,
			String approveDateEx, String description1, String description2, String description3, String description4,
			String description5, String description6, String description7, String description8, String description9,
			String description10, String active) {
		try {
			Connection conn = dbUtil.getDDBConnection();
			conn.setAutoCommit(true);

			String query = "UPDATE EGPSME.PRODUCT_MERCHANT MERCHANT_NAME_TH   =  ?,\r\n"
					+ "          MERCHANT_STATUS      		= ?,\r\n"
					+ "          CERTIFICATE_ID            	= ?,\r\n"
					+ "          APPROVE_DATE            	= ?,\r\n"
					+ "          APPROVE_DATE_EX       		= ?, \r\n"
					+ "          DESCRIPTION1              	= ?,\r\n"
					+ "          DESCRIPTION2              	= ?,\r\n"
					+ "          DESCRIPTION3              	= ?,\r\n"
					+ "          DESCRIPTION4              	= ?,\r\n"
					+ "          DESCRIPTION5              	= ?,\r\n"
					+ "          DESCRIPTION6              	= ?,\r\n"
					+ "          DESCRIPTION7              	= ?,\r\n"
					+ "          DESCRIPTION8           	= ?,\r\n"
					+ "          DESCRIPTION9           	= ?,\r\n"
					+ "          DESCRIPTION10         		= ?,\r\n"
					+ "          UPD_DATE                	= ?,\r\n"
					+ "          UPD_BY                   	=  ?,\r\n"
					+ "          UPD_NAME               	=  ?,\r\n"
					+ "          ACTIVE                     = ?"
					+ "WHERE UNSPSC_ID = ?  AND SUBCATEGORY_ID = ? AND MERCHANT_TYPE = ?  AND MERCHANT_NO = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, merchantNameTh);
			preparedStmt.setString(2, merchantStatus);
			preparedStmt.setString(3, certificateId);
			preparedStmt.setString(4, (approveDate.trim().length() == 0 ? Tools.getLocalDate() : approveDate));
			preparedStmt.setString(5, (approveDateEx.trim().length() == 0 ? null : approveDateEx));
			preparedStmt.setString(6, description1);
			preparedStmt.setString(7, description2);
			preparedStmt.setString(8, description3);
			preparedStmt.setString(9, description4);
			preparedStmt.setString(10, description5);
			preparedStmt.setString(11, description6);
			preparedStmt.setString(12, description7);
			preparedStmt.setString(13, description8);
			preparedStmt.setString(14, description9);
			preparedStmt.setString(15, description10);
			preparedStmt.setString(16, Tools.getLocalDate());
			preparedStmt.setString(17, "SMEB0004");
			preparedStmt.setString(18, "SMEB0004");
			preparedStmt.setString(19, active);
			preparedStmt.setString(20, unscspId);
			preparedStmt.setString(21, subcategoryId);
			preparedStmt.setString(22, merchantType);
			preparedStmt.setString(23, merchantNo);

			preparedStmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
