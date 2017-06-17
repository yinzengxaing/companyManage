var searchContent ="";
var wagesId = "";

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
		wagesId = $(this).attr("wageId")
		var param = {
			wageId:wagesId,
		};
		AjaxPostUtil.request({url:path+"/post/CompanyWagesController/selectById",params:param, type:"json", callback:function(json){
				if(json.returnCode == 0){
					$("#wageBase").val(json.rows[0].wageBase);
					$("#wagePlace").val(json.rows[0].wagePlace);
					$("#wageAdd").val(json.rows[0].wageAdd);
					$("#wageOutAch").val(json.rows[0].wageOutAch);
					$("#wageLengYear").val(json.rows[0].wageLengYear);
					
					// 遍历数据
					var source = $("#workerNameList").html();
					var template = Handlebars.compile(source);
					$("#workerBean").html(template(json));
				}
			}
			
		});
		
		openedt('修改职员薪资信息');
	});
	
	// 修改确认的按钮
	$("body").on("click", "#saveEdit", function(e){
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
				wageSum : sum,
				wageId:wagesId,
		};
		AjaxPostUtil.request({url:path+"/post/CompanyWagesController/modifyWages",params:param, type:"json", callback:function(json){
			if(json.returnCode == 0){
				$("#Addclose").click();
				wagesInit();
			}else{
				alert("工资必须为数字！！!");
			}
		}
		});
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
		AjaxPostUtil.request({url:path+"/post/CompanyWagesController/insertWages",params:param, type:"json", callback:function(json){
			if(json.returnCode == 0){
				$("#Addclose").click();
				wagesInit();
			}
		}
		});
	});
}