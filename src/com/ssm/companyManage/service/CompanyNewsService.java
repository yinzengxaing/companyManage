package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 新闻类的service
 * @author yinzengxiang
 *
 */
public interface CompanyNewsService {
	
	public void getNewsList (InputObject inputObject,OutputObject outputObject) throws Exception;
	
	public void getNewsById(InputObject inputObject ,OutputObject outputObject) throws Exception;
	
	public void addNews(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	public void deleteNews (InputObject inputObject,OutputObject outputObject)throws Exception;
	
	public void updateNews (InputObject inputObject,OutputObject outputObject) throws Exception;
}
