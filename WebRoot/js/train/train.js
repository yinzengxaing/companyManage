var others = "";
var trainId = "";
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
	$("body").on("click", "#addTrain", function(){
		openadd('新增培训');
	});
	
	// 添加确认按钮
	$("body").on("click", "#saveAdd", function(){
	 	var param = {
				trainTitle:	$("#course").val(),// 课程
				trainLecturer:$("#lecturer").val(), // 讲师
				trainTime:$("#date").val(), // 时间
				other:$("#otherInfo").val(), // 简介
	 	};
	 	AjaxPostUtil.request({url:path+"/post/CompanyTrainController/insertTrain",params:param,type:'json',callback:function(json){
			if(json.returnCode == 0){
				$("#Addclose").click();
				trainInit();
			}
		}});
	});
	
	// 修改
	$("body").on("click", "#modifyInfo", function(){
		trainId = $(this).attr("trainId");
		var param = {
				trainId : trainId,
		};
		AjaxPostUtil.request({url:path+"/post/CompanyTrainController/selectTrainById",params:param, type:"json", callback:function(json){
			if(json.returnCode == 0){
				$("#course").val(json.bean.trainTitle);
				$("#lecturer").val(json.bean.trainLecturer);
				$("#date").val(json.bean.trainTime);
				$("#otherInfo").val(json.bean.other);
			}
		}
	});
	});
	// 修改后点击保存
	$("body").on("click", "#saveEdit", function(){
		var param = {
				trainTitle:	$("#course").val(),// 课程
				trainLecturer:$("#lecturer").val(), // 讲师
				trainTime:$("#date").val(), // 时间
				other:$("#otherInfo").val(), // 简介
				trainId :trainId,
		};
		AjaxPostUtil.request({url:path+"/post/CompanyTrainController/modifyById",params:param,type:'json',callback:function(json){
			if(json.returnCode == 0){
				$("#Addclose").click();
				trainInit();
			}
		}});
		
	});
	
	$("body").on("click", "#deleInfo", function(){
		trainId = $(this).attr("trainid");
	});
	$("body").on("click", "#del", function(){
		var param ={
				trainId : trainId,
		};
		AjaxPostUtil.request({url:path+"/post/CompanyTrainController/deleteById",params:param,type:'json',callback:function(json){
			if(json.returnCode == 0){
				$("#deleByTrain").click();
				trainInit();
			}
		}});
	});
}