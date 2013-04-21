<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%><% 	
%>
<%@ page import="java.io.*,java.util.*"%>
系统发生异常，请联系管理员，异常信息如下：<hr/>
<div style="height: 100%; ">
<%
String errMsg=(String)request.getAttribute("_url_response_error_message");
if(errMsg!=null){
	out.println(errMsg);
}
%>
</div>