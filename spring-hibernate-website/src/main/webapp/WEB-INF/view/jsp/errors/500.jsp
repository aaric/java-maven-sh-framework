<%@ page language="java" import="java.util.*" isErrorPage="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp"%>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp"%>
<html <%=xmlns%>>
<head>
<title>500错误页面</title><!--STATUS OK-->
<jsp:include page="/WEB-INF/view/jsp/includes/static.jsp" />
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
	<section class=mod-page-body>
		<div class="mod-page-main wordwrap clearfix">
			<div class=x-page-container>
				<div class="mod-notfound grid-98">
					<IMG class=img-notfound height=320
						src="<%=basePath%>plugins/errorpage/error.png" width=520>
					<p style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">
						啊~哦~ 抱歉，系统出错了呢！</p>
					<p style="MARGIN-BOTTOM: 30px"><%=exception.getMessage() %></p>
					<p style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">
						您可以回到 <a href="<%=request.getScheme() %>://www.<%=domainString %>/index.shtml?language=${castoffLanguage }">网站首页</a>
						或联系 <a href="#" onclick="window.open('http://kf1.learnsaas.com/chat/chatClient/chatbox.jsp?companyID=209985&configID=42106&jid=2343548243&enterurl=http%3A%2F%2Fsports%2Evinbet%2Ecom%2Fvb%2Fntop%2Ejsp&timestamp=1343473335043&pagereferrer=','servicewindow','height=640,width=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');">在线客服</a>
					</p>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
