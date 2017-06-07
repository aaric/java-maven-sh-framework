<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
/*Appoint HTML5 or XHTML 1.0*/
boolean isHtml5 = false;

/*Declare html doctype links.*/
String xmlns = "";
if(!isHtml5) {
	xmlns = " xmlns=\"http://www.w3.org/1999/xhtml\"";
	out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
} else {
	out.print("<!DOCTYPE html>");
}
%>