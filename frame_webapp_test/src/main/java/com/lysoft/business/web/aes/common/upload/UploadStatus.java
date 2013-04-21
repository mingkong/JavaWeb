package com.lysoft.business.web.aes.common.upload;

import java.util.ArrayList;
import java.util.List;

/**
 * 上传状态类
 */
public class UploadStatus {

	private String uploadAddr;// 用户地址
	private long uploadTotalSize = 0; // 上传总数(b)
	private long readTotalSize = 0; // 读的总数(b)
	private int currentUploadFileNum = 0; // 当前上传文件编号
	private int successUploadFileCount = 0; // 当前成功上传文件数
	private List<String> uploadFileUrlList = new ArrayList<String>();// 上传文件列表
	private List<String> uploadFileUuidList = new ArrayList<String>();// 生成编号列表
	private long processStartTime = 0l;// 处理起始时间
	private long processEndTime = 0l;// 处理终止时间
	private long processRunTime = 0l; // 处理执行时间
	private boolean cancel = false;// 取消上传
	private String status = "";// 状态

	public String getUploadAddr() {
		return uploadAddr;
	}

	public void setUploadAddr(String uploadAddr) {
		this.uploadAddr = uploadAddr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getProcessStartTime() {
		return processStartTime;
	}

	public void setProcessStartTime(long processStartTime) {
		this.processStartTime = processStartTime;
	}

	public long getProcessEndTime() {
		return processEndTime;
	}

	public void setProcessEndTime(long processEndTime) {
		this.processEndTime = processEndTime;
	}

	public long getProcessRunTime() {
		return processRunTime;
	}

	public void setProcessRunTime(long processRunTime) {
		this.processRunTime = processRunTime;
	}

	public boolean getCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public long getUploadTotalSize() {
		return uploadTotalSize;
	}

	public void setUploadTotalSize(long uploadTotalSize) {
		this.uploadTotalSize = uploadTotalSize;
	}

	public long getReadTotalSize() {
		return readTotalSize;
	}

	public void setReadTotalSize(long readTotalSize) {
		this.readTotalSize = readTotalSize;
	}

	public int getCurrentUploadFileNum() {
		return currentUploadFileNum;
	}

	public void setCurrentUploadFileNum(int currentUploadFileNum) {
		this.currentUploadFileNum = currentUploadFileNum;
	}

	public int getSuccessUploadFileCount() {
		return successUploadFileCount;
	}

	public void setSuccessUploadFileCount(int successUploadFileCount) {
		this.successUploadFileCount = successUploadFileCount;
	}

	public List<String> getUploadFileUrlList() {
		return uploadFileUrlList;
	}

	public void setUploadFileUrlList(List<String> uploadFileUrlList) {
		this.uploadFileUrlList = uploadFileUrlList;
	}

	public List<String> getUploadFileUuidList() {
		return uploadFileUuidList;
	}

	public void setUploadFileUuidList(List<String> uploadFileUuidList) {
		this.uploadFileUuidList = uploadFileUuidList;
	}
}
