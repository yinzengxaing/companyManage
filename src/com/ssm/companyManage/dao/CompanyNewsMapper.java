package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 公司新闻mapper
* Title: CompanyNewsMapper
* Description: 
* Company: 
* @author yinzengxiang
* @param 
* @throws 
* @date 2017-6-18下午4:51:37
* @version 6.6.6
 */
public interface CompanyNewsMapper {
	
	/**
	 * 显示全部的新闻信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getNewsList(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取分页的新闻list
	 * @param map
	 * @param bounds
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getNewsList(Map<String, Object> map, PageBounds bounds ) throws Exception;

	/**
	 * 通过id获取一条新闻信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String , Object> getNewsById(Map<String, Object> map) throws Exception ;

	/**
	 * 通过id获取一条新闻信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getNewsByTitle(Map<String, Object> map) throws Exception;

	/**
	 * 添加一个新闻
	 * @param map
	 * @throws Exception
	 */
	public void addNews(Map<String, Object> map) throws Exception;

	/**
	 * 删除一个新闻
	 * @param map
	 * @throws Exception
	 */
	public void deleteNews(Map<String, Object> map) throws Exception;

	/**
	 * 修改一个新闻
	 * @param map
	 * @throws Exception
	 */
	public void updateNews(Map<String, Object> map) throws Exception;
}
