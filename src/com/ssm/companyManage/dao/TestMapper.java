package com.ssm.companyManage.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface TestMapper {
	
	//获取一组信息
	public List<Map<String, Object>> getList(Map<String, Object> map);
	
	public List<Map<String, Object>> getList(Map<String, Object> map,PageBounds bounds);
	
	public List<Map<String, Object>> getListById(Map<String, Object> map);
	
	public List<Map<String, Object>> getListByNmae(Map<String, Object> map);
	//获取一个信息
	public Map<String, Object> getNmae(Map<String, Object> map);
}
