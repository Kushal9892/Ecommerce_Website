package com.niit.ecommercefrontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "C:/Users/km00353124/git/Ecommerce_Website/Ecommerce_Frontend/src/main/webapp/resources/images/";
	private static String REAL_PATH = "";
	//private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String productCode) {
		//Get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");
		//logger.info("REAL_PATH");
		
		// To make sure all the directories exist!!
		if(!new File(ABS_PATH).exists()) {
			// If not present, create a directory!!
			new File(ABS_PATH).mkdirs();
		}
			
		if(!new File(REAL_PATH).exists()) {
			// If not present, create a directory!!
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			// Server Upload for Image!!
			file.transferTo(new File(REAL_PATH + productCode + ".jpg"));
			// Project Directory Upload for Image!!
			file.transferTo(new File(ABS_PATH + productCode + ".jpg"));
		} catch (IOException ex) {
			
		}
		
		
		
		
	}
}
