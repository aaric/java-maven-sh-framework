package org.spring.hibernate.website.interceptors.abs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.spring.hibernate.service.singleton.ServiceHelper;

/**
 * 描述：拦截器虚类
 * 
 * @author Aaric
 *
 */
public abstract class AbstractInterceptorObject extends
		HandlerInterceptorAdapter {
	
	/**
	 * 初始化日志对象
	 */
	protected Logger logger;
	
	/**
	 * 注入Service操作助手对象
	 */
	@Autowired
	private ServiceHelper serviceHelper;

	/**
	 * 默认构造函数
	 */
	public AbstractInterceptorObject() {
		super();
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * 获得Service操作助手对象
	 * 
	 * @return
	 */
	public ServiceHelper getServiceHelper() {
		return serviceHelper;
	}

}
