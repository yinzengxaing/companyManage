package com.ssm.companyManage.service;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;

/**
 * 管理员的service
 * @author kongliufeng
 *
 */
public interface CompanyManageService {
	//登录验证  并返回管理员姓名、id
	public void judge(InputObject inputObject,OutputObject outputObject) throws Exception;
	//根据管理员id 更改帐号密码
	public void updateLoginnameAndPassword(InputObject inputObject,OutputObject outputObject) throws Exception;
}
