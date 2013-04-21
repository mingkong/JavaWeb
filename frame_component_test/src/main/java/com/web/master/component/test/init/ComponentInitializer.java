package com.web.master.component.test.init;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lysoft.component.init.Initializer;
import com.lysoft.component.jdbc.butterfly.ButterflyTemplate;
import com.lysoft.component.jdbc.mybatis.MyBatisTemplate;
import com.lysoft.framework.platform.common.datasource.DataSourceUtils;

public class ComponentInitializer implements Initializer {
	private static Logger logger = LoggerFactory
			.getLogger(ComponentInitializer.class);
	private MyBatisTemplate myBatisTemplate = null;
	private ButterflyTemplate butterflyTemplate = null;

	@Override
	public void init(String compnentKey, String datasourceKey) {
		logger.debug("componentKey:" + compnentKey + ", datasourceKey:"
				+ datasourceKey);
		butterflyTemplate = new ButterflyTemplate(datasourceKey);
		DataSource dataSource = DataSourceUtils.lookup(datasourceKey);
		myBatisTemplate = new MyBatisTemplate(dataSource, "mybatis-config.xml",
				ComponentInitializer.class.getClassLoader());
	}

	@Override
	public ButterflyTemplate getButterflyTemplate() {
		return butterflyTemplate;
	}

	@Override
	public MyBatisTemplate getMyBatisTemplate() {
		return myBatisTemplate;
	}

	@Override
	public void initData() {
	}
}