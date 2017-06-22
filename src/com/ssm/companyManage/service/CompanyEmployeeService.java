package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 员工类的service
* Title: CompanyEmployeeService
* Description: 
* Company: 
* @author kongliufeng
* @param 
* @throws 
* @date 2017-6-15下午6:12:36
* @version 6.6.6
 */
public interface CompanyEmployeeService {

	/**
	 * 获取员工信息list
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeList(InputObject inputObject,OutputObject outputObject) throws Exception;

	/**
	 * 通过员工id查询改员工所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeById(InputObject inputObject ,OutputObject outputObject) throws Exception;

	/**
	 * 通过员工姓名查询改员工所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeByName(InputObject inputObject ,OutputObject outputObject) throws Exception;

	/**
	 * 新增一条员工信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void addEmployee(InputObject inputObject, OutputObject outputObject) throws Exception;

	/**
	 * 删除一个员工信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteEmployee (InputObject inputObject,OutputObject outputObject)throws Exception;

	/**
	 * 修改一个员工信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void uptadeEmployee (InputObject inputObject,OutputObject outputObject) throws Exception;

}
