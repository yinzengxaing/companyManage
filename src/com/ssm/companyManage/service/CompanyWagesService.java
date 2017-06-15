package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 员工薪资service
* Title: CompanyWagesService
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-14下午5:18:24
 */
public interface CompanyWagesService {

	/**
	 * 显示多有和通过条件模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectAllWages(InputObject inputObject , OutputObject outputObject) throws Exception;
	
	/**
	 * 插入数据
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertWages(InputObject inputObject , OutputObject outputObject) throws Exception;
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyWages(InputObject inputObject , OutputObject outputObject) throws Exception;
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject , OutputObject outputObject) throws Exception;

	/**
	 * 显示所有的职员姓名
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectAllWroker(InputObject inputObject , OutputObject outputObject) throws Exception;
}
