package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 
 * @author yinzengxiang
 *	公司新闻mapper
 */
public interface CompanyNewsMapper {
	
	public List<Map<String, Object>> getNewsList(Map<String, Object> map) throws Exception;
	//获取分页的新闻list
	public List<Map<String, Object>> getNewsList(Map<String, Object> map, PageBounds bounds ) throws Exception;
	//通过id获取一条新闻信息
	public Map<String , Object> getNewsById(Map<String, Object> map) throws Exception ;
	//根据新闻标题获取一条新闻信息 
	public Map<String, Object> getNewsByTitle(Map<String, Object> map) throws Exception;
	//添加一个新闻
	public void addNews(Map<String, Object> map) throws Exception;
	//删除一个新闻
	public void deleteNews(Map<String, Object> map) throws Exception;
	//修改一个新闻
	public void updateNews(Map<String, Object> map) throws Exception;
}
