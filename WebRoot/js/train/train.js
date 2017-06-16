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
	
	
	
	
}