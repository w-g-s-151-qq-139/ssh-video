package com.zhiyou100.dao.utils;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class MulFileUtil {

	protected final static String BASE_PATH = "D:\\upload";

	public static String filename(String image) {
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(image);
		return str + "." + ext;
	}
	public static File file(String filename){
		return new File(BASE_PATH+"\\"+filename);
	}
}
