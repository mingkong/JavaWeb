package com.lysoft.business.web.aes.common.stripes;


public class LoginUtils {
	public static LoginUser getUser(String staffId) {
		LoginUser user = new LoginUser();
		user.setUserId(staffId);
		user.setUserName("超级管理员");
		return user;
	}
}