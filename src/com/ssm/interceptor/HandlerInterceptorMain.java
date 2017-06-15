package com.ssm.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.*;

import com.ssm.companyManage.util.Constants;
import com.ssm.companyManage.util.JudgeUtil;
import com.ssm.util.CustomException;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.object.PutObject;


public class HandlerInterceptorMain implements HandlerInterceptor{
	
	private static final String[] URL = {"/post/wechatAdminLoginController/insertLogin","/post/WechatPhoneMessageLogController/insertPhoneMessage",
		"/post/wechatAdminLoginController/insertAdminLogin","/post/wechatAdminLoginController/selectSession","/post/wechatAdminLoginController/selectAdminNo",
		"/post/wechatAdminLoginController/updatePassword"};

	//在进入Handler方法之前执行  
	//用于身份认证、身份授权、  
	//比如身份认证，如果认证不通过表示当前用户没有登录，需要此方法拦截不再向下执行
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	new PutObject(request,response);
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = servletRequest.getContextPath() + servletRequest.getServletPath();
		Map<String,Object> user = InputObject.getLogInParams();
//		if (user == null && !JudgeUtil.contains(URL,url)) {
//			throw new CustomException("您还未登录,请先登录");
//		}
    	if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
        	//如果是ajax请求响应头会有x-requested-with
    		return true;
        }else{
            //非ajax请求时
        	return true;
        }
    }

    //进入Handler方法之后，在返回ModelAndView之前执行  
    //应用场景从modelAndView对象出发：将公用的模型数据(比如菜单的导航)在这里传到视图，也可以在这里面来统一指定视图
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
        	//如果是ajax请求响应头会有x-requested-with
        	if(OutputObject.getCode()==Constants.WRONG){
        		OutputObject.setCode(0);
        		if(OutputObject.getMessage().equals(Constants.WRONG_MESSAGE)){
        			OutputObject.setMessage("成功");
        		}else{
        			OutputObject.setCode(Constants.WRONG);
        		}
        	}
        	OutputObject.put();
        }else{
        	//非ajax请求时
        	if(OutputObject.getCode()==Constants.WRONG){
        		OutputObject.setCode(0);
        		if(OutputObject.getMessage().equals(Constants.WRONG_MESSAGE)){
        			OutputObject.setMessage("成功");
        		}else{
        			OutputObject.setCode(Constants.WRONG);
        		}
        	}
        	OutputObject.put();
        }
    }
    //执行Handler完成后执行此方法  
  	//应用场景：统一的异常处理，统一的日志处理  
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
