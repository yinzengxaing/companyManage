package com.ssm.companyManage.dao;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
/**
 * 薪金信息的Mapper
* Title: CompanyEmployeeMapper
* Description: 
* Company: 
* @author kongliufeng
* @param 
* @throws 
* @date 2017-6-21下午4:35:29
* @version 6.6.6
 */
public interface CompanyEmployeeMapper {
	/**
	 * 获取员工信息list
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEmployeeList(Map<String ,Object> map) throws Exception;
	
	/**
	 * 获取分页的员工信息list
	 * @param map
	 * @param bounds
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEmployeeList(Map<String ,Object> map,PageBounds bounds) throws Exception;
	
	/**
	 * 通过员工id查询改员工所有信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String , Object> getEmployeeById(Map<String,Object> map)throws Exception;
	
	/**
	 * 通过员工姓名查询改员工所有信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String , Object> getEmployeeByName(Map<String,Object> map)throws Exception;
	
	/**
	 * 新增一条员工信息
	 * @param map
	 * @throws Exception
	 */
	public void addEmployee(Map<String , Object> map) throws Exception;

	/**
	 * 删除一个员工信息
	 * @param map
	 * @throws Exception
	 */
	public void deleteEmployee(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改一个员工信息
	 * @param map
	 * @throws Exception
	 */
	public void uptadeEmployee(Map<String, Object> map) throws Exception;
	
}
