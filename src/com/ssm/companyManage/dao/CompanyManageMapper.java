package com.ssm.companyManage.dao;

import java.util.Map;
/**
 * 管理员mapper
 * @author kongliufeng
 *
 */
public interface CompanyManageMapper {
	//登录验证  并返回管理员姓名、id
	public Map<String, Object>  judge(Map<String , Object> map) throws Exception;

	//根据管理员id 更改帐号密码
	public Map<String, Object> updateLoginnameAndPassword(Map<String, Object> map) throws Exception;

}
