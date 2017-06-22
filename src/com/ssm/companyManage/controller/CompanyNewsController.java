package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyNewsService;
/**
 * 新闻公告的信息的控制
* Title: CompanyNewsController
* Description: 
* Company: 
* @author administrator
* @param 
* @throws 
* @date 2017-6-19下午4:24:27
* @version 6.6.6
 */
@Controller
public class CompanyNewsController {
	
	@Resource
	private CompanyNewsService companyNewsService;
	
	/**
	 * 获取所有的新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyNewsController/getNewsList")
	@ResponseBody
	public void getNewsList(InputObject inputObject,OutputObject outputObject) throws Exception{
		companyNewsService.getNewsList(inputObject, outputObject);
	}
	
	/**
	 * 添加一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyNewsController/addNews")
	@ResponseBody
	public void addNews(InputObject inputObject,OutputObject outputObject) throws Exception{
		companyNewsService.addNews(inputObject, outputObject);
	}
	
	/**
	 * 删除一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyNewsController/deleteNews")
	@ResponseBody
	public void deleteNews(InputObject inputObject,OutputObject outputObject) throws Exception{
		companyNewsService.deleteNews(inputObject, outputObject);
	}
	
	/**
	 * 修改一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyNewsController/updateNews")
	@ResponseBody
	public void updateNews(InputObject inputObject,OutputObject outputObject) throws Exception{
		companyNewsService.updateNews(inputObject, outputObject);
	}
	
	
	/**
	 * 根据id获取一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyNewsController/getNewsById")
	@ResponseBody
	public void getNewsById(InputObject inputObject,OutputObject outputObject) throws Exception{
		companyNewsService.getNewsById(inputObject, outputObject);
	}
}
