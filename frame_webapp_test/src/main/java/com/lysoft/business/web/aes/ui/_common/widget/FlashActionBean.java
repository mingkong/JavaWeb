package com.lysoft.business.web.aes.ui._common.widget;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.lysoft.business.web.aes.common.stripes.BasicActionBean;
import com.lysoft.business.web.aes.common.upload.UploadUtil;
import com.lysoft.business.web.aes.ui._common.utils.MimeTypesUtil;
import com.lysoft.web.stripes.executor.ActionLogicExecutor;
import com.lysoft.web.stripes.executor.BasicActionCallBack;

@UrlBinding("/_common/widget/flash.do")
public class FlashActionBean extends BasicActionBean{
	private String guuid;
	private String fid;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getGuuid() {
		return guuid;
	}

	public void setGuuid(String guuid) {
		this.guuid = guuid;
	}
	
	@DefaultHandler
	public Resolution index() {
		return new ActionLogicExecutor().execute(new BasicActionCallBack(){
			@Override
			public Map<String, Object> preHandle() throws Exception {
				return null;
			}
			
			@Override
			public Resolution postHandle(Map<String, Object> params, Object result)	throws Exception {	
				return new ForwardResolution(UI_ROOT_PREFIX + "/_common/flash_preview.jsp");
			}			
		});
	}
		
	@HandlesEvent("preview")
	public Resolution previewDocument() {
		return new ActionLogicExecutor().execute(new BasicActionCallBack(){
			@Override
			public Map<String, Object> preHandle() throws Exception {
				return null;
			}
			
			@Override
			public Resolution postHandle(Map<String, Object> params, Object result)
					throws Exception {
				String fileUUIDName = fid;
				String filePath = UploadUtil.getInstance().getLocation();
				String fileName = filePath + File.separator + "swf" + File.separator + fileUUIDName + ".swf";
				File file = new File(fileName);
				InputStream fis = null;
				if(!file.exists()){
					fis = context.getRequest().getServletContext().getResourceAsStream("/common/flash/error.swf");
				} else {
					fis = new FileInputStream(file);
				}
				final InputStream is = fis;
				String contentType = MimeTypesUtil.getContentType(fileName);
				return new StreamingResolution(contentType) {
					public void stream(HttpServletResponse resp) throws Exception {
						int total = is.available();
						byte[] bs = new byte[total];
						is.read(bs);
						OutputStream os = resp.getOutputStream();
						os.write(bs);
						os.close();
					}
				}.setFilename(fileName);
			}			
		});		
	}
	
	
}
