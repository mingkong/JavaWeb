package com.lysoft.business.web.aes.ui._common.utils;

import java.io.File;

public class FileChangeUtil {
	private static FileChangeUtil instance = null;

	public static FileChangeUtil getInstance() {
		if (instance == null) {
			instance = new FileChangeUtil();
		}
		return instance;
	}

	public void convert(String dir, String fileName, String fileType, String ctx) throws Exception{
		if (fileType.equals(".pdf")) {
			pdfToSwf(dir, fileName, fileType, ctx);
		} else if(".doc|.txt|.ppt|.xls".contains(fileType)) {
			docToSwf(dir, fileName, fileType, ctx);
		}
	}

	private void docToSwf(String filePath, String fileName, String fileType,
			String ctx) throws Exception {
		
	}

	private void pdfToSwf(String filePath, String fileName, String fileType,
			String ctx) throws Exception {
		PdfToSwfUtil p2s = new PdfToSwfUtil(filePath + File.separator + "temp", filePath
				+ File.separator + "swf", fileName, ctx);
		p2s.convert();
	}
}
