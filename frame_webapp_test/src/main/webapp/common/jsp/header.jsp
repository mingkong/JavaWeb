<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
<script type="text/javascript">
	var __ctxPath="${pageContext.request.contextPath}";
</script>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/favicon.ico">
<script type="text/javascript" src="${initParam.__public}/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${initParam.__public}/kendo_ui/js/kendo.web.min.js"></script>
<script type="text/javascript" src="${initParam.__public}/kendo_ui/js/cultures/kendo.culture.zh-CN.min.js"></script>
<link rel="stylesheet" href="${initParam.__public}/kendo_ui/styles/kendo.common.min.css" />
<link rel="stylesheet" href="${initParam.__public}/kendo_ui/styles/kendo.blueopal.min.css" />
<script type="text/javascript" src="${initParam.__public}/jquery/loader.js"></script>
<script type="text/javascript" src="${initParam.__public}/kendo_ui/js/kendoutils.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/init.js" ></script>
<script type="text/javascript">
kendo.culture("zh-CN");
$.ajaxSetup({
	cache: false,
	error: function(xhr, textStatus){	//jquery .ajax请求错误统一处理方式		    	
		if(xhr.status!=200){
			var contextStr;
		    if(xhr.status==401||xhr.status==403||xhr.status==405||xhr.status==406||xhr.status==500){
		    	contextStr=xhr.responseText;        
		    }else if(xhr.status==0){
		    	contextStr="服务器无响应,请联系管理员！";       
		    }else{
		    	contextStr="警告','连接服务器失败,请重试！";        
		    } 
		    if($("#ajax_error_alert_div").length<=0){
				$(document.body).append("<div id='ajax_error_alert_div'></div>");
			}
		    $("#ajax_error_alert_div").html(contextStr);
		    var height = $("#ajax_error_alert_div").height();
		    var hstr = height > 400 ? "400px" : "auto";
		    var errorWin=$("#ajax_error_alert_div");
		    if(!errorWin.data("kendoWindow")){
		    	$("#ajax_error_alert_div").kendoWindow({
		    	 	draggable: false,
		    	    height: hstr,
		    	    modal: true,
		    	    resizable: false,
		    	    title: "请求错误",
		    	    width: "400px",
		    	    animation:false
		    	});
		    	errorWin.data("kendoWindow").center();
		    	errorWin.data("kendoWindow").open();
		    } else{
		    	errorWin.data("kendoWindow").open();
		    }
		}
	}
});
</script>
<style>
html {
	height: 100%;
	color: #000;
	background: #fff;
	min-height: 100%;
	overflow-y: auto;
	font: 75% arial, helvetica, sans-serif;
	margin: 0;
	padding: 0;
}

body {
	height: 100%;
	color: #000;
	background: #fff;
	min-height: 100%;
	margin: 0;
	padding: 0;
}

h1,h2 {
	margin: 0;
	padding: 0;
}

h1 {
	margin: 0px;
	height: 30px;
	line-height: 20px;
	font-size: 12px;
	cursor: pointer;
}

a img {
	border: 0;
}

a {
	text-decoration: none;
}

textarea.selector,input.selector {
	background-color: #F2F2F2;
}

textarea.selector:hover,input.selector:hover {
	background-color: #FFF2F2;
}
/*****k table*****/
.k-wt-table {
	border-style: solid;
	border-color: #94C0D2;
	border-width: 1px 0px 0px 1px;
}

.k-wt-table .k-wt-header {
	background: #DAECF4;
	border-style: solid;
	border-color: #94C0D2;
	border-width: 0px 1px 1px 0px;
	padding: 0.5em 0.6em 0.4em;
	text-align: left;
}

.k-wt-table .k-wt-title {
	background: #fff;
	border-style: solid;
	border-color: #94C0D2;
	border-width: 0px 1px 1px 0px;
	padding: 0.5em 0.6em 0.4em;
	text-align: left;
}

.k-wt-table .k-wt-content {
	background: #fff;
	border-style: solid;
	border-color: #94C0D2;
	border-width: 0px 1px 1px 0px;
	padding: 0.5em 0.6em 0.4em;
	text-align: left;
}

.k-wt-table .k-wt-footer {
	background: #fff;
	border-style: solid;
	border-color: #94C0D2;
	border-width: 0px 1px 1px 0px;
	padding: 0.5em 0.6em 0.4em;
	text-align: left;
}

.k-search {
	padding-bottom: 2px;
	padding-top: 2px;
}

.chat-bar {
	background: #DBD8F9;
	border: 1px solid #95B8E7;
	border-bottom: none;
	bottom: 0;
	height: 24px;
	position: fixed;
	padding-left: 15px;
	padding-right: 15px;
	padding-top: 5px;
	z-index: 1000;
	width: 100%;
}
</style>