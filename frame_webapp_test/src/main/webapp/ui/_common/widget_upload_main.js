$.djs.namespace("/aes","/ui/_common/widget_upload_main.js", function(){
	var configs = defaults = {
		fileCount: 1, // 单次文件数,最多5个文件
		fileType: '.doc', // 支持格式
		callback: function(fids, fnms) {}//回调函数 参数文件编号，文件名
	};
	
	this.init = function() {
		load_content();
		bind_buttons();
	};
	
	function load_content() {
		if(configs.fileCount > 1) {
			for(var i=1; i<configs.fileCount; i++) {
				$("#widget_upload_main .content").append('<tr><td class="k-wt-content">'
					+ '<input type="file" name="files" />&nbsp;&nbsp;*最大100M</td></tr>');
			}
		}
		$("#widget_upload_main .tips").html(configs.fileType);
		$("#widget_upload_progress").hide();
		$("#widget_upload_main a[name='cancle']").hide();
	}
	
	function bind_buttons() {
		$("#widget_upload_main a[name='cancle']").click(function(){
			cancle_upload();
			configs = defaults;
			$("#upload_main_win").data("kendoWindow").destroy();
		});
		$("#widget_upload_main a[name='upload']").click(function(){
			var objs = $("#widget_upload_main input[name='files']");
			var flag = true; var tflag = true;
			$(objs).each(function(){
				var name = $(this).val();
				if(name != '') {
					flag = true;
					var arr = name.split(".");
					var type = arr[arr.length - 1];
					if(configs.fileType.lastIndexOf(type) == -1) {
						$.kendo.tips("请选择支持格式的文件!");
						tflag = false;
					}
				} else {
					flag = false;
				}
			});
			if(!flag) {
				$.kendo.tips("请选择文件!");
			} else if(tflag) {
				$("#widget_upload_progress").show();
				$("#widget_upload_main a[name='cancle']").show();
				$("#widget_upload_main a[name='upload']").hide();
				$("#widget_upload_main form").attr("target", "widget_upload_result");
				$("#widget_upload_main form").submit();
				PeriodicalExecuter.init(refresh_status, 0.5);
			}
		});
	}
	
	function cancle_upload() {
		PeriodicalExecuter.stop(); // 停止刷新
		$.ajax({
			type: "post",
			url:  __ctxPath + '/upload.action?cancelUpload=true',
			dataType: "json",
			success: function(uploadInfo) {
				$("#widget_upload_progress .bar").width(1);
				if (uploadInfo.cancel){
					$.kendo.tips("取消上传成功");
				}
			}
		});
	}
	
	function refresh_status() {
		$.ajax({
			type: "post",
			url:  __ctxPath + '/upload.action?uploadStatus=1',
			dataType: "json",
			success: function(uploadInfo) {
				var progressPercent = Math.ceil((uploadInfo.readTotalSize)
								/ uploadInfo.uploadTotalSize * 100);
				var hstr = ' 上传处理进度: '
						+ progressPercent + '% [' + uploadInfo.status
						+ '] 耗时: '
						+ (uploadInfo.processRunTime - uploadInfo.processStartTime)
						+ ' ms';
				$("#widget_upload_progress .status").html(hstr);
				var progressW = parseInt(progressPercent * 3.5);
				$("#widget_upload_progress .bar").width(progressW);
				if(progressPercent == 100 && uploadInfo.currentUploadFileNum
						== uploadInfo.uploadFileUrlList.length) {
					PeriodicalExecuter.stop();
					$("#widget_upload_main a[name='cancle']").hide();
					make_result(uploadInfo.uploadFileUuidList, uploadInfo.uploadFileUrlList);
				}
			},
			error: function() {
				PeriodicalExecuter.stop();
				$.kendo.tips("上传出错");
			}
		});
	}
	
	function make_result(uuids, names) { // 处理结果
		var fids = fnms = "";
		for(var i=0; i<uuids.length; i++) {
			fids = fids + "," + uuids[i];
			fnms = fnms + "," + names[i];
		}
		configs.callback(fids.substr(1), fnms.substr(1));
		configs = defaults;
		$("#upload_main_win").data("kendoWindow").destroy();
	}
	
	var PeriodicalExecuter = {
		callback: function() {},
		frequency: 1,
		currentlyExecuting: false,
		init: function(callback, frequency) {
			this.callback = callback;
			this.frequency = frequency;
			this.currentlyExecuting = false;
			this.registerCallback();
		},
		registerCallback: function() {
			this.timer = setInterval(this.onTimerEvent.bind(this), this.frequency * 1000);
		},
		execute: function() {
			this.callback(this);
		},
		stop: function() {
			if (!this.timer) return;
			clearInterval(this.timer);
			this.timer = null;
		},
		onTimerEvent: function() {
			if (!this.currentlyExecuting) {
				try {
					this.currentlyExecuting = true;
					this.execute();
				} catch(e) {
					
				} finally {
					this.currentlyExecuting = false;
				}
			}
		}
	};
	
	this.show = function(params) {
		if(params != undefined) {
			configs = params;
		}
		var url = __ctxPath + "/common/widget/upload.do";
		$.ajax({
			type: "post",
			url:  url,
			success:function(data) {
				if($("#upload_main_win").size() > 0) {
					$("#upload_main_win").data("kendoWindow").destroy();
				}
				$("<div id='upload_main_win'></div>").appendTo("body");
				$("#upload_main_win").html(data);
				var dialog = $("#upload_main_win").kendoWindow({
				    height: "auto",
				    title: "文件上传",
				    width: "450px",
				    modal: true,
				    close: function(){
				    	$("#upload_main_win").data("kendoWindow").destroy();
				    }
				}).data("kendoWindow");
				dialog.center();
				dialog.open();
			}
		});
	};
});