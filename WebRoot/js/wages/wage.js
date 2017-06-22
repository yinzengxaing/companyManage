var searchContent ="";
var wagesId = "";
var page = 1; // 默认显示第一页

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
		page:page,
	};
	AjaxPostUtil.request({url:path+"/post/CompanyWagesController/selectAllWages",params:param,type:'json',callback:function(json){
		if(json.returnCode == 0){
			// 遍历数据
			$('#page').html(json.bean.page); // 当前页码
			$('#totalPage').html(json.bean.totalPage);// 表示一共有多少条数据
			$('#total').html(json.total); // 表示总条数
			//设置当前登录人信息
			$('#loginUser').html(json.bean.loginname);
			$('#edtAdmin').attr("userId",json.bean.userId);
			$('#loginpassword').val(json.bean.loginpassword);
			$('#loginname').val(json.bean.loginname);
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
		page = 1;
		wagesInit();// 表示一秒后进行刷新
	});
	
	//下一页按钮点击事件
	$('body').on('click', '#nextPage', function(e){
		//获取当前页码并且加1
		var num = $('#page').html();
		 page = num*1 + 1*1;
		 if (page > $('#totalPage').html() )
			 return;
		wagesInit();
	});
	
	//上一页按钮点击事件
	$('body').on('click', '#previousPage', function(e){
		//获取当前页码并且减1
		var num = $('#page').html();
		 page = num*1 - 1*1;
		 if (page <= 0)
			 return;
		wagesInit();
	});
	
	//首页按钮点击事件
	$('body').on('click', '#headerPage', function(e){
		//获取当前页码并且减1
		 page = 1;
		wagesInit();
	});
	
	//尾页按钮点击事件
	$('body').on('click', '#trailerPage', function(e){
		//获取当前页码并且减1
		 page = $('#totalPage').html();
		wagesInit();
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
		wagesId = $(this).attr("wageId");
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
				alert(json.returnMessage);
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
				page:$("#page").html,
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
			}else{
				alert(json.returnMessage);
			}
		}
		});
	});
	
	//退出登录按钮单击相应事件
	$('body').on('click', '#escBtn', function(e){
		AjaxPostUtil.request({url:path+"/post/CompanyManageController/escAdmin",params:{},type:'json',callback:function(json){
			window.location.href = "manage.html";
		}
		});
	});
	
	//修改按钮点击事件
	$('body').on('click', '#edtAdmin', function(e){
		var params = {
				id:	$('#edtAdmin').attr("userid"),
				password : $("#loginpassword").val()
		}
		AjaxPostUtil.request({url:path+"/post/CompanyManageController/updateLoginnameAndPassword",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				alert("密码已经更改，请重新登录");
				window.location.href = "manage.html";
			}
		}
		});
	});
}