<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/jsp/taglibs.jsp"%>
<script type="text/javascript">
$(function() {
	$.NS.call(['/test', "/ui/test/index.js"], function(){
		this.init();
	});
});
</script>
<div id="main_horizontal" style="min-height: 580px;">
    <div id="left-pane">
        <ul id="main_modules">
			<li class="k-state-active">人员管理
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">登陆人员 </li>
                 </ul>
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">人员信息</li>
                 </ul>
			</li>
			<li>机构管理
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">部门管理 </li>
                 </ul>
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">公司信息</li>
                 </ul>
			</li>
			<li>系统配置
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">邮箱配置 </li>
                 </ul>
                 <ul>
                     <li data-url="${ctx}/test/user/index.do">编号设置</li>
                 </ul>
			</li>
		</ul>
    </div>
    <div id="right-pane">
       
    </div>
</div>
