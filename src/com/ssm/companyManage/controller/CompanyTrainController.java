package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyTrainService;

@Controller
public class CompanyTrainController {

	@Resource
	CompanyTrainService companyTrainService;
	/**
	 * 显示全部的培训信息
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyTrainController/selectAllTrain")
	@ResponseBody
	public void selectAllTrain(InputObject inputObject, OutputObject outputObject) throws Exception{
		companyTrainService.selectAllTrain(inputObject, outputObject);
	}
	
	/**
	 * 
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyTrainController/selectTrainById")
	@ResponseBody
	public void selectTrainById(InputObject inputObject, OutputObject outputObject) throws Exception{
		companyTrainService.selectTrainById(inputObject, outputObject);
	}
	
	/**
	 * 插入培训信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyTrainController/insertTrain")
	@ResponseBody
	public void insertTrain(InputObject inputObject, OutputObject outputObject) throws Exception{
		companyTrainService.insertTrain(inputObject, outputObject);
	}
	
	/**
	 * 通过trainId进行修改
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyTrainController/modifyById")
	@ResponseBody
	public void modifyById(InputObject inputObject, OutputObject outputObject) throws Exception{
		companyTrainService.modifyById(inputObject, outputObject);
	}
	
	/**
	 * 通过trainId进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	@RequestMapping("/post/CompanyTrainController/deleteById")
	@ResponseBody
	public void deleteById(InputObject inputObject, OutputObject outputObject) throws Exception{
		companyTrainService.deleteById(inputObject, outputObject);
	}
	
}
