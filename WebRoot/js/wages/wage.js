var searchContent ="";
$(function(){
	dataInit();
});

function dataInit(){
	wagesInit();
	eventInit();
}

function wagesInit(){
	var param = {
		other:searchContent,
	};
	AjaxPostUtil.request({url:path+"/post/CompanyWagesController/selectAllWages",params:param,type:'json',callback:function(json){
		if(json.returnCode == 0){
			// 遍历数据
			var source = $("#wagesBean").html();
			var template = Handlebars.compile(source);
			$("#wagesList").html(template(json));
		}
	}});
}
function eventInit(){
	
	// 监听查询
	$("body").on("click", "#searchWages", function(e){
		searchContent = $("#searchWage").val();
		wagesInit();// 表示一秒后进行刷新
	});
	
	// 监听添加按钮
	$("body").on("click", "#addWageBtn",function(e){
		AjaxPostUtil.request({url:path+"/post/CompanyWagesController/selectAllWroker",params:{}, type:"json", callback:function(json){
			if(json.returnCode == 0){
				// 遍历数据
				var source = $("#workerNameList").html();
				var template = Handlebars.compile(source);
				$("#workerBean").html(template(json));
			}
		}
		});
		openadd('新增职员薪资信息');
	});
	
	// 监听修改按钮
	$("body").on("click", "#modifyInfo", function(e){
		var wageId = $(this).attr("wageId");
	});
	
	// 保存添加的信息
	$("body").on("click", "#saveAdd", function(e){
		var base = $("#wageBase").val();
		var place = $("#wagePlace").val();
		var add = $("#wageAdd").val();
		var outach = $("#wageOutAch").val();
		var lengYear = $("#wageLengYear").val();
		var sum = Number(base) + Number(place) + Number(add) + Number(outach) + Number(lengYear);
		var param= {
				wageBase : base,
				wagePlace: place,
				wageAdd: add,
				wageOutAch: outach,
				wageLengYear: lengYear,
				workerid:$("#workerBean").val(),
				wageSum : sum,
		};
		alert($("#workerBean").val());
		AjaxPostUtil.request({url:path+"/post/CompanyWagesController/insertWages",params:param, type:"json", callback:function(json){
			if(json.returnCode == 0){
				$("#Addclose").click();
			}
		}
		});
	});
	
	
}