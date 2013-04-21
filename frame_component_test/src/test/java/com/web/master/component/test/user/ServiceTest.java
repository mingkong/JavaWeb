package com.web.master.component.test.user;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lysoft.framework.common.service.ResponseObject;
import com.lysoft.framework.common.service.ServiceUtils;
import com.lysoft.framework.platform.junit.JUnitTestCaseUtils;
import com.web.master.component.test.common.TimeUtil;

public class ServiceTest {
	@Before
	public void setUp() throws Exception{
		JUnitTestCaseUtils.initJUnitEnv();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void add(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userKey", "10001");
		params.put("userName", "www");
		params.put("password", "www");
		params.put("ownDepartmentKey", "10002");
		params.put("phone", "");
		params.put("mainQq", "10000");
		params.put("type", "0");
		params.put("sex", "1");
		params.put("idcard", "");
		params.put("birthDate", "1988-04-19");
		params.put("status", "0");
		params.put("updateTime", TimeUtil.now());
		params.put("dflag", "0");
		ResponseObject result = ServiceUtils.invoke("component:test/user","add_user", params);
		System.out.println(result.getResult());
	}
}
