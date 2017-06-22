var name = '';
var id = '';
var page = 1;//默认显示第一页
$(function(e){
	dataInit();
});
function dataInit(){
	setData();
	eventInit();
	
}

function eventInit() {
	//保存新的员工按钮事件
	$('body').on('click','#AddEmployBtn',function(e){
		openadd('新增职员');
	});
	//新增的点击事件
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
		id = $(this).attr("delId");
		//确定选择
		$("#delModal").modal("show");
	})
	
	//删除确定事件
	$('body').on('click','#del',function(e){
		    	var params = {
		    			id : id
		    		}
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
	
	//查询员工按钮事件
	$('body').on('click', '#seachBtn', function(e){
		name = $('#searchParams').val();
		page = 1;
		setData();
	});
	
	//修改员工按钮事件
	$('body').on('click','#edtBtn',function(e){
		id = $(this).attr('edtId');
		var params = {
			id : id
		}
		//填充数据
		AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/getEmployeeById",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//回显姓名
				$('#ename').val(json.bean.name);
				if(json.bean.sex == '男'){
					$("#nansex").attr("checked","");
				}else{
					$("#nvsex").attr("checked","");
				}
				//回显生日
				$('#birthday').val(json.bean.birthday);
				//回显学历
				if(json.bean.education == '大学专科'){
					  $("#education  option[value='大学专科'] ").attr("selected",true);
				}else if(json.bean.education == '大学本科'){
					  $("#education  option[value='大学本科'] ").attr("selected",true);
				}else if(json.bean.education == '硕士研究生'){
					  $("#education  option[value='硕士研究生'] ").attr("selected",true);
				}else if(json.bean.education == '博士研究生'){
					  $("#education  option[value='博士研究生'] ").attr("selected",true);
				}
				//回显地址
				$('#address').val(json.bean.address);
				$('#tel').val(json.bean.phoneNumber);
				//回显部门
				if(json.bean.department == '人力资源部'){
					 $("#department  option[value='人力资源部'] ").attr("selected",true);
				}else if(json.bean.department == '市场营销部' ){
					 $("#department  option[value='市场营销部'] ").attr("selected",true);
				}else if(json.bean.department == '财务部' ){
					 $("#department  option[value='财务部'] ").attr("selected",true);
				}else if(json.bean.department == '行政部' ){
					 $("#department  option[value='行政部'] ").attr("selected",true);
				}else if(json.bean.department == '开发部' ){
					 $("#department  option[value='开发部'] ").attr("selected",true);
				}else if(json.bean.department == '后勤部' ){
					 $("#department  option[value='后勤部'] ").attr("selected",true);
				}
				//回显职务
				if(json.bean.duty =='产品经理'){
					$("#duty  option[value='产品经理'] ").attr("selected",true);
				}else if(json.bean.duty =='策划经理'){
					$("#duty  option[value='策划经理'] ").attr("selected",true);
				}else if(json.bean.duty =='架构师'){
					$("#duty  option[value='架构师'] ").attr("selected",true);
				}else if(json.bean.duty =='前端工程师'){
					$("#duty  option[value='前端工程师'] ").attr("selected",true);
				}else if(json.bean.duty =='开发工程师'){
					$("#duty  option[value='开发工程师'] ").attr("selected",true);
				}else if(json.bean.duty =='测试工程师'){
					$("#duty  option[value='测试工程师'] ").attr("selected",true);
				}else if(json.bean.duty =='运维工程师'){
					$("#duty  option[value='运维工程师'] ").attr("selected",true);
				}
			}
		}
		});
		//掉用修改页面
		openedt('修改职员');
	});
	//修改按钮点击事件
	$('body').on('click','#edt',function(e){
		var updateParams = {
				id : id,
				name : $('#ename').val(),
				sex : $('#selectSex input[name="workersex"]:checked ').attr("sex"),
				birthday : $('#birthday').val(),
				education : $('#education option:selected').val(),
				address : $('#address').val(),
				phoneNumber : $('#tel').val(),
				department : $('#department option:selected').val(),
				duty : $('#duty option:selected').val(),
		}	
		AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/uptadeEmployee",params:updateParams,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//使添加的model隐藏起来
				$('#closeBtn').click();
				//刷新数据
				setData();
			}else{
				alert(json.returnMessage);
			}
		}
		});
	});
	
	//下一页按钮点击事件
	$('body').on('click', '#nextPage', function(e){
		//获取当前页码并且加1
		var num = $('#page').html();
		 page = num*1 + 1*1;
		 if (page > $('#totalPage').html() )
			 return;
		setData();
		
	});
	
	//上一页按钮点击事件
	$('body').on('click', '#previousPage', function(e){
		//获取当前页码并且减1
		var num = $('#page').html();
		 page = num*1 - 1*1;
		 if (page <= 0)
			 return;
		setData();
	});
	
	//首页按钮点击事件
	$('body').on('click', '#headerPage', function(e){
		//获取当前页码并且减1
		 page = 1;
		setData();
	});
	
	//尾页按钮点击事件
	$('body').on('click', '#trailerPage', function(e){
		//获取当前页码并且减1
		 page = $('#totalPage').html();
		setData();
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

//初始化数据
function setData(){
	var params = {
			page : page,//当前页
			name : name
	};
	AjaxPostUtil.request({url:path+"/post/CompanyEmployeeController/getEmployeeList",params:params,type:'json',callback:function(json){
		if(json.returnCode == 0){
			//填充数据
			//设置当前页码
			$('#page').html(json.bean.page);
			$('#totalPage').html(json.bean.totalPage);
			$('#total').html(json.total)
			//设置当前登录人信息
			$('#loginUser').html(json.bean.loginname);
			$('#edtAdmin').attr("userId",json.bean.userId);
			$('#loginpassword').val(json.bean.loginpassword);
			$('#loginname').val(json.bean.loginname);
			var source = $("#employeelistBean").html();
			var template = Handlebars.compile(source);
			$("#tbody").html(template(json));
		}
		}
	});
	
}