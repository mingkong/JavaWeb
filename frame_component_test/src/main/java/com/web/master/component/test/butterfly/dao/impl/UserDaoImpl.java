package com.web.master.component.test.butterfly.dao.impl;

import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.web.master.component.test.butterfly.dao.UserDao;
import com.web.master.component.test.butterfly.po.UserPO;

public class UserDaoImpl implements UserDao {

	@Override
	public Integer add(IDaos idaos, UserPO user) throws PersistenceException {
		return idaos.getObjectDao().insert(user);
	}

}
