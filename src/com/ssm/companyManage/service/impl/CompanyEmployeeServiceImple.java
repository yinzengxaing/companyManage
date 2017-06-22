package com.ssm.companyManage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.companyManage.dao.CompanyEmployeeMapper;
import com.ssm.companyManage.dao.CompanyWagesMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyEmployeeService;
import com.ssm.companyManage.util.JudgeUtil;

/**
 * 人员service实现类
* Title: CompanyEmployeeServiceImple
* Description: 
* Company: 
* @author kongliufeng
* @param 
* @throws 
* @date 2017-6-19下午6:35:29
 */
@Service
public class CompanyEmployeeServiceImple implements CompanyEmployeeService {
	@Resource
	private CompanyEmployeeMapper companyEmployeeMapper;
	@Resource
	private CompanyWagesMapper companyWagesMapper;
	/**
	 * 获取所有的人员
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		Map<String, Object> logParams = inputObject.getLogParams();
		//进行分页
		int page =Integer.parseInt(params.get("page").toString()); //当前页；
		int limit = 10; //定义每一页条数
		List<Map<String,Object>> employeeList = companyEmployeeMapper.getEmployeeList(params,new PageBounds(page, limit));

		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)employeeList;
		//获取当前页数的总数
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		//保存分页信息的Map
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		pageMap.put("page", page);
		int totalPage = total/limit; //计算页数
		if (total%limit != 0)
			totalPage = totalPage+1;
		//放入登录人的相关信息
		pageMap.put("userId",logParams.get("id"));
		pageMap.put("loginpassword",logParams.get("loginpassword"));
		pageMap.put("loginname",logParams.get("loginname"));
		pageMap.put("totalPage",totalPage);
		outputObject.setBeans(employeeList);
		outputObject.settotal(total);
		outputObject.setBean(pageMap);
	}
	/**
	 * 根据人员id获取所有信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getEmployeeById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> parmas = inputObject.getParams();
		// 通过EmployeeId获得员工信息
		Map<String, Object> EmployeeById = companyEmployeeMapper.getEmployeeById(parmas);
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
		Map<String, Object> params = inputObject.getParams(); // 获取参数
		
		// 参数类型转换
		String name = params.get("name").toString();
		String sex = params.get("sex").toString();
		String birthday = params.get("birthday").toString();
		String phoneNumber = params.get("phoneNumber").toString();
		String address =params.get("address").toString();
		String education =params.get("education").toString();
		String department =params.get("department").toString();
		String duty =params.get("duty").toString();
		
		// 对输入数据进行判断
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
		parmas.put("workerId", parmas.get("id"));
		companyWagesMapper.deleteById(parmas);
	}
	/**
	 * 修改人员信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void uptadeEmployee(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		
		String name = params.get("name").toString();
		String sex = params.get("sex").toString();
		String birthday = params.get("birthday").toString();
		String phoneNumber = params.get("phoneNumber").toString();
		String address =params.get("address").toString();
		String education =params.get("education").toString();
		String department =params.get("department").toString();
		String duty =params.get("duty").toString();
		
		// 判断输入数据的合法性
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
