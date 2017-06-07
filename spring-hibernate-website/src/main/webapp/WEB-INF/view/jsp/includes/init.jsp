<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- jakarta-taglibs --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- spring-mvc-taglibs --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%-- custom-taglibs --%>
<%@ taglib uri="/tld/website" prefix="w" %>

<%-- Common Logic --%>
<%
/*Base Path*/
String basePath = request.getScheme()
		+ "://" + request.getServerName()
		+ (request.getServerPort() != 80 ? (":" + request.getServerPort()) : "")
		+ request.getContextPath()
		+ "/";
/*Initializes the variable parameter for 'basePath' */
request.setAttribute("basePath", basePath);

/* Main Domain
 * Example: ServerName=www.sample.com
 *          domainString=sample.com
 */
String domainString = request.getServerName();
if(null != domainString && -1 != domainString.indexOf(".")) {
	domainString = domainString.substring(request.getServerName().indexOf(".")+1);
} else {
	/*The development of specified*/
	domainString = "webmnt.com";
}

/* Default Language
 * *** SpringMVC Locale Strategy ***
 */
Locale sessionLocale = (Locale) session.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE");
if(null == sessionLocale) {
	/*If session is null, update from request*/
	sessionLocale = request.getLocale();
	session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", sessionLocale);
}
String locale = sessionLocale.toString();	/*zh_CN*/
locale = locale.replace("-", "_");			/*Fix Firefox Neglect*/
String language = sessionLocale.getLanguage();/*zh*/
if(null != language) {
	/*If a non-English/non-Chinese/non-Korean/non-Indonesian/non-Vietnamese/non-Thai, the default English*/
	if("zh".equals(language)/* || "in".equals(language) || "ko".equals(language) || "th".equals(language) || "vi".equals(language)*/) {
		// nothing
	} else {
		/*The English default*/
		locale = "en_US";
		language = "en";
	}
} else {
	/*The English default*/
	locale = "en_US";
	language = "en";
}
/*Initializes the variable parameter for internationalization*/
request.setAttribute("locale", locale);
request.setAttribute("language", language);
/*Castoff Language Standard*/
request.setAttribute("castoffLanguage",
		language.replace("zh", "cn")
			.replace("ko", "kr")
			.replace("in", "id")
		);
%>

<%-- Current Login User Session --%>
<c:set var="currLoginUser" value="${sessionScope.casino_login_userinfo }" />