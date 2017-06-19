$(function(e) {
	$("#KinSlideshow").KinSlideshow({
		intervalTime : 4,
		titleBar : {
			titleBar_height : 30,
			titleBar_bgColor : "#08355c",
			titleBar_alpha : 0.5
		},
		titleFont : {
			TitleFont_size : 12,
			TitleFont_color : "#FFFFFF",
			TitleFont_weight : "normal"
		},
		btn : {
			btn_bgColor : "#FFFFFF",
			btn_bgHoverColor : "#1072aa",
			btn_fontColor : "#000000",
			btn_fontHoverColor : "#FFFFFF",
			btn_borderColor : "#cccccc",
			btn_borderHoverColor : "#1188c0",
			btn_borderWidth : 1
		}
	});
	
	Judge();
});

function Judge() {
	
	$("#loginBtn").click(function(){
		//进行验证
		var username = $('#username').val();
		var password = $('#password').val();
		if (isNull(username) || isNull(password)) {
			$('#loginMessage').html("请输入帐号或密码！");
		} else {
			var params = {
				username : username,
				password : password,
			};
			AjaxPostUtil.request({
				url : path + "/post/CompanyManageController/judge",
				params : params,
				type : 'json',
				callback : function(json) {
					if (json.returnCode == 0) {
						window.location =path + "/html/views/news.html";
					} else {
						$('#loginMessage').html(json.returnMessage);
						$('#password').val('');
						return;
					}
				}
			});
		}
	});
}