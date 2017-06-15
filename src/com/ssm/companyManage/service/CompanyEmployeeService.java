package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 员工类的service
 * @author kongliufeng
 *
 */
public interface CompanyEmployeeService {
	//获取员工信息list
	public void getEmployeeList(InputObject inputObject,OutputObject outputObject) throws Exception;
	//通过员工id查询改员工所有信息
	public void getEmployeeById(InputObject inputObject ,OutputObject outputObject) throws Exception;
	//通过员工姓名查询改员工所有信息
	public void getEmployeeByName(InputObject inputObject ,OutputObject outputObject) throws Exception;
	//新增一条员工信息
	public void addEmployee(InputObject inputObject, OutputObject outputObject) throws Exception;
	//删除一个员工信息
	public void deleteEmployee (InputObject inputObject,OutputObject outputObject)throws Exception;
	//修改一个员工信息
	public void uptadeEmployee (InputObject inputObject,OutputObject outputObject) throws Exception;

}
