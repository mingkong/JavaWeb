package com.web.master.component.test.service.user;

import java.util.Map;

import com.jenkov.common.result.ButterflyPagedResult;
import com.jenkov.db.itf.IDaos;
import com.jenkov.template.JdbcCallback;
import com.lysoft.component.service.AbstractServiceInvoker;
import com.lysoft.component.service.InvokeAnnotation;
import com.lysoft.component.utils.ComponentBeanUtils;
import com.lysoft.framework.core.service.method.params.ValueType;
import com.web.master.component.test.butterfly.dao.UserDao;
import com.web.master.component.test.butterfly.dao.impl.UserDaoImpl;
import com.web.master.component.test.butterfly.po.UserPO;

public class UserService extends AbstractServiceInvoker {
	
	private UserDao userDao = new UserDaoImpl(); 
	
	@InvokeAnnotation(name = "add_user", 
			paramsName = { "params" }, 
			paramsType = { ValueType.MAP}, 
			returnType = ValueType.JSON)
	public Integer add_user(Map<String , Object> params) {
		final UserPO user = ComponentBeanUtils.cloneToBean(params, UserPO.class);
		return getInitializer().getButterflyTemplate().execute(new JdbcCallback<Integer>() {
			@Override
			public Integer doInConnection(IDaos idaos) throws Exception {
				return userDao.add(idaos, user);
			}
		});
	}
	
	@InvokeAnnotation(name = "page_user", 
			paramsName = { "params" }, 
			paramsType = { ValueType.MAP}, 
			returnType = ValueType.JSON)
	public ButterflyPagedResult<Map<String,Object>> page_user(final Map<String , Object> params) {
		 return getInitializer().getButterflyTemplate().execute(new 
				 JdbcCallback<ButterflyPagedResult<Map<String, Object>>>() {
			@Override
			public ButterflyPagedResult<Map<String,Object>> doInConnection(IDaos idaos)
				throws Exception {
				return null;
			}
		});
	}
}