package org.spring.hibernate.persist;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 描述：持久化基础DAO操作接口
 * 
 * @author Aaric
 *
 */
public interface BaseDao {
	
	/**
	 * 获得SessionFactory对象
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory();
	
	/**
	 * 获得Session对象
	 * 
	 * @return
	 */
	public Session getSession();
	
	/**
	 * 保存对象
	 * 
	 * @param object BPO对象
	 * @return
	 */
	public Serializable save(Object object);

}
