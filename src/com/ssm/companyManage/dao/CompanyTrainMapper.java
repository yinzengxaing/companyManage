package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 职员培训
* Title: CompanyTrainMapper
* Description: 
* Company: 
* @author administrator
* @param 
* @throws 
* @date 2017-6-16上午8:31:29
* @version 6.6.6
 */
public interface CompanyTrainMapper {
	/**
	 * 显示全部的培训信息
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectAllTrain(Map<String, Object> map) throws Exception;
	// 添加分页
	public List<Map<String, Object>> selectAllTrain(Map<String, Object> map, PageBounds pageBounds) throws Exception;
	/**
	 * 查询所有的员工的名称
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectTrainById(Map<String, Object> map) throws Exception;
	
	/**
	 * 插入培训信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertTrain(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过trainId进行修改
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyById(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过trainId进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(Map<String, Object> map) throws Exception;
	
}
