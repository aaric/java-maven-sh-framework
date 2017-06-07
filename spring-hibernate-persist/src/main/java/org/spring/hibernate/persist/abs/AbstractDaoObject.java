package org.spring.hibernate.persist.abs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.spring.hibernate.persist.BaseDao;

/**
 * 描述：持久层DAO虚类
 * 
 * @author Aaric
 *
 */
public abstract class AbstractDaoObject {
	
	/**
	 * 初始化日志对象
	 */
	protected Logger logger;
	
	/**
	 * 基础DAO实例
	 */
	@Autowired
	protected BaseDao baseDao;

	/**
	 * 默认构造函数
	 */
	public AbstractDaoObject() {
		super();
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * 获得DAO实例
	 * 
	 * @return
	 */
	public BaseDao getBaseDao() {
		return baseDao;
	}

}
