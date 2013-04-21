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

</script>
</head>
<body>
<%
	String componentKey=request.getParameter("componentKey");
	Map component=ComponentDefinitionViewUtils.getComponent(componentKey);
	request.setAttribute("component",component);
	List<Map<String,Object>> services=ComponentDefinitionViewUtils.listServices(componentKey);
	request.setAttribute("services",services);
%>
<div>
<h2>你当前位置:<a href="index.jsp">component</a>:${component.key}
</h2>
组件信息:	
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			组件主键:${component.key}<br/>
			组件名:${component.name}<br/>
			描述信息:${component.description}			
		</td>
	</tr>
</table>
<table id="component_service_list_table" width="100%" border="1">
	<thead >
		<tr>
			<th >服务主键</th>
			<th >服务名称</th>
			<th >远程调用支持</th>
			<th >数量</th>
			<th >描述</th>			
			<th >操作</th>
		</tr>
	</thead>
	<tbody >
	<c:if test="${fn:length(services)>0}">
		<c:forEach items="${services }" var="sp" varStatus="stat">
				<tr>
					<td align="left" >${sp.key}</td>
					<td align="center" >${sp.name}</td>
					<td align="center" >
					<c:choose>
						<c:when test="${sp.remotable}">
							是
						</c:when>
						<c:otherwise>
							否
						</c:otherwise>
					</c:choose>					
					</td>
					<td align="center" >${sp.methodCount}</td>
					<td align="center">${sp.description}</td>
					<td align="center"><a href="service.jsp?componentKey=${component.key}&serviceKey=${sp.key}">进入</a></td>					
				</tr>		
		</c:forEach>
	</c:if>	
	</tbody>
</table>	
</div>		
</body>
</html>