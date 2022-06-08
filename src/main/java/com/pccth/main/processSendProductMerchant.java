package com.pccth.main;

import java.io.File;

import org.apache.log4j.Logger;

import com.pccth.config.ConstantConfig;
import com.pccth.service.infoEgpSmeDeptSmeService;
import com.pccth.service.infoMaxRunningNoEgpSmeSendProductMerchantService;
import com.pccth.util.Tools;

public class processSendProductMerchant {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String filePath = new File("").getAbsolutePath();
		ConstantConfig.initConfig(filePath + "/config.properties");
		Logger log = Logger.getLogger(processSendProductMerchant.class);
 System.out.print(infoEgpSmeDeptSmeService.infoEgpSmeDeptSme());
	}

}
