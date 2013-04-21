$.djs.namespace("/aes","/ui/_common/selector_dir_main.js", function(){
	var callBack = function(rk, rn) {};
	this.init = function() {
		load_box_item();
		$("#selector_dir_main a[name='save']").click(function(){
			var resultKey = $("#selector_dir_main .k-state-selected span").attr("data-id");
			var resultName = $("#selector_dir_main .k-state-selected span").html();
			callBack(resultKey, resultName);
			callBack = function(rk, rn) {};
			$("#dirs_main_win").data("kendoWindow").destroy();
		});
		$("#selector_dir_main a[name='cancle']").click(function(){
			callBack = function(rk, rn) {};
			$("#dirs_main_win").data("kendoWindow").destroy();
		});
		$("#selector_dir_main a[name='clear']").click(function(){
			$("#selector_dir_main input").val("");
			load_box_item();
		});
	};
	
	function load_box_item() {
		$("#selector_dir_main .content").empty();
		$("#selector_dir_main .content").append("<div id='selector_dir_tree'></div>")
		var url = __ctxPath + "/common/selector/dir.do?data=";
		var homogeneous = new kendo.data.HierarchicalDataSource({
			transport: {
				read:{
					type: "post",
					dataType: "json",
					data: $("#selector_dir_main .search").toJSON(),
					url: url
				}
			},
			schema: {
				model: {
					id: "guuid",
					hasChildren: "count"
				}
			}
		});
		$("#selector_dir_main .content").kendoTreeView({
			dataSource: homogeneous,
			template: "<span data-id='#=item.guuid#'>#=item.dirName#</span>"
		});
	}
	
	this.show = function(ownLib, func) {
		if(func != undefined) {
			callBack = func;
		}
		var url = __ctxPath + "/common/selector/dir.do?ownLib="+ownLib;
		$.ajax({
			type: "post",
			url:  url,
			success:function(data) {
				if($("#dirs_main_win").size() > 0) {
					$("#dirs_main_win").data("kendoWindow").destroy();
				}
				$("<div id='dirs_main_win'></div>").appendTo("body");
				$("#dirs_main_win").html(data);
				var dialog = $("#dirs_main_win").kendoWindow({
				    height: "400px",
				    title: "资料类别",
				    width: "300px",
				    modal: true,
				    close: function(){
				    	$("#dirs_main_win").data("kendoWindow").destroy();
				    }
				}).data("kendoWindow");
				dialog.center();
				dialog.open();
			}
		});
	};
});