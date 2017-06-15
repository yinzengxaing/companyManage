package com.ssm.companyManage.dao;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
/***
 * 
 * @author kongliufeng
 *员工mapper
 */
public interface CompanyEmployeeMapper {
	//获取员工信息list
	public List<Map<String, Object>> getEmployeeList(Map<String ,Object> map) throws Exception;
	//获取分页的员工信息list
	public List<Map<String, Object>> getEmployeeList(Map<String ,Object> map,PageBounds bounds) throws Exception;
	//通过员工id查询改员工所有信息
	public Map<String , Object> getEmployeeById(Map<String,Object> map)throws Exception;
	//通过员工姓名查询改员工所有信息
	public Map<String , Object> getEmployeeByName(Map<String,Object> map)throws Exception;
	//新增一条员工信息
	public void addEmployee(Map<String , Object> map) throws Exception;
	//删除一个员工信息
	public void deleteEmployee(Map<String, Object> map) throws Exception;
	//修改一个员工信息
	public void uptadeEmployee(Map<String, Object> map) throws Exception;
	
}
