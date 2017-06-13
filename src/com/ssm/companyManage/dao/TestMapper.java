package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

public interface TestMapper {
	
	public List<Map<String, Object>> getList(Map<String, Object> map);
	
	public List<Map<String, Object>> getListById(Map<String, Object> map);
	
	public List<Map<String, Object>> getListByNmae(Map<String, Object> map);
	
	public List<Map<String, Object>> getListByIdAndName(Map<String, Object> map);
}
