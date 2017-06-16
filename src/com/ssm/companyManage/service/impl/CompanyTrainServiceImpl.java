package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.CompanyTrainMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyTrainService;
/**
 * 员工培训
* Title: CompanyTrainServiceImpl
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-16上午9:50:23
 */
@Service
public class CompanyTrainServiceImpl implements CompanyTrainService{

	@Resource
	CompanyTrainMapper companyTrainMapper;
	
	/**
	 * 显示全部的培训信息
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectAllTrain(InputObject inputObject,	OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		List<Map<String, Object>> list = companyTrainMapper.selectAllTrain(map);
		outputObject.setBeans(list);
		outputObject.settotal(list.size());
		
	}

	/**
	 * 查询所有的员工的名称
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectAllEmployee(InputObject inputObject,OutputObject outputObject) throws Exception {
		List<Map<String, Object>> list = companyTrainMapper.selectAllEmployee();
		outputObject.setBeans(list);
		outputObject.settotal(list.size());
	}

	/**
	 * 插入培训信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertTrain(InputObject inputObject, OutputObject outputObject)	throws Exception {
		Map<String, Object> map = inputObject.getParams();
		companyTrainMapper.insertTrain(map);
	}

	/**
	 * 通过trainId进行修改
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		companyTrainMapper.modifyById(map);
	}

	/**
	 * 通过trainId进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject, OutputObject outputObject)throws Exception {
		Map<String, Object> map = inputObject.getParams();
		companyTrainMapper.deleteById(map);
	}

}
