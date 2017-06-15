var title = "";

$(function(e){
	dataInit();
});

function dataInit(){
	setData();	
	eventInit();
}

function eventInit(){
	//保存新的新闻按钮事件
	$('body').on('click', '#add', function(e){
		var params = {
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
}

//初始化数据
function setData(){
	var params = {
			title : title
	};
	AjaxPostUtil.request({url:path+"/post/CompanyNewsController/getNewsList",params:params,type:'json',callback:function(json){
		if (json.returnCode == 0){
			//填充数据
			var source = $("#newsListBean").html();
			var template = Handlebars.compile(source);
			$("#tbody").html(template(json));
		}
	}
	});
}


