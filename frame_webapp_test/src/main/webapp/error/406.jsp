<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%><% 	
%>
校验错误
<div style="height: 100%; ">
<%
String errMsg=(String)request.getAttribute("_url_response_error_message");
if(errMsg!=null){
	out.println(errMsg);
}
%>
</div>