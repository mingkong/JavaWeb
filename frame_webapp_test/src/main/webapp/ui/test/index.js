$.NS.namespace("/test", "/ui/test/index.js", function() {
	this.init = function() {
		$("#main_horizontal").kendoSplitter({
	        panes: [
	            { collapsible: true,resizable: false, size: "180px" },
	            { collapsible: false },
	        ]
	    });
		$("#main_modules").kendoPanelBar({
            expandMode: "single",
            select: function(e) {
				var url = $(e.item).attr("data-url");
				if(url) {
					$.ajax({
			            type : "post",
			            url : url,      
			            success : function(data){
			            	$("#right-pane").html(data);
			            }
			        });
				}
			}
        });
	};
});