package org.spring.hibernate.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：IP工具类
 * 
 * @author Aaric
 *
 */
public final class IpUtils {
	
	/**
	 * 私有构造函数
	 */
	private IpUtils() {
		super();
	}

	/**
	 * 获得客户端真实IP地址信息
	 * 
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("Cdn-Src-Ip");
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(ip)
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
