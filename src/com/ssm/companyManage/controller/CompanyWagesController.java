package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyWagesService;

@Controller
public class CompanyWagesController {

	@Resource
	CompanyWagesService companyWagesService;

	/**
	 * 显示多有和通过条件模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyWagesController/selectAllWages")
	@ResponseBody
	public void selectAllWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		companyWagesService.selectAllWages(inputObject, outputObject);
	}
	
	/**
	 * 插入数据
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyWagesController/insertWages")
	@ResponseBody
	public void insertWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		companyWagesService.insertWages(inputObject, outputObject);
	}
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyWagesController/modifyWages")
	@ResponseBody
	public void modifyWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		companyWagesService.modifyWages(inputObject, outputObject);
	}
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyWagesController/deleteById")
	@ResponseBody
	public void deleteById(InputObject inputObject , OutputObject outputObject) throws Exception{
		companyWagesService.deleteById(inputObject, outputObject);
	}
}
