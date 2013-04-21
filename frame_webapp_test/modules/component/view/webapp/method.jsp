<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" 
	import="java.util.*,com.lysoft.modules.component.view.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-UTF-8">
<title>浏览组件定义</title>
<script type="text/javascript" src="/common/js/mootools-core-1.4.5-full-nocompat-yc.js"></script>
<script type="text/javascript" src="/common/js/mootools-more-1.4.0.1.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
</script>
</head>
<body>
<%
	String componentKey=request.getParameter("componentKey");
	String serviceKey=request.getParameter("serviceKey");
	String methodName=request.getParameter("methodName");
	Map component=ComponentDefinitionViewUtils.getComponent(componentKey);
	request.setAttribute("component",component);
	Map<String,Object> service=ComponentDefinitionViewUtils.getService(componentKey,serviceKey);
	request.setAttribute("service",service);
	Object methodDefinition=ComponentDefinitionViewUtils.getMethod(componentKey,serviceKey,methodName);
	request.setAttribute("methodDefinition",methodDefinition);
%>
<div >
<h2>你当前位置:<a href="index.jsp">component</a>:<a href="component.jsp?componentKey=${component.key}">${component.key}</a>/<a href="service.jsp?componentKey=${component.key}&serviceKey=${service.key}">${service.key}</a></h2>
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top">方法名:</td>
		<td valign="top">
			${methodDefinition.name}
		
	</tr>
	<tr>	
		<td valign="top">方法描述:</td>	
		<td valign="top">
			${methodDefinition.description}
		</td>
	</tr>
	<tr>		
		<td valign="top">方法参数:</td>
		<td valign="top">
			<c:if test="${fn:length(methodDefinition.paramsDefintion)<=0}">
				无
			</c:if>
			<c:if test="${fn:length(methodDefinition.paramsDefintion)>0}">
					<c:forEach items="${methodDefinition.paramsDefintion}" var="pd" varStatus="pdstat">
								${pd.name}--${pd.type}<br/>
					</c:forEach>
			</c:if>		
		</td>
	</tr>
	<tr>		
		<td valign="top">方法返回值:</td>
		<td valign="top">
			${methodDefinition.resultDefinition}		
		</td>
	</tr>
	<tr>		
		<td valign="top">参数描述：</td>
		<td valign="top">
				${methodDefinition.paramsDesc}&nbsp;		
		</td>
	</tr>
	<tr>		
		<td valign="top">返回值描述：</td>
		<td valign="top">
				${methodDefinition.resultDesc}&nbsp;	
		</td>
	</tr>	
</table>
</div>		
</body>
</html>