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
	String serviceKey=request.getParameter("serviceKey");
	Map component=ComponentDefinitionViewUtils.getComponent(componentKey);
	request.setAttribute("component",component);
	Map<String,Object> service=ComponentDefinitionViewUtils.getService(componentKey,serviceKey);
	request.setAttribute("service",service);
	List methodDefinitions=ComponentDefinitionViewUtils.listMethods(componentKey,serviceKey);
	request.setAttribute("methodDefinitions",methodDefinitions);
%>
<div class="k-content">
<h2>你当前位置:<a href="index.jsp">component</a>:<a href="component.jsp?componentKey=${component.key}">${component.key}</a>/${service.key}
</h2>
服务描述：
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>			
				服务主键:${service.key}&nbsp;&nbsp;<br/>
				服务名:${service.name}&nbsp;&nbsp;<br/>
				远程调用支持:
				<c:choose>
						<c:when test="${service.remotable}">
							是
						</c:when>
						<c:otherwise>
							否
						</c:otherwise>
					</c:choose>
				</br>
				描述信息:${service.description}			
			</td>
		</tr>
	</table>
<table id="component_service_method_list_table" width="100%" border="1">
	<thead >
		<tr>
			<th>方法名</th>
			<th>方法描述</th>
			<th>参数类型</th>
			<th>返回值类型</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody >
	<c:if test="${fn:length(methodDefinitions)>0}">
		<c:forEach items="${methodDefinitions }" var="md" varStatus="stat">
				<tr>
					<td align="center">${md.name}</td>
					<td align="center">${md.description}</td>
					<td align="left">
						<c:if test="${fn:length(md.paramsDefintion)<=0}">
							无
						</c:if>
						<c:if test="${fn:length(md.paramsDefintion)>0}">
							<c:forEach items="${md.paramsDefintion}" var="pd" varStatus="pdstat">
								${pd.name}--${pd.type}<br/>
							</c:forEach>
						</c:if>												
					</td>
					<td align="left">
					${md.resultDefinition}
					</td>	
					<td align="left">
						<a href="method.jsp?componentKey=${component.key}&serviceKey=${service.key}&methodName=${md.name}">进入</a>
					</td>				
				</tr>		
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>		
</body>
</html>