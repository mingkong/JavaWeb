<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/jsp/header.jsp"%>
<%@include file="/common/jsp/taglibs.jsp"%>
<title>公司门户</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#main_menu").kendoMenu({
		select: function(e) {
			var url = $(e.item).attr("data-url");
			$.ajax({
	            type : "post",
	            url : url,      
	            success : function(data){
	            	$("#main_content").html(data);
	            }
	        });
		}
	});
});
</script>
</head>
<body>
<div>
	<div id="main_head">
		<div style="height:40px;padding-top:10px;">
			&nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size:24px;font-weight:bold;">管理系统</font>
		</div>
	</div>
	<div>
		<ul id="main_menu">
			<li data-url="${ctx}/test/index.do">系统管理</li>
			<li data-url="${ctx}/test/index.do">考勤管理</li>
			<li data-url="${ctx}/test/index.do">财产管理</li>
		</ul>
	</div>
	<div id="main_notice" style="background-color:#DAECE8;height:24px;"></div>
	<div id="main_content" class="k-content"></div>
	<div id="main_chatbar" class="chat-bar"></div>
</div>
</body>
</html>

