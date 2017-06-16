package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.CompanyEmployeeMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyEmployeeService;
import com.ssm.companyManage.util.JudgeUtil;

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
		String name = params.get("name").toString();
		String sex = params.get("sex").toString();
		String birthday = params.get("birthday").toString();
		String phoneNumber = params.get("phoneNumber").toString();
		String address =params.get("address").toString();
		
		String education =params.get("education").toString();
		String department =params.get("department").toString();
		String duty =params.get("duty").toString();
		
		if(JudgeUtil.isNull(name)||JudgeUtil.isNull(sex)||JudgeUtil.isNull(name)||JudgeUtil.isNull(address)||JudgeUtil.isNull(birthday)){
			outputObject.setreturnMessage("请将信息补充完整!");
			return;
		}else if(JudgeUtil.isDate(birthday)){
			outputObject.setreturnMessage("生日格式有问题！");
			return;
		}else if(education.equals("--请选择--")||department.equals("--请选择--")||duty.equals("--请选择--")){
			outputObject.setreturnMessage("请选择你的学历、部门、职务");
			return;	
		}else if(!JudgeUtil.isPhoneNO(phoneNumber)){
			outputObject.setreturnMessage("手机号格式有问题");
			return;
		}
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
		Map<String, Object> params = inputObject.getParams();
		System.out.println(params);
		String name = params.get("name").toString();
		String sex = params.get("sex").toString();
		String birthday = params.get("birthday").toString();
		String phoneNumber = params.get("phoneNumber").toString();
		String address =params.get("address").toString();
		
		String education =params.get("education").toString();
		String department =params.get("department").toString();
		String duty =params.get("duty").toString();
		if(JudgeUtil.isNull(name)||JudgeUtil.isNull(sex)||JudgeUtil.isNull(name)||JudgeUtil.isNull(address)||JudgeUtil.isNull(birthday)){
			outputObject.setreturnMessage("请将信息补充完整!");
			return;
		}else if(JudgeUtil.isDate(birthday)){
			outputObject.setreturnMessage("生日格式有问题！");
			return;
		}else if(education.equals("--请选择--")||department.equals("--请选择--")||duty.equals("--请选择--")){
			outputObject.setreturnMessage("请选择你的学历、部门、职务");
			return;	
		}else if(!JudgeUtil.isPhoneNO(phoneNumber)){
			outputObject.setreturnMessage("手机号格式有问题");
			return;
		}
		companyEmployeeMapper.uptadeEmployee(params);

	}

}
