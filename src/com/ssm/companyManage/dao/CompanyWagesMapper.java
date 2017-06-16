package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

/**
 * 薪资Dao
* Title: CompanyWagesMapper
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-14下午5:56:09
 */
public interface CompanyWagesMapper {

	/**
	 * 显示多有和通过条件模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectAllWages(Map<String, Object> map ) throws Exception;
	
	/**
	 * 通过id查询工资信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectById(Map<String, Object> map) throws Exception;
	
	/**
	 * 插入数据
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertWages(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyWages(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(Map<String, Object> map) throws Exception;

	/**
	 * 显示所有没有在薪金表中的职员的名称
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectAllWroker() throws Exception;
	
}
