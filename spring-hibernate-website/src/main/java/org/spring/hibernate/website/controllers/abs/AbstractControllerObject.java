package org.spring.hibernate.website.controllers.abs;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.spring.hibernate.service.singleton.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 描述：控制器Controller虚类
 * <i>所有Controller类都必须继续该类，不准许私自注入Service操作业务模块</i>
 * 
 * @author Aaric
 *
 */
public abstract class AbstractControllerObject extends ApplicationObjectSupport {
	
	/**
	 * 定义返回JSON数据返回类型常量
	 */
	public static final String HTTP_TEXT_TYPE_PLAIN_UTF_8 = "text/plain;charset=utf-8";
	
	/**
	 * 初始化日志对象
	 */
	protected Logger logger;
	
	/**
	 * 初始化ModelAndView对象
	 */
	protected ModelAndView modelAndView;
	
	/**
	 * 注入Web容器ServletContext对象
	 */
	@Autowired
	private ServletContext servletContext;
	
	/**
	 * 获得LocaleResolver对象
	 */
	@Autowired
	private LocaleResolver localeResolver;
	
	/**
	 * 注入Service操作助手对象
	 */
	@Autowired
	private ServiceHelper serviceHelper;
	
	/**
	 * 默认构造函数
	 */
	public AbstractControllerObject() {
		super();
		logger = Logger.getLogger(this.getClass());
		modelAndView = new ModelAndView();
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
	 * 获得ServletContext对象
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * 获得Service操作助手对象
	 * 
	 * @return
	 */
	public ServiceHelper getServiceHelper() {
		return serviceHelper;
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

	/**
	 * 设置Locale对象(国际化)
	 * 
	 * @param request Request对象
	 * @param response Response对象
	 * @param locale 新Locale对象
	 */
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		localeResolver.setLocale(request, response, locale);
	}
	
	/**
	 * 根据当前语言环境获得对应的国际化资源字符串
	 * 
	 * @param code 国际化资源文件键值
	 * @return
	 * @throws NoSuchMessageException
	 */
	public String getMessage(String code) throws NoSuchMessageException {
		return getMessage(code, getLocale());
	}
	
	/**
	 * 根据指定语言环境获得对应的国际化资源字符串
	 * 
	 * @param code 国际化资源文件键值
	 * @param locale 指定的语言环境对象
	 * @return
	 * @throws NoSuchMessageException
	 */
	public String getMessage(String code, Locale locale) throws NoSuchMessageException {
		return super.getApplicationContext().getMessage(code, null, locale);
	}

	/**
	 * 获得客户端真实IP地址信息
	 * 
	 * @return
	 */
	public String getClientIpAddr() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String ip = request.getHeader("Cdn-Src-Ip");
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
