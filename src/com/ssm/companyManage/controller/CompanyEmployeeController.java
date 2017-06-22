package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyEmployeeService;
/**
 * 员工信息的相关控制
* Title: CompanyEmployeeController
* Description: 
* Company: 
* @author administrator
* @param 
* @throws 
* @date 2017-6-19下午4:19:15
* @version 6.6.6
 */
@Controller
public class CompanyEmployeeController {

	@Resource
	private CompanyEmployeeService companyEmployeeService;
	/**
	 * 获取所有的人员
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/getEmployeeList")
	@ResponseBody
	public void getEmployeeList(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.getEmployeeList(inputObject, outputObject);
	}
	
	/**
	 * 根据人员id获取所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/getEmployeeById")
	@ResponseBody
	public void getEmployeeById(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.getEmployeeById(inputObject, outputObject);
	}
	/**
	 * 根据人员姓名获取所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/getEmployeeByName")
	@ResponseBody
	public void getEmployeeByName(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.getEmployeeByName(inputObject, outputObject);
	}
	/**
	 * 添加一条人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/addEmployee")
	@ResponseBody
	public void addEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.addEmployee(inputObject, outputObject);
	}
	
	/**
	 * 删除人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/deleteEmployee")
	@ResponseBody
	public void deleteEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.deleteEmployee(inputObject, outputObject);
	}
	
	/**
	 * 修改人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyEmployeeController/uptadeEmployee")
	@ResponseBody
	public void uptadeEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		companyEmployeeService.uptadeEmployee(inputObject, outputObject);
	}

}
