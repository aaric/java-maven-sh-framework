<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/includes/init.jsp" %>
<%@ include file="/WEB-INF/view/jsp/includes/doctype.jsp" %>
<html<%=xmlns %>>
<head>
<title>index-${locale }</title>
<jsp:include page="/WEB-INF/view/jsp/includes/static.jsp" />
<script type="text/javascript" src="<%=basePath %>resources/js/test/index.js?v=@SCRIPT_VERSION@"></script>
<script type="text/javascript">
	/*Add your code here.*/
	(function($){
		$(document).ready(function(){
			/*注释*/
			$("#selectLanguage").val($("#${locale }").val());
			$("#selectLanguage").change(function(){
				window.location.assign($(this).val());
			});
			
			// 对话框国际化
			$.dialog.tips('数据加载完毕！', 1, 'tips.gif', function(){
				$.dialog.confirm('你确定要取消操作吗？', function(){
					$.dialog.tips('系统刚刚取消了你的操作！');
				}, function(){
					$.dialog.alert('确定开始执行操作，可能需要很长时间？', function(){
						$.dialog.tips('执行完毕！');
					});
				});
			});
			
		});
	})(jQuery);
</script>
</head>

<body>
<div id="container">
	<span>国际化测试文本：</span>
	<s:message code="language.name" />
	<br />
	<br />
	<select id="selectLanguage">
		<option id="en_US" value="<%=basePath %>test/index.shtml?<%--language=en&--%>locale=en_US">英文</option>
		<option id="zh_CN" value="<%=basePath %>test/index.shtml?<%--language=zh&--%>locale=zh_CN">简体中文</option>
		<option id="ko_KR" value="<%=basePath %>test/index.shtml?<%--language=ko&--%>locale=ko_KR">韩语</option>
		<option id="in_ID" value="<%=basePath %>test/index.shtml?<%--language=in&--%>locale=in_ID">印尼语</option>
		<option id="vi_VN" value="<%=basePath %>test/index.shtml?<%--language=vi&--%>locale=vi_VN">越南语</option>
		<option id="th_TH" value="<%=basePath %>test/index.shtml?<%--language=th&--%>locale=th_TH">泰语</option>
	</select>
	<br />
	<br />
	<button id="btnChLang">测试JS国际化插件</button>
	<br />
	<br />
	<br />
	<br />
	<form id="formId" action="#">
		<input type="text" name="username" value="root" />
		<input type="text" name="password" value="123456" />
	</form>
	<w:page actionPath="${basePath }test/submit.shtml?test=123"
		totalRecords="125"
		currPage="5"
		pageSize="15"
		formId="formId"
		defaultCurrPageName="currPage1"
		defaultPageSizeName="pageSize1" />
	<br />
	<br />
	<br />
	<span>super.getMessage("language.name")-->${languageName }</span>
</div>
</body>
</html>