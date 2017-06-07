package org.spring.hibernate.service.abs;

import org.apache.log4j.Logger;
import org.spring.hibernate.persist.singleton.DaoHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述：业务操作Service虚类
 * 
 * @author Aaric
 *
 */
public abstract class AbstractServiceObject {
	
	/**
	 * 初始化日志对象
	 */
	protected Logger logger;
	
	/**
	 * 持久化DAO助手对象
	 */
	@Autowired
	private DaoHelper daoHelper;

	/**
	 * 默认构造函数
	 */
	public AbstractServiceObject() {
		super();
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * 获得持久化DAO助手对象
	 * 
	 * @return
	 */
	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

}
