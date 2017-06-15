var name = '';
$(function(e){
	dataInit();
});


function dataInit(){
	setData();	
	eventInit();
}

function eventInit() {
	//保存新的员工按钮事件
	$('body').on('click','#add',function(e){
		var params = {
				name : $('#ename').val(),
				sex : $('#selectSex input[name="workersex"]:checked ').attr("sex"),
				birthday : $('#birthday').val(),
				education : $('#education option:selected').val(),
				address : $('#address').val(),
				phoneNumber : $('#tel').val(),
				department : $('#department option:selected').val(),
				duty : $('#duty option:selected').val(),
		}
		AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/addEmployee",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//使添加的model关闭
				$('#closeBtn').click();
				//刷新数据
				setData();
			}else{
				alert(json.returnMessage);
			}
		}
		});
	});
	
	//删除员工按钮事件
	$('body').on('click','#delBtn',function(e){
		var id = $(this).attr("delId");
		var params = {
				id : id
		}
		//确定选择
		$("#delModal").modal("show");
		$('body').on('click','#del',function(e){
			AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/deleteEmployee",params:params,type:'json',callback:function(json){
			if(json.returnCode == 0){
			//使添加的model关闭
			$('#closeTBtn').click();
			setData();
			}else{
				alart(json.returnMessage);
			}
			}
			});
		});
	
})
}

//初始化数据
function setData(){
	var params = {
			mame : name
	};
	AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/getEmployeeList",params:params,type:'json',callback:function(json){
		if(json.returnCode == 0){
			var source = $("#employeelistBean").html();
			var template = Handlebars.compile(source);
			$("#tbody").html(template(json));
		}
		}
			});
}