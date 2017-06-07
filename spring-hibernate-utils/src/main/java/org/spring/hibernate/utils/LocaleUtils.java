package org.spring.hibernate.utils;

import java.util.Locale;

/**
 * 描述：Local国际化工具类
 * 
 * @author Aaric
 *
 */
public final class LocaleUtils {
	
	/**
	 * 将传统国际化字符串转换为标准国际化对象
	 * 示例：zh to zh_CN
	 * 
	 * @param language
	 */
	private static Locale convTraditionToSTDLocale(String language) {
		/*默认简体中文*/
		Locale returnValue = new Locale("en", "US");
		
		/*字符串基本判断*/
		if (null != language) {
			language = language.trim();
			if ("zh".equals(language)) {
				returnValue = new Locale("zh", "CN");
			}/* else if("in".equals(language)) {
				returnValue = new Locale("in", "ID");
			} else if("ko".equals(language)) {
				returnValue = new Locale("ko", "KR");
			} else if("th".equals(language)) {
				returnValue = new Locale("th", "TH");
			} else if("vi".equals(language)) {
				returnValue = new Locale("vi", "VN");
			}*/
			
		}
		
		
		return returnValue;
	}
	
	/**
	 * 兼容旧遗留的国际化，同时支持JAVA标准国际化
	 * 
	 * @param language
	 * @param locale
	 * @return
	 */
	public static Locale parse(String language, String locale) {
		/*初始化相关参数*/
		Locale returnValue = null;
		
		/*支持JAVA标准国际化*/
		if (null != locale && !"".equals(locale.trim())) {
			String[] localeStrings = locale.trim().split("_");
			if (2 == localeStrings.length) {
				returnValue = new Locale(localeStrings[0], localeStrings[1]);
			} else {
				/*非标准国际化转换为JAVA标准国际化对象*/
				returnValue = convTraditionToSTDLocale(localeStrings[0]);
			}
			
		} else {
			/*字符串基本判断*/
			if (null == language || "".equals(language.trim())) {
				language = "zh";
			}
			/*兼容旧遗留的国际化*/
			language = language.replace("cn", "zh");	/*不规范的简体中文*/
			language = language.replace("kr", "ko");	/*不规范的韩语*/
			language = language.replace("id", "in");	/*不规范的印尼语*/
			/*非标准国际化转换为JAVA标准国际化对象*/
			returnValue = convTraditionToSTDLocale(language);
			
		}
		
		return returnValue;
	}

}
