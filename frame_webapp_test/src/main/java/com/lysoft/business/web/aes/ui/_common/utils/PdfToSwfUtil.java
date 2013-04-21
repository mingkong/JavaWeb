package com.lysoft.business.web.aes.ui._common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PdfToSwfUtil {
	
	private String inPath;
	private String outPath;
	private String fileName;
	private String root;
	
	public PdfToSwfUtil(String inPath, String outPath, String fileName, String root) {
		File out = new File(outPath);
		if(!out.exists()) {
			out.mkdirs();
		}
		this.inPath = inPath;
		this.outPath = outPath;
		this.fileName = fileName;
		this.root = root;
	}

	public synchronized void convert() throws IOException {
		String cmd = buildCommand();
		if (!"".equals(cmd)) {
			Process pro = Runtime.getRuntime().exec(cmd);
			new CheckOutput(pro.getInputStream()).start();
			new CheckOutput(pro.getErrorStream()).start();
			try {
				pro.waitFor();
			} catch (Exception e) {
				System.out.println("PDF covert SWF error.....");
			}
		} else {
			System.out.println("Not Support This OS......");
		}
	}
	
	private String buildCommand() {
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("windows")) {
			String extPath = root + "\\common\\flash\\pdf2swf.exe";
			String cmd = extPath + " -t " + inPath + File.separator + fileName
					+ ".pdf -o " + outPath + File.separator + fileName
					+ ".swf -s flashversion=9";
			System.out.println(cmd);
			return cmd;
		} else if(os.contains("linux")) {
			return "";
		} else {
			return "";
		}
	}

	private static class CheckOutput extends Thread {
		public InputStream is;

		public CheckOutput(InputStream is) {
			this.is = is;
		}

		public void run() {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			try {
				while ((br.readLine()) != null);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
