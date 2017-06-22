package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 新闻类的service
* Title: CompanyNewsService
* Description: 
* Company: 
* @author yinzengxiang
* @param 
* @throws 
* @date 2017-6-14下午4:18:18
* @version 6.6.6
 */
public interface CompanyNewsService {
	
	/**
	 * 获得所有的新闻信息或者模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getNewsList (InputObject inputObject,OutputObject outputObject) throws Exception;
	
	/**
	 * 通过id进行查询薪金信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getNewsById(InputObject inputObject ,OutputObject outputObject) throws Exception;
	
	/**
	 * 添加一条薪金信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void addNews(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	/**
	 * 通过id薪金信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteNews (InputObject inputObject,OutputObject outputObject)throws Exception;
	
	/**
	 * 更新薪金信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void updateNews (InputObject inputObject,OutputObject outputObject) throws Exception;
}
