package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.TestService;

@Controller
public class TestController {

	@Resource
	private TestService testService ;
	
	@RequestMapping("/post/TestController/getList")
	@ResponseBody
	public void getList(InputObject inputObject,OutputObject outputObject) throws Exception{
		testService.getList(inputObject, outputObject);
	}
}
