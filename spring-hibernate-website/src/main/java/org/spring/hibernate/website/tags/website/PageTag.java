package org.spring.hibernate.website.tags.website;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.spring.hibernate.website.tags.abs.AbstractTagObject;

/**
 * 
 * @author Aaric
 *
 */
@SuppressWarnings("serial")
public class PageTag extends AbstractTagObject {
	
	/**
	 * 分页跳转地址
	 */
	private String actionPath;
	/**
	 * 查询记录总数
	 */
	private Integer totalRecords = 0;
	/**
	 * 当前页码
	 */
	private Integer currPage = 1;
	/**
	 * 分页大小
	 */
	private Integer pageSize = 15;
	/**
	 * 表单ID信息
	 */
	private String formId;
	/**
	 * 默认请求参数“currPage”的变量名
	 */
	private String defaultCurrPageName;
	/**
	 * 默认请求参数“pageSize”的变量名
	 */
	private String defaultPageSizeName;
	
	@Override
	public int doStartTag() throws JspException {
		/*初始化相关对象*/
		StringBuffer sb = new StringBuffer();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("languages.commons.page", super.getLocale());
		String divUUID = "w" + UUID.randomUUID();
		String separator = "?";
		if (actionPath.contains("?")) {
			separator = "&";
		}
		if (null == defaultCurrPageName || "".equals(defaultCurrPageName.trim())) {
			defaultCurrPageName = "currPage";
		}
		if (null == defaultPageSizeName || "".equals(defaultPageSizeName.trim())) {
			defaultPageSizeName = "pageSize";
		}
		
		/*测试输出变量*/
//		logger.debug("=^=^==^=^==^=^= WEBSITE-PAGETAG =^=^==^=^==^=^=");
//		logger.debug("--actionPath: " + actionPath);
//		logger.debug("--totalRecords:　" + totalRecords);
//		logger.debug("--currPage: " + currPage);
//		logger.debug("--pageSize: " + pageSize);
//		logger.debug("--formId: " + formId);
		
		sb.append("<div id=\"" + divUUID + "\" class=\"webpage\">");
		sb.append("<span>" + resourceBundle.getString("commons.page.the") + "&nbsp;</span>");
		sb.append("<font class=\"page-index\" style=\"color: red;\">" + currPage + "</font>");
		sb.append("<span>&nbsp;/&nbsp;</span>");
		sb.append("<font class=\"page-total\">" + (totalRecords/pageSize+1) + "</font>");
		sb.append("<span>&nbsp;" + resourceBundle.getString("commons.page.page") + "</span>");
		sb.append("<span>&nbsp;&nbsp;</span>");
		sb.append("<span>" + resourceBundle.getString("commons.page.page.number") + "</span>");
		sb.append("<span>");
		sb.append("<select class=\"page-select\">");
		
		/************************* SELECT-OPTIONS *************************/
		for (int i = 1, n = totalRecords/pageSize+1; i <= n; i++) {
			if (currPage == i) {
				sb.append("<option selected=\"selected\" value=\"" + i + "\">" + i + "</option>");
			} else {
				sb.append("<option value=\"" + i + "\">" + i + "</option>");
			}
		}
		/************************* SELECT-OPTIONS *************************/
		
		sb.append("</select>");
		sb.append("</span>");
		sb.append("<span>&nbsp;&nbsp;</span>");
		sb.append("<span>");
		sb.append("<span class=\"page-first\"></span>");
		sb.append("<span class=\"page-prev\"></span>");
		sb.append("<span class=\"page-next\"></span>");
		sb.append("<span class=\"page-end\"></span>");
		sb.append("</span>");
		sb.append("<script type=\"text/javascript\">");
		
		/************************* JAVASCRIPT *************************/
		sb.append("(function($){");
		sb.append("$(document).ready(function(){");
		sb.append("var index = parseInt($('#" + divUUID + " .page-index:first').text());");
		sb.append("var total = parseInt($('#" + divUUID + " .page-total:first').text());");
		sb.append("var formArgs = $('#" + formId + "').serialize();");
		sb.append("if(null != formArgs && '' != formArgs) { formArgs = '&' + formArgs; } else { formArgs = ''; }");
		sb.append("$('#" + divUUID + " .page-select').change(function(){");
		sb.append("var skipIndex = parseInt($(this).val());");
		sb.append("var dealUrl = '" + actionPath + separator + defaultPageSizeName + "=" + pageSize + "';");
		sb.append("dealUrl += '&" + defaultCurrPageName + "=' + skipIndex;");
		if (null != formId && !"".equals(formId.trim())) {
			sb.append("dealUrl += formArgs;");
		}
		sb.append("window.location.assign(dealUrl);");
		sb.append("});");
		
		sb.append("$('#" + divUUID + " .page-first').click(function(){");
		sb.append("var dealUrl = '" + actionPath + separator + defaultPageSizeName + "=" + pageSize + "';");
		sb.append("dealUrl += '&" + defaultCurrPageName + "=1';");
		if (null != formId && !"".equals(formId.trim())) {
			sb.append("dealUrl += formArgs;");
		}
		sb.append("window.location.assign(dealUrl);");
		sb.append("});");
		
		sb.append("$('#" + divUUID + " .page-prev').click(function(){");
		sb.append("var skipIndex = index - 1;");
		sb.append("if(0 >= skipIndex || skipIndex > total) {");
		sb.append("skipIndex = 1;");
		sb.append("}");
		sb.append("var dealUrl = '" + actionPath + separator + defaultPageSizeName + "=" + pageSize + "';");
		sb.append("dealUrl += '&" + defaultCurrPageName + "=' + skipIndex;");
		if (null != formId && !"".equals(formId.trim())) {
			sb.append("dealUrl += formArgs;");
		}
		sb.append("window.location.assign(dealUrl);");
		sb.append("});");
		
		sb.append("$('#" + divUUID + " .page-next').click(function(){");
		sb.append("var skipIndex = index + 1;");
		sb.append("if(0 >= skipIndex || skipIndex > total) {");
		sb.append("skipIndex = total;");
		sb.append("}");
		sb.append("var dealUrl = '" + actionPath + separator + defaultPageSizeName + "=" + pageSize + "';");
		sb.append("dealUrl += '&" + defaultCurrPageName + "=' + skipIndex;");
		if (null != formId && !"".equals(formId.trim())) {
			sb.append("dealUrl += formArgs;");
		}
		sb.append("window.location.assign(dealUrl);");
		sb.append("});");
		
		sb.append("$('#" + divUUID + " .page-end').click(function(){");
		sb.append("var dealUrl = '" + actionPath + separator + defaultPageSizeName + "=" + pageSize + "';");
		sb.append("dealUrl += '&" + defaultCurrPageName + "=' + total;");
		if (null != formId && !"".equals(formId.trim())) {
			sb.append("dealUrl += formArgs;");
		}
		sb.append("window.location.assign(dealUrl);");
		sb.append("});");
		sb.append("});");
		sb.append("})(jQuery);");
		/************************* JAVASCRIPT *************************/
		
		sb.append("</script>");
		sb.append("</div>");
		
		/**
		 * 构建字符串(HTML文本)，并输出到页面显示
		 */
		try {
			/*获得JspWriter对象，输出信息到页面*/
			JspWriter out = pageContext.getOut();
			out.print(sb.toString());
			
		} catch (IOException e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}

	public String getActionPath() {
		return actionPath;
	}

	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getDefaultCurrPageName() {
		return defaultCurrPageName;
	}

	public void setDefaultCurrPageName(String defaultCurrPageName) {
		this.defaultCurrPageName = defaultCurrPageName;
	}

	public String getDefaultPageSizeName() {
		return defaultPageSizeName;
	}

	public void setDefaultPageSizeName(String defaultPageSizeName) {
		this.defaultPageSizeName = defaultPageSizeName;
	}

}
