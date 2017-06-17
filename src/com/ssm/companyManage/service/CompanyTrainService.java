package com.ssm.companyManage.service;


import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

public interface CompanyTrainService {

	/**
	 * 显示全部的培训信息
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectAllTrain(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	/**
	 * 查询所有的员工的名称
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectTrainById(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	/**
	 * 插入培训信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertTrain(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	/**
	 * 通过trainId进行修改
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyById(InputObject inputObject, OutputObject outputObject) throws Exception;
	
	/**
	 * 通过trainId进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject, OutputObject outputObject) throws Exception;
	
}
