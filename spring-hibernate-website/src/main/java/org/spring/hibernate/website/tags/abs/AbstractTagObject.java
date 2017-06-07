package org.spring.hibernate.website.tags.abs;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 描述：自定义标签虚类
 * <i>自定义标签必须继承该虚类，获得数据库访问权限或者其他权限</i>
 * 
 * @author Aaric
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractTagObject extends TagSupport {
	
	/**
	 * 初始化日志对象
	 */
	protected Logger logger;

	public AbstractTagObject() {
		super();
		logger = Logger.getLogger(this.getClass());
	}
	
	/**
	 * 获得HttpServletRequest对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * 获得Locale对象(国际化)
	 * 
	 * @return
	 */
	public Locale getLocale() {
		Locale returnValue = (Locale) getRequest().getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if(null == returnValue) {
			returnValue = getRequest().getLocale();
			getRequest().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, returnValue);
		}
		return returnValue;
	}

	@Override
	public abstract int doStartTag() throws JspException;

}
