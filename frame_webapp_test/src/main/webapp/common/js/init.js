(function($){
	$.kendo = function(){};
	$.kendo.config = {};
	$.kendo.tips = function(content, time, error){
		$("body").append('<div id="tips_win"></div>');
    	$("#tips_win").html('<p style="margin-top:10px;font-size:16px;text-align:center;">' + content + '</p>');
		var win = $("#tips_win").kendoWindow({
			title: false,
			width: "240px"
	    }).data("kendoWindow");
		win.center();
		win.open();
		$("#tips_win").css({background:"#E4EA32"});
		if(error) {
			$("#tips_win div").css({color:"#E40000"});
		}
		if(time < 100 && time > 0) {
			setTimeout('$("#tips_win").data("kendoWindow").destroy();', time * 1000);
		} else {
			setTimeout('$("#tips_win").data("kendoWindow").destroy();',1200);
		}
	};
	$.kendo.page = function(params) {
		if(params.pageSize == undefined) {
			params.pageSize = 10;
		}
		params.object.kendoGrid({			
			dataSource: {
				transport: {
					read: {
						type: "post",
						url: params.url,
						dataType: "json",
						data: params.data
					}
				},
				schema: {
					data: function(d) {	return d.result; },
					total: function(d){ return d.total; }
				},
	            pageSize: params.pageSize,
	            serverPaging: true,
                serverSorting: true,
                serverFiltering: true
			},
			scrollable: true, //是否显示滚动条
			sortable: false, //是否排序显示
			pageable: $.KendoConstants.GRID_PAGING_CONFIG, //是否显示分页
			columns: params.columns,
			dataBound: function (args) { 
				if(params.bind != undefined) {
					params.bind(args);
				}
			}
		});
	};
	$.kendo.list = function(params) {
		params.object.kendoGrid({			
			dataSource: {
				transport: {
					read: {
						type: "post",
						url: params.url,
						dataType: "json",
						data: params.data
					}
				},
				schema: {
					data: function(d) {	return d; },
				},
	            serverPaging: true,
                serverSorting: true,
                serverFiltering: true
			},
			scrollable: true, //是否显示滚动条
			sortable: false, //是否排序显示
			columns: params.columns,
			height: params.height,
			dataBound: function (args) { 
				if(params.bind != undefined) {
					params.bind(args);
				}
			}
		});
	};
	$.kendo.dropList = function(params) {
		if(params.name == undefined) {
			params.name = 'text';
		}
		if(params.name == undefined) {
			params.key = 'value';
		}
		params.object.kendoDropDownList({
            dataTextField: params.name,
            dataValueField: params.key,
            dataSource: {
				transport: {
					read: {
						type: "post",
						url: params.url,
						dataType: "json"
					}
				},
	            pageSize: 100,
	            serverFiltering: true,
                serverPaging: true
			},
			height: "200px",
			change: params.change,
            index: 0
        });
	};
})(jQuery);