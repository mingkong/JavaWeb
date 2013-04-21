package com.lysoft.business.web.aes.common.stripes;

import net.sourceforge.stripes.action.ActionBeanContext;

import org.apache.shiro.SecurityUtils;

public class BaseActionBeanContext extends ActionBeanContext {
	public LoginUser getLoginUser(){
		String staffId = (String) SecurityUtils.getSubject().getPrincipal();
		return LoginUtils.getUser(staffId);
	}
	
	public String getUserId() {
		return (String) SecurityUtils.getSubject().getPrincipal();
	}
}
