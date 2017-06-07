<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp" %>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp" %>
<html<%=xmlns %>>
<head>
<title>Template</title>
<jsp:include page="/WEB-INF/view/jsp/includes/static.jsp" />
<script type="text/javascript">
	/*Add your code here.*/
	(function($){
		$(document).ready(function(){
			/*注释*/
		});
	})(jQuery);
</script>
</head>

<body>
<div id="container">
	${message }<br />
</div>
</body>
</html>