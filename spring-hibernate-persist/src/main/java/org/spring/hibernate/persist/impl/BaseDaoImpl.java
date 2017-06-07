package org.spring.hibernate.persist.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.spring.hibernate.persist.BaseDao;

/**
 * 描述：持久化基础DAO操作实现类
 * 
 * @author Aaric
 *
 */
public final class BaseDaoImpl implements BaseDao, Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 2659673126547907011L;
	
	/**
	 * 数据库Session实例工厂
	 */
	private SessionFactory sessionFactory;

	/**
	 * 默认构造函数
	 */
	public BaseDaoImpl() {
		super();
	}

	/**
	 * 带参构造函数
	 * 
	 * @param sessionFactory 数据库Session构造对象
	 */
	public BaseDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	@Override
	public Serializable save(Object object) {
		return getSession().save(object);
	}

}
