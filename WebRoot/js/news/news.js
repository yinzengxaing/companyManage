var title = "";
var page = 1; //默认显示第一页
var id = "" ;

$(function(e){
	dataInit();
});

function dataInit(){
	setData();	
	eventInit();
}

function eventInit(){
	//新增按钮点击事件
	$('body').on('click', '#addNeswBtn', function(e){
		title : $('#title').val("");
		createTime : $('#date').val("");
		content : $('#content').val("");
		openadd('新增公告');
	});
	//保存新的新闻按钮事件
	$('body').on('click', '#add', function(e){
		var params = {
			page : $('#page').html(),	
			title : $('#title').val(),
			createTime : $('#date').val(),
			content : $('#content').val()
		}
		AjaxPostUtil.request({url:path+"/post/CompanyNewsController/addNews",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//清除上一次的文本信息
				$('#content').val("");
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
	
	//删除按钮点击事件
	$('body').on('click', '#delBtn', function(e){
		 id = $(this).attr('delId');
		$("#delModal").modal("show");
	});
	//确定删除按钮点击事件
	$('body').on('click', '#del', function(e){
		var params = {
				id: id
		};
		AjaxPostUtil.request({url:path+"/post/CompanyNewsController/deleteNews",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				$('#closeBtn02').click();
				setTimeout(setData,500);//一秒后刷新页面
			}else{
				alert("删除失败！");
			}
		}
		});
	});
	
	
	//修改按钮点击事件
	$('body').on('click', '#edtBtn', function(e){
		id = $(this).attr('edtId');
		var params = {
				id: id
		};
		//填充数据
		AjaxPostUtil.request({url:path+"/post/CompanyNewsController/getNewsById",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				$('#title').val(json.bean.title);
				$('#date').val(json.bean.createTime);
				$('#content').val(json.bean.content);
			}
		}
		});
		openedt("修改公告");
	});
		
		//修改按钮点击事件
		$('body').on('click', '#edt', function(e){
			var updateParams = {
					id: id,
					title : $('#title').val(),
					createTime : $('#date').val(),
					content : $('#content').val()
			}	
			AjaxPostUtil.request({url:path+"/post/CompanyNewsController/updateNews",params:updateParams,type:'json',callback:function(json){
				if (json.returnCode == 0){
					//清除文本信息
					$('#content').val("");
					$('#title').val("");
					$('#date').val("");
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
		
	//搜索按钮点击事件
	$('body').on('click', '#seachBtn', function(e){
		title = $('#searchParams').val();
		 page = 1;
		setData();
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
}
//初始化数据
function setData(){
	//设置当前页码
	var params = {
			page:page, //当前页
			title:title
	};
	AjaxPostUtil.request({url:path+"/post/CompanyNewsController/getNewsList",params:params,type:'json',callback:function(json){
		if (json.returnCode == 0){
			//填充数据
			//设置当前页码
			$('#page').html(json.bean.page);
			$('#totalPage').html(json.bean.totalPage);
			$('#total').html(json.total);
			var source = $("#newsListBean").html();
			var template = Handlebars.compile(source);
			$("#tbody").html(template(json));
		}
	}
	});
}
