<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp"%>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp"%>
<html <%=xmlns%>>
<head>
<title>404错误页面</title><!--STATUS OK-->
<link rel="icon" type="image/png" href="${basePath }favicon.png" />
<link rel="shortcut icon" type="image/vnd.microsoft.icon" href="${basePath }favicon.ico" />
<!--[if IE]>
<SCRIPT type=text/javascript>(function(){var a="abbr,article,aside,audio,canvas,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(","),b=a.length;while(b--)document.createElement(a[b])})();</SCRIPT>
<![endif]-->
<!--[if (lt IE 8.0)]><LINK href="files/qbase.css" type=text/css 
rel=stylesheet><![endif]--><!--[if (!IE)|(gte IE 8.0)]><!-->
<link href="<%=basePath %>plugins/errorpage/qbase_datauri.css?v=@STYLE_VERSION@" type=text/css rel=stylesheet><!--<![endif]-->
<style type=text/css>.mod-notfound {
	BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 585px; TEXT-ALIGN: center; border-radius: 10px
}
</style>
<META content="MSHTML 6.00.6000.17117" name=GENERATOR>
</head>
<body>
<%-- <fmt:bundle basename="">
	<fmt:message key="" />
</fmt:bundle> --%>
	<section class=mod-page-body>
		<div class="mod-page-main wordwrap clearfix">
			<div class=x-page-container>
				<div class="mod-notfound grid-98">
					<IMG class=img-notfound height=320
						src="<%=basePath%>plugins/errorpage/notfound.gif" width=520>
					<p style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">
						啊~哦~ 您要查看的页面不存在或已删除！</p>
					<p style="MARGIN-BOTTOM: 30px">请检查您输入的网址是否正确，或者刷新重试</p>
					<p style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">
						您可以回到 <a href="<%=request.getScheme() %>://www.<%=domainString %>/index.shtml?language=${castoffLanguage }">网站首页</a>
					</p>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
