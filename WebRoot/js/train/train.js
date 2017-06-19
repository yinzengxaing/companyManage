var others = "";
var trainId = "";
var page = 1; // 默认显示的是第一页

$(function(){
	dataInit();
});

function dataInit(){
	trainInit();
	eventInit();
}

function trainInit(){
	var param = {
			page : page , // 当前页
			other: others,	
	};
	AjaxPostUtil.request({url:path+"/post/CompanyTrainController/selectAllTrain",params:param,type:'json',callback:function(json){
		if(json.returnCode == 0){
			// 遍历数据
			$("#page").html(json.bean.page);
			$("#totalPage").html(json.bean.totalPage);
			$("#total").html(json.total);
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
		trainInit();
	});
	
	// 显示添加的窗口
	$("body").on("click", "#addTrain", function(){
		openadd('新增培训');
	});
	
	// 添加确认按钮
	$("body").on("click", "#saveAdd", function(){
	 	var param = {
	 			page:$("#page").html(),
				trainTitle:	$("#course").val(),// 课程
				trainLecturer:$("#lecturer").val(), // 讲师
				trainTime:$("#date").val(), // 时间
				other:$("#otherInfo").val(), // 简介
	 	};
	 	AjaxPostUtil.request({url:path+"/post/CompanyTrainController/insertTrain",params:param,type:'json',callback:function(json){
			if(json.returnCode == 0){
				// 清空输入框的内容
				other:$("#otherInfo").val("");
				$("#Addclose").click();
				trainInit();
			}else{
				alert(json.returnMessage);
			}
		}});
	});
	
	// 点击修改，回显数据
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
				trainTitle:	$("#course").val("");// 课程
				trainLecturer:$("#lecturer").val(""); // 讲师
				trainTime:$("#date").val(""); // 时间
				other:$("#otherInfo").val(""); // 简介
				
				$("#Addclose").click();
				trainInit();
			}else{
				alert(json.returnMessage);
			}
		}});
		
	});
	// 点击删除按钮
	$("body").on("click", "#deleInfo", function(){
		trainId = $(this).attr("trainid");
	});
	// 点击 删除确认按钮
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
	//下一页按钮点击事件
	$('body').on('click', '#nextPage', function(e){
		//获取当前页码并且加1
		var num = $('#page').html();
		 page = num*1 + 1*1;
		 if (page > $('#totalPage').html() )
			 return;
		trainInit();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	});
	
	//上一页按钮点击事件
	$('body').on('click', '#previousPage', function(e){
		//获取当前页码并且减1
		var num = $('#page').html();
		 page = num*1 - 1*1;
		 if (page <= 0)
			 return;
		trainInit();
	});
	
	//首页按钮点击事件
	$('body').on('click', '#headerPage', function(e){
		//获取当前页码并且减1
		 page = 1;
		trainInit();
	});
	
	//尾页按钮点击事件
	$('body').on('click', '#trailerPage', function(e){
		//获取当前页码并且减1
		 page = $('#totalPage').html();
		trainInit();
	});
}