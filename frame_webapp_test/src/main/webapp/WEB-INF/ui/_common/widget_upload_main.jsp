<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	$.djs.call({ctxPath : "${pageContext.request.contextPath}",	js : "/ui/_common/widget_upload_main.js"}, function() {
		this.init(); 
	});
});	
</script>
<style type="text/css">
#widget_upload_main {
	margin-left: 5px;
	margin-right: 5px;
}

#widget_upload_main .tips {
	padding-top: 3px;
	padding-bottom: 3px;
	color: #ff22ff;
}

#widget_upload_main tbody>tr>td {
	padding: 5px 0px 5px 10px;
}

#widget_upload_progress {
	padding-top: 5px;
	padding-left: 5px;
}

#widget_upload_progress .progress {
	margin-bottom: 3px;
}

#widget_upload_progress .box {
	width: 350px;
	height: 20px;
	border: 1px inset;
	background: #eee;
}
#widget_upload_progress .bar {
	width: 2px;
	height: 20px;
	border-right: 1px solid #444;
	background: #9ACB34; 
}
</style>
<div class="k-content" id="widget_upload_main">
<form action="${pageContext.request.contextPath}/upload.action" enctype="multipart/form-data" method="post">
	<table class="k-wt-table" cellspacing="0" cellpadding="0" width="100%">
		<tbody class="content">
			<tr>
				<td class="k-wt-content">
					支持格式：<span class="tips"></span>
				</td>
			</tr>
			<tr>
				<td class="k-wt-content"><input type="file" name="files" />&nbsp;&nbsp;*最大100M</td>
			</tr>
		</tbody>
		<tr id="widget_upload_progress">
			<td class="k-wt-content">
				<div class="progress box">
					<div class="progress bar"></div>
				</div>
				<div class="progress status">上传处理进度：0%[0/0 bytes]正在处理第0个文件，耗时：0s</div>
			</td>
		</tr>
		<tr>
			<td class="k-wt-content" style="text-align: center">
				<a name="upload" class="k-button k-button-icontext"><span class="k-icon"></span>开始上传</a>
				<a name="cancle" class="k-button k-button-icontext"><span class="k-icon k-cancel"></span>取消上传</a>
			</td>
		</tr>
	</table>
</form>
<iframe id="widget_upload_result" name="widget_upload_result" src="" height="1px" scrolling="no" frameborder="0"></iframe>
</div>