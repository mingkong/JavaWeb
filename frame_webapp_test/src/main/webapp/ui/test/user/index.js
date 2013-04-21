$.NS.namespace("/test", "/ui/test/user/index.js", function() {
	this.init = function() {
		load_content();
		bind_buttons();
	};
	
	function load_content() {
		var options = {
			object: $("#user_content_table"),
			data: function() {
				return $("#user_toolbar").toJSON();
			},
			url: __ctxPath + "/test/user/index.do?list=",
			columns: [
				{
					field: "userKey",
					title: "职工号",
					width: 100,
				},{
					field: "userName",
					title: "用户名",
					width: 100
				},{
					field: "sex",
					title: "性别",
					width: 50,
					template: "#= $.KendoUtils.keyVal(sex,{1:'男',2:'女'}) #"
				},{
					field: "departmentName",
					title: "部门",
					width: 200,
				},{
					field: "phone",
					title: "手机号码",
					width: 100,
					template: "#= $.KendoUtils.formatNull(phone) #"
				},{
					field: "email",
					title: "邮箱",
					template: "#= $.KendoUtils.formatNull(email) #"
				},{
	            	field: "operate",
	            	title: "操作",
	            	template: kendo.template($("#user_template").html())
				}
			]
		};
		$.kendo.page(options);
	}
	
	this.pre_update = function() {
		$.kendo.tips("修改");
	};
	
	this.pre_delete = function() {
		$.kendo.tips("修改");
	};
	
	function bind_buttons() {
		$("#user_toolbar a[name='create']").click(function(){ // 增
			$.kendo.tips("增加记录!");
		});
		$("#user_toolbar a[name='search']").click(function(){ // 查
			table_refresh();
		});
		$("#user_toolbar a[name='clean']").click(function(){ // 清
			$("#user_toolbar :text").val("");
			table_refresh();
		});
	}
	
	function table_refresh() {
		$( "#user_content_table" ).table("read");
	}
});