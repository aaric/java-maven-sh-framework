<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp" %>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp" %>
<html<%=xmlns %>>
<head>
<title>clientip</title>
<jsp:include page="/WEB-INF/view/jsp/includes/static.jsp" />
<script type="text/javascript">
	/*Add your code here.*/
	(function($){
		$(document).ready(function(){
			/*提示测试*/
			$("#tips").click(function(){
				$.dialog.tips("提示：小心你的钱包！");
			});
		});
	})(jQuery);
</script>
</head>

<body>
<div id="container">
    Your Client Ip: <br />
    ${message }
    <br />
    <br />
    <br />
    <br />
    <br />
    <button id="tips">点击提示</button>
</div>
</body>
</html>
