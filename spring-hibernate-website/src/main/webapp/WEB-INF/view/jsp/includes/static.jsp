<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- spring-mvc-locale --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%-- Common Meta Tags --%>
<meta name="robots" content="noindex,nofollow" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="关键字" />
<meta http-equiv="description" content="描述" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%-- Common Style And JavaScript --%>
<!-- style links example
<link rel="stylesheet" type="text/css" href="${basePath }css/style.css?v=@STYLE_VERSION@" />
 -->
<link rel="icon" type="image/png" href="${basePath }favicon.png" />
<link rel="apple-touch-icon" type="image/png" href="${basePath }favicon.png">
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="${basePath }favicon.ico" />
<link rel="stylesheet" type="text/css" href="${basePath }plugins/common/webpage.css?v=@STYLE_VERSION@" />
<script type="text/javascript" src="${basePath }plugins/jquery/jquery.min.js?v=@SCRIPT_VERSION@"></script>
<script type="text/javascript" src="${basePath }plugins/jquery/i18n/jquery.i18n.js?v=@SCRIPT_VERSION@"></script>
<script type="text/javascript" src="${basePath }plugins/lhgdialog/lhgdialog.min.js?self=true&skin=default&v=@SCRIPT_VERSION@"></script>
<script type="text/javascript">
	/*Note: JS global path and global locale.*/
	var globalJSPath = '${basePath }';
	var globalLocale = '${locale }';
	/*lhgdialog*/
	(function(config){
		config['title'] = '<s:message code="commons.lhgdialog.title" />';
		config['okVal'] = '<s:message code="commons.lhgdialog.ok.val" />';
		config['cancelVal'] = '<s:message code="commons.lhgdialog.cancel.val" />';
		config['alertTitleVal'] = '<s:message code="commons.lhgdialog.alert.title.val" />';
		config['confirmTitleVal'] = '<s:message code="commons.lhgdialog.confirm.title.val" />';
		config['promptTitleVal'] = '<s:message code="commons.lhgdialog.prompt.title.val" />';
	})($.dialog.setting);
</script>
