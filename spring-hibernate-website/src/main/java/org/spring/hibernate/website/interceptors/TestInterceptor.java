package org.spring.hibernate.website.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import org.spring.hibernate.website.interceptors.abs.AbstractInterceptorObject;

/**
 * 描述：测试拦截器
 * 
 * @author Aaric
 *
 */
public class TestInterceptor extends AbstractInterceptorObject {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
//		logger.debug("---------------操作日志拦截器---------------");
		boolean returnValue = true;
		if (handler instanceof HandlerMethod) {
			String clazzName = ((HandlerMethod) handler).getBean().getClass().getName();
			String methodName = ((HandlerMethod) handler).getMethod().getName();
//			logger.debug("--clazzName:" + clazzName);
//			logger.debug("--methodName:" + methodName);
			request.setAttribute("message", "--clazzName:" + clazzName
					+ "<br />--methodName:" + methodName);
			
			/*根据tipster.xml文件，来判断进行相关操作*/
			MethodParameter[] methodParameters = ((HandlerMethod) handler).getMethodParameters();
			if (null != methodParameters && 0 != methodParameters.length) {
				for (MethodParameter methodParameter : methodParameters) {
					System.out.println("++" + methodParameter.getParameterName());
				}
			}
			
		}
		
		return returnValue;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
//		logger.debug("---------------postHandle---------------");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception exception) throws Exception {
//		logger.debug("---------------afterCompletion---------------");
		
	}

}
