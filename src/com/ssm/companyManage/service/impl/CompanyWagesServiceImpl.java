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
		Map<String, Object> map = inputObject.getParams();
		String workerid = map.get("workerid")+"";
		// 首先查询该薪金表中是否含有该员工，有的话提示错误，没有的话进行插入操作
		List<Map<String, Object>> list = companyWagesMapper.selectAllWages(null);
		for(int i = 0 ; i < list.size(); i ++){
			if(workerid.equals(list.get(i).get("wageId"))){
				return;
			}
		}
		
		companyWagesMapper.insertWages(map);
	}
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		companyWagesMapper.modifyWages(map);
	}
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		companyWagesMapper.deleteById(map);
	}

	/**
	 * 显示所有的职员姓名
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectAllWroker(InputObject inputObject,OutputObject outputObject) throws Exception {
		List<Map<String, Object>> list= companyWagesMapper.selectAllWroker();
		outputObject.setBeans(list);
		outputObject.settotal(list.size());
	}
}
