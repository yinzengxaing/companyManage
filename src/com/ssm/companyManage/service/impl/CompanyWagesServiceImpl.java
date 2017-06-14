package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.CompanyWagesMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyWagesService;

/**
 * 员工薪资实现
* Title: CompanyWagesServiceImpl
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-14下午5:19:17
 */
@Service
public class CompanyWagesServiceImpl implements CompanyWagesService{

	@Resource
	CompanyWagesMapper companyWagesMapper;

	/**
	 * 显示多有和通过条件模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectAllWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		List<Map<String, Object>> list =  companyWagesMapper.selectAllWages(map);
		
		outputObject.setBeans(list);
		outputObject.settotal(list.size());
	}
	
	/**
	 * 插入数据
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		
	}
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		
	}
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject , OutputObject outputObject) throws Exception{
		
	}

	
	
}
