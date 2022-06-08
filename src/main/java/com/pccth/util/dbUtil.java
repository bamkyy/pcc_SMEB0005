package com.pccth.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.pccth.config.ConstantConfig;


public class dbUtil {
	public static Connection getDDBConnection()  {
		Connection connection = null;
		try {
			Class.forName(ConstantConfig.dbDriver);
			connection = DriverManager.getConnection(ConstantConfig.dbUrl,ConstantConfig.dbUser,ConstantConfig.dbPassword);
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static ArrayList<Map<String, Object>> executeQueryAdv(String sql){
		Connection con = null;
		Statement stmt = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{
			con = getDDBConnection();
			
			stmt = con.createStatement();		
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			String[] colNames = new String[colCount];
			String toCap = null;
			for (int j = 1; j <= colCount; j++){
				toCap = rsmd.getColumnName(j);
				colNames[j-1] = toCap.toUpperCase();
			}
			int rowNum = 0;

			while(rs.next()){
				//Represent Row Object
				Map<String, Object> map = new HashMap<String, Object>();			
				
				for(int i = 1;i<= colCount;i++){
					Object obj = rs.getObject(i);
                    if(obj != null){
                        if (obj instanceof Date) {
                            obj = rs.getString(i);
                        }
                        map.put(colNames[i-1],obj);
                    }else{
                        map.put(colNames[i-1],"");
                    }										
				}		
				
				list.add(rowNum,map);
				//Represent Table Object			
				rowNum++;
			}//End Records
	
		}catch(Exception e){
			System.out.println("DBUtil :: executeQueryAdv : Exception " + e);
		}finally{
			try{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null){
					con.commit();
					con.close();
				}
			}catch(Exception ex){}
			
		}	
		
		return list;
	}
        
    public static ArrayList<Map<String, Object>> executeQueryAdv(Connection con,String sql){
		Statement stmt = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{			
			stmt = con.createStatement();		
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			String[] colNames = new String[colCount];
			String toCap = null;
			for (int j = 1; j <= colCount; j++){
				toCap = rsmd.getColumnName(j);
				colNames[j-1] = toCap.toUpperCase();
			}
			int rowNum = 0;

			while(rs.next()){
				//Represent Row Object
				Map<String, Object> map = new HashMap<String, Object>();			
				
				for(int i = 1;i<= colCount;i++){
					Object obj = rs.getObject(i);
                    if(obj != null){
                        if (obj instanceof Date) {
                            obj = rs.getString(i);
                        }
                        map.put(colNames[i-1],obj);
                    }else{
                        map.put(colNames[i-1],"");
                    }
										
				}		
				
				list.add(rowNum,map);
				//Represent Table Object			
				rowNum++;
			}//End Records
	
		}catch(Exception e){
			System.out.println("DBUtil :: executeQueryAdv : Exception " + e);
		}finally{
			try{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			}catch(Exception ex){}
			
		}	
		
		return list;
	}
}
