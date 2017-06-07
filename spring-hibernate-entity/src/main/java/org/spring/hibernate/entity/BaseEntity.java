package org.spring.hibernate.entity;

import org.spring.hibernate.entity.abs.AbstractBaseEntity;

/**
 * 描述：实体基础类
 * <i>实体项目包bpo和dto必须继承该父类</i>
 * <ol>
 *     <li>bpo：业务持久对象(Persist)</li>
 *     <li>dto：传输对象(View)</li>
 * </ol>
 * 
 * @author Aaric
 *
 */
public class BaseEntity extends AbstractBaseEntity {
	
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -6687448131391679246L;
	
	/**
	 * 默认分页大小
	 */
	public static final int DEFATUL_PAGESIZE = 20;

	/**
	 * 排序SQL-升序
	 */
	public static final String ORDER_ASC = "ASC";
	
	/**
	 * 排序SQL-降序
	 */
	public static final String ORDER_DESC = "DESC";
	
}
