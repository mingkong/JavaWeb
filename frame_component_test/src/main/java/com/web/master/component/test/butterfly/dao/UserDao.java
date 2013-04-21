package com.web.master.component.test.butterfly.dao;

import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.web.master.component.test.butterfly.po.UserPO;

public interface UserDao {

	Integer add(IDaos idaos, UserPO user) throws PersistenceException;

}
