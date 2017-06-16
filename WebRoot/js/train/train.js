var others = "";

$(function(){
	dataInit();
});

function dataInit(){
	trainInit();
	eventInit();
}

function trainInit(){
	var param = {
			other: others,	
	};
	AjaxPostUtil.request({url:path+"/post/CompanyTrainController/selectAllTrain",params:param,type:'json',callback:function(json){
		if(json.returnCode == 0){
			// 遍历数据
			var source = $("#trainBean").html();
			var template = Handlebars.compile(source);
			$("#trainList").html(template(json));
		}
	}});
}

function eventInit(){
	// 进行搜索
	$("body").on("click", "#searchTrain", function(e){
		others = $("#searchId").val();
		alert(other);
		trainInit();
	});
	
	// 显示添加的窗口
	$("body").on("click", "#addTrain", function(e){
		openadd('新增培训');
	});
	
	// 添加确认按钮
	$("body").on("click", "#saveEdit", function(e){
	 	var param = {
	 			$("#course").val(),// 课程
	 			$("#lecturer").val(), // 讲师
	 			$("#date").val(), // 时间
	 			$("#otherInfo").val(), // 简介
	 	};
		
	});
	
	
	
}