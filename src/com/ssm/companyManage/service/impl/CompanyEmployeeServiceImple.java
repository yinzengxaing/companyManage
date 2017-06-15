package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.CompanyEmployeeMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyEmployeeService;

/**
 * 人员service实现类
 * @author kongliufeng
 *
 */
@Service
public class CompanyEmployeeServiceImple implements CompanyEmployeeService {

	@Resource
	private CompanyEmployeeMapper companyEmployeeMapper;
	/**
	 * 获取所有的人员
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		System.out.println(parmas);
		List<Map<String,Object>> employeeList = companyEmployeeMapper.getEmployeeList(parmas);
		outputObject.setBeans(employeeList);
		outputObject.settotal(employeeList.size());
	}
	/**
	 * 根据人员id获取所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		System.out.println(parmas);
		Map<String, Object> EmployeeById = companyEmployeeMapper.getEmployeeById(parmas);
		System.out.println(EmployeeById);
		outputObject.setBean(EmployeeById);
	}
	/**
	 * 根据人员姓名获取所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeByName(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		Map<String, Object> EmployeeByName = companyEmployeeMapper.getEmployeeByName(parmas);
		outputObject.setBean(EmployeeByName);
	}
	/**
	 * 添加一条人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void addEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		System.out.println(params);
		companyEmployeeMapper.addEmployee(params);

	}
	/**
	 * 删除人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		companyEmployeeMapper.deleteEmployee(parmas);

	}
	/**
	 * 修改人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void uptadeEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		System.out.println(parmas);
		companyEmployeeMapper.uptadeEmployee(parmas);

	}

}
