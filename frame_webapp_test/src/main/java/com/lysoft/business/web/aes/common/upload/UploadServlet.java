package com.lysoft.business.web.aes.common.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.lysoft.business.web.aes.ui._common.utils.FileChangeUtil;
import com.lysoft.web.utils.WebJsonUtils;

public class UploadServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 7242668938096324646L;
	private static final String UPLOAD_ERROR_URL = "/WEB-INF/ui/_common/widget_upload_result.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 从文件路径中取出文件名
	 */
	private String takeOutFileName(String filePath) {
		int pos = filePath.lastIndexOf(File.separator);
		if (pos > 0) {
			return filePath.substring(pos + 1);
		} else {
			return filePath;
		}
	}

	/**
	 * 从request中取出UploadStatus Bean
	 */
	public static UploadStatus getStatusBean(HttpServletRequest request) {
		BeanControler beanCtrl = BeanControler.getInstance();
		return beanCtrl.getUploadStatus(request.getRemoteAddr());
	}

	/**
	 * 把UploadStatus Bean保存到类控制器BeanControler
	 */
	public static void saveStatusBean(HttpServletRequest request,
			UploadStatus statusBean) {
		statusBean.setUploadAddr(request.getRemoteAddr());
		BeanControler beanCtrl = BeanControler.getInstance();
		beanCtrl.setUploadStatus(statusBean);
	}

	/**
	 * 删除已经上传的文件
	 */
	private void deleteUploadedFile(HttpServletRequest request) {
		UploadStatus satusBean = getStatusBean(request);
		for (int i = 0; i < satusBean.getUploadFileUrlList().size(); i++) {
			String dir = UploadUtil.getInstance().getLocation();
			String fileName = satusBean.getUploadFileUrlList().get(i);
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			File uploadedFile = new File(dir + File.separator + "temp" + File.separator
					+ satusBean.getUploadFileUuidList().get(i) + fileType);
			uploadedFile.delete();
		}
		satusBean.getUploadFileUrlList().clear();
		satusBean.getUploadFileUuidList().clear();
		satusBean.setStatus("删除已上传的文件");
		saveStatusBean(request, satusBean); 
	}

	/**
	 * 上传过程中出错处理
	 */
	private void uploadExceptionHandle(HttpServletRequest request, String errMsg)
			throws ServletException, IOException {
		// 首先删除已经上传的文件
		deleteUploadedFile(request);
		UploadStatus satusBean = getStatusBean(request);
		satusBean.setStatus(errMsg);
		saveStatusBean(request, satusBean);
	}

	/**
	 * 初始化文件上传状态Bean
	 */
	private UploadStatus initStatusBean(HttpServletRequest request) {
		UploadStatus satusBean = new UploadStatus();
		satusBean.setStatus("正在准备处理...");
		satusBean.setUploadTotalSize(request.getContentLength());
		satusBean.setProcessStartTime(System.currentTimeMillis());
		return satusBean; 
	}

	/**
	 * 处理文件上传
	 */
	@SuppressWarnings("deprecation")
	private void processFileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(10240000);
		// 设置临时文件存储位置
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")+ "/aes"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(102400000);
		// 设置整个request的最大值
		upload.setSizeMax(102400000);
		upload.setProgressListener(new UploadListener(request));
		// 保存初始化后的UploadStatus Bean
		saveStatusBean(request, initStatusBean(request));

		String forwardURL = "";
		try {
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			// 获得返回url
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);
				if (item.isFormField()) {
					forwardURL = item.getString();
					break;
				}
			}
			// 处理文件上传
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);

				// 取消上传
				if (getStatusBean(request).getCancel()) {
					deleteUploadedFile(request);
					break;
				}
				// 保存文件
				else if (!item.isFormField() && item.getName().length() > 0) {
					String fileName = takeOutFileName(item.getName());
					String fileType = fileName.substring(fileName.lastIndexOf("."));
					String dir = UploadUtil.getInstance().getLocation();
					String guuid = UUID.randomUUID().toString();
					File uploadedFile = new File(dir + File.separator + "temp"
							+ File.separator + guuid + fileType);
					item.write(uploadedFile);
					
					UploadUtil.getInstance().createRecord(guuid, fileName);
					UploadStatus satusBean = getStatusBean(request);
					satusBean.getUploadFileUrlList().add(fileName);
					satusBean.getUploadFileUuidList().add(guuid);
					saveStatusBean(request, satusBean);
					Thread.sleep(500); 
					
					// 文件格式转换
					FileChangeUtil.getInstance().convert(dir, guuid, fileType, request.getRealPath("/"));

				}
			}

		} catch (FileUploadException e) {
			uploadExceptionHandle(request, "上传文件时发生错误:" + e.getMessage());
		} catch (Exception e) {
			uploadExceptionHandle(request, "保存上传文件时发生错误:" + e.getMessage());
		}
		if (forwardURL.length() == 0) {
			forwardURL = UPLOAD_ERROR_URL;
		}
		request.getRequestDispatcher(forwardURL).forward(request, response);
	}

	/**
	 * 回应上传状态查询
	 */
	private void responseStatusQuery(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		UploadStatus satusBean = getStatusBean(request);
		response.getWriter().write(WebJsonUtils.toJson(satusBean, false));
	}

	/**
	 * 处理取消文件上传
	 */
	private void processCancelFileUpload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UploadStatus satusBean = getStatusBean(request);
		satusBean.setCancel(true);
		saveStatusBean(request, satusBean);
		responseStatusQuery(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			processFileUpload(request, response);
		} else {
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("uploadStatus") != null) {
				responseStatusQuery(request, response);
			}
			if (request.getParameter("cancelUpload") != null) {
				processCancelFileUpload(request, response);
			}

		}
	}
}
