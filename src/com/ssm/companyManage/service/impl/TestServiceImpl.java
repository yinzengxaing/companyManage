package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.TestMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper testMapper;
	public void getList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		List<Map<String, Object>> list = testMapper.getList(params);
		outputObject.setBeans(list);
	}

}
