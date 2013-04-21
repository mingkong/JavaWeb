package com.lysoft.business.web.aes.common.upload;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.ProgressListener;

public class UploadListener implements ProgressListener {
	
	private HttpServletRequest request = null;

	public UploadListener(HttpServletRequest request){
		this.request = request;
	}

	/**
	 *  更新状态
	 */
	public void update(long bytesRead, long contentLength, int items) {
		UploadStatus statusBean = UploadServlet.getStatusBean(request);
		statusBean.setUploadTotalSize(contentLength);
		if (contentLength == -1) {// 读取完成
			statusBean.setStatus("完成对" + items + "个文件的读取:读取了 " + bytesRead
					+ " bytes.");
			statusBean.setReadTotalSize(bytesRead);
			statusBean.setSuccessUploadFileCount(items);
			statusBean.setProcessEndTime(System.currentTimeMillis());
			statusBean.setProcessRunTime(statusBean.getProcessEndTime());
		} else { // 读取中
			statusBean.setStatus("当前正在处理第" + items + "个文件:已经读取了 " + bytesRead
					+ " / " + contentLength + " bytes.");
			statusBean.setReadTotalSize(bytesRead);
			statusBean.setCurrentUploadFileNum(items);
			statusBean.setProcessRunTime(System.currentTimeMillis());
		}
		UploadServlet.saveStatusBean(request, statusBean);
	}

}
