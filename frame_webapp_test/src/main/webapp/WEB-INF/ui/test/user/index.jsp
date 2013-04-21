<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	$.NS.call(["/test", "/ui/test/user/index.js"], function() {
		this.init();
	});
});
</script>
<script type="text/x-kendo-template" id="user_template">
<a onclick="$.NS.invoke(['${pageContext.request.contextPath}','/ui/test/user/index.js','pre_update'],'#=userKey#');"
 	class="k-button k-button-icontext"><span class="k-icon k-edit"></span>修改</a>
<a onclick="$.NS.invoke(['${pageContext.request.contextPath}','/ui/test/user/index.js','pre_delete'],'#=userKey#');"
 	class="k-button k-button-icontext"><span class="k-icon k-delete"></span>删除</a>
</script>
<div class="k-content">
	<div class="k-header k-widget" id="user_toolbar" style="margin:1px 0;padding:3px 0;">&nbsp;
	    <a name="create" class="k-button k-button-icontext"><span class="k-icon k-add"></span>增加</a>
		&nbsp;<input type="text" name="keyword" class="k-textbox" placeholder="职工号/姓名" />&nbsp;
		<a name="search" class="k-button k-button-icontext"><span class="k-icon k-i-search"></span>查询</a>
		<a name="clean" class="k-button k-button-icontext"><span class="k-icon k-i-refresh"></span>清空</a>
	</div>
	<div id="user_content">
		<div id="user_content_table"></div>
	</div>
</div>
