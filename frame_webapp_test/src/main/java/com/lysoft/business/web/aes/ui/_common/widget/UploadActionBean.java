package com.lysoft.business.web.aes.ui._common.widget;

import java.util.Map;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.lysoft.business.web.aes.common.stripes.BasicActionBean;
import com.lysoft.web.stripes.executor.ActionLogicExecutor;
import com.lysoft.web.stripes.executor.BasicActionCallBack;

@UrlBinding("/common/widget/upload.do")
public class UploadActionBean extends BasicActionBean {

	@DefaultHandler
	public Resolution lever() {
		return new ActionLogicExecutor().execute(new BasicActionCallBack(){
			@Override
			public Map<String, Object> preHandle() throws Exception {
				return null;
			}
			
			@Override
			public Resolution postHandle(Map<String, Object> params, Object result)
					throws Exception {
				return new ForwardResolution(UI_ROOT_PREFIX
						+ "/_common/widget_upload_main.jsp");
			}			
		});
	}
}
