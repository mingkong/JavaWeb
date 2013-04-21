package com.lysoft.business.web.aes.common.upload;

import java.util.Vector;

public class BeanControler {
	private static BeanControler beanControler = new BeanControler();
	private Vector<UploadStatus> vector = new Vector<UploadStatus>();

	private BeanControler() {}

	public static BeanControler getInstance() {
		return beanControler;
	}

	/**
	 * 取得相应UploadStatus类对象的存储位置
	 */
	private int indexOf(String uploadAddr) {
		int nReturn = -1;
		for (int i = 0; i < vector.size(); i++) {
			UploadStatus status = (UploadStatus) vector.elementAt(i);
			if (status.getUploadAddr().equals(uploadAddr)) {
				nReturn = i;
				break;
			}
		}
		return nReturn;
	}

	/**
	 * 取得相应UploadStatus类对象
	 */
	public UploadStatus getUploadStatus(String uploadAddr) {
		return (UploadStatus) vector.elementAt(indexOf(uploadAddr));
	}

	/**
	 * 存储FileUploadStatus类对象
	 */
	public void setUploadStatus(UploadStatus status) {
		int nIndex = indexOf(status.getUploadAddr());
		if (-1 == nIndex) {
			vector.add(status);
		} else {
			vector.insertElementAt(status, nIndex);
			vector.removeElementAt(nIndex + 1);
		}
	}

	/**
	 * 删除UploadStatus类对象
	 */
	public void removeUploadStatus(String uploadAddr) {
		int nIndex = indexOf(uploadAddr);
		if (-1 != nIndex) {
			vector.removeElementAt(nIndex);
		}
	}
}
