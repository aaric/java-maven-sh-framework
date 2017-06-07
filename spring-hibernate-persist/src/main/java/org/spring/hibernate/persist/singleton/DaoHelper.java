package org.spring.hibernate.persist.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import org.spring.hibernate.persist.BaseDao;
import org.spring.hibernate.persist.FileInfoDao;

/**
 * 描述：持久化DAO助手类(单利模式)
 * 
 * @author Aaric
 *
 */
@Lazy(false)
@Scope("singleton")
@Repository("daoHelper")
public final class DaoHelper {
	
	/**
	 * 基础持久化DAO操作对象
	 */
	@Autowired
	private BaseDao baseDao;
	/**
	 * 文件信息持久化DAO操作对象
	 */
	@Autowired
	private FileInfoDao fileInfoDao;
	
	/**
	 * 获得基础持久化DAO操作对象
	 * 
	 * @return
	 */
	public BaseDao getBaseDao() {
		return baseDao;
	}
	
	/**
	 * 获得文件信息持久化DAO操作对象
	 * 
	 * @return
	 */
	public FileInfoDao getFileInfoDao() {
		return fileInfoDao;
	}

}
