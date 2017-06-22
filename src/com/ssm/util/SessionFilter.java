package com.ssm.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	private static final String LOGIN_PAGE = "/companyManage/html/views/manage.html";// 后台管理登录登陆界面

//	private static final String ADM_HYT = "/post";
//
//	private static final String ADM_GATEWAY = "/gateway";
//
//	private static final String HYT_HYT = "/html";
//
//	private static final String HYT_HYT_MENU = ".json";

	public void init(FilterConfig arg0) throws ServletException {

	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = servletRequest.getSession();
		String url = servletRequest.getContextPath()
				+ servletRequest.getServletPath();
		Map<String, Object> user = (Map<String, Object>) session
				.getAttribute("admTsyUser");
		if (url.equals("/companyManage/html/views/manage.html")){
			chain.doFilter(request, response);
		} else {
			if (user == null) {
				if (url.contains(".css") || url.contains(".js")
						|| url.contains(".png") || url.contains(".jpg")
						|| url.contains(".ico") || url.contains(".gif")
						|| url.contains(".eot") || url.contains(".svg")
						|| url.contains(".ttf") || url.contains(".woff")
						|| url.contains(".woff2") || url.contains(".exe")
						|| url.contains(".mp4") || url.contains(".rmvb")
						|| url.contains(".avi") || url.contains(".3gp")) {
					chain.doFilter(request, response);
				}else if (url.equals("/companyManage/post/CompanyManageController/judge")){
					chain.doFilter(request, response);
				}else {
					servletResponse.sendRedirect(LOGIN_PAGE);
				}
			} else {// 如果用户不为空，放行
				try {
					chain.doFilter(request, response);
				} catch (Exception e) {
					session.removeAttribute("admTsyUser");
					servletResponse.sendRedirect(LOGIN_PAGE);
				}
			}
			/*if (url.indexOf(HYT_HYT) != -1) {// html通过
				System.out.println("html");
				chain.doFilter(request, response);
			} else if (url.indexOf(ADM_HYT) != -1) {// post请求通过
				System.out.println("post");
				chain.doFilter(request, response);
			} else if (url.indexOf(ADM_GATEWAY) != -1) {// gateway请求通过
				System.out.println("getaway");
				chain.doFilter(request, response);
			} else if (url.indexOf(HYT_HYT_MENU) != -1) {// menu请求通过
				System.out.println("menu");
				chain.doFilter(request, response);
			} else {
			}*/
		}
	}

	public void destroy() {
		System.out.println("销毁");
	}

}
