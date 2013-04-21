package com.lysoft.business.web.aes.ui;

import java.util.Map;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.lysoft.business.web.aes.common.stripes.BasicActionBean;
import com.lysoft.web.stripes.executor.ActionLogicExecutor;
import com.lysoft.web.stripes.executor.BasicActionCallBack;

@UrlBinding("/index.do")
public class IndexActionBean extends BasicActionBean {
	
	@DefaultHandler
	public Resolution index() {
		return new ActionLogicExecutor().execute(new BasicActionCallBack(){
			@Override
			public Map<String, Object> preHandle() throws Exception {
				return null;
			}
			
			@Override
			public Resolution postHandle(Map<String, Object> params, Object result)
					throws Exception {
				return new ForwardResolution(UI_ROOT_PREFIX + "/index.jsp");
			}			
		});		
	}
}