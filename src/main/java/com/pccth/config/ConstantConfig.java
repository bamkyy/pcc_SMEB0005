package com.pccth.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConstantConfig {
	public static String pathFile;
	public static String FileName;
	public static String pathFileOutput;
	public static String logFilePath;
	public static String dbDriver;
	public static String dbUrl;
	public static String dbUser;
	public static String dbPassword;
	public static String fileInputName;
	//public static ArrayList<?> infoEgpSMELastBatch;
	
	public static void initConfig(String configFilePath) throws Exception {
		InputStream inputStream = null;
		Properties prop = null;
		
		try {
			prop = new Properties();
			inputStream = new FileInputStream(configFilePath);
			prop.load(inputStream);
			dbDriver = prop.getProperty("DBDriver");
			dbUrl = prop.getProperty("DBUrl");
			dbUser= prop.getProperty("DBUser");
			dbPassword= prop.getProperty("DBPassword");
			pathFileOutput = prop.getProperty("path.file.output");
			FileName = prop.getProperty("file.name.output");
			logFilePath = prop.getProperty("log.file.output");
			fileInputName = prop.getProperty("file.input.name");
			System.setProperty("logPath", logFilePath);
			
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
