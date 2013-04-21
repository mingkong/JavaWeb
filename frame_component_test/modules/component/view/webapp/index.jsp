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
	List components=ComponentDefinitionViewUtils.listComponents();
	request.setAttribute("components",components);
%>
<div class="k-content">
<div id="component_main_div" class="k-content">
<div><h2>当前组件查看位置:component:</h2></div>
<table id="component_list_table" width="100%" border="1" >
	<thead >
		<tr>			
			<th>组件主键</th>
			<th>组件名称</th>
			<th>组件描述</th>
			<th>服务数量</th>
			<th>操作</th>
		</tr>
	</thead>
	<c:if test="${fn:length(components)>0}">
	<tbody >	
		<c:forEach items="${components }" var="component" varStatus="stat">
				<tr>
					<td>${component.key}</td>
					<td>${component.name}</td>
					<td>${component.description}</td>
					<td>${component.serviceCount}</td>	
					<td><a href="component.jsp?componentKey=${component.key}">进入</a></td>					
				</tr>		
		</c:forEach>	
	</tbody>
	</c:if>
	</table>
</div>
</div>		
</body>
</html>