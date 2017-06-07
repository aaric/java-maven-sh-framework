<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp" %>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp" %>
<html<%=xmlns %>>
<head>
<title>测试表单提交数据验证</title>
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

<body style="font-family: '宋体',Simsun;">
<div id="container">
	<sf:form commandName="person" action="${basePath }test/submit.shtml" method="POST">
		<table>
			<caption><b>
				<!-- Spring表单验证(服务端数据验证)示例 -->
				<s:message code="form.caption" />
			</b></caption>
			<tr>
				<td colspan="3">${message }</td>
			</tr>
			<tr>
				<td>
					<!-- 用户名： -->
					<s:message code="form.field.name" />
				</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>
					<!-- 密码： -->
					<s:message code="form.field.password" />
				</td>
				<td><sf:password path="password" /></td>
				<td><sf:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<!-- 提交 -->
					<input type="submit" value="<s:message code="form.field.submit" />" />
				</td>
				<td></td>
			</tr>
		</table>
	</sf:form>
</div>
</body>
</html>