package com.lysoft.business.web.aes.common.subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class CustomSubject {
	private Subject subject;

	public CustomSubject() {
		subject = SecurityUtils.getSubject();
	}

	public boolean isPermitted(String permission) {
		return subject.isPermitted(permission);
	}

	public boolean isPermittedAll(String... permissions) {
		return subject.isPermittedAll(permissions);
	}

	public boolean isPermittedAny(String... permissions) {
		boolean[] pb = subject.isPermitted(permissions);
		boolean result = false;
		for (int i = 0; i < pb.length; i++) {
			if (pb[i]) {
				result = true;
				break;
			}
		}
		return result;
	}

	public String getPrincipal() {
		Object obj = subject.getPrincipal();
		if (obj != null) {
			return obj.toString();
		} else {
			return null;
		}
	}
}
