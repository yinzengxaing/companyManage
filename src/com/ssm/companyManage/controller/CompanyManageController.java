package com.ssm.companyManage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyManageService;



@Controller
public class CompanyManageController {
    @Resource
	private CompanyManageService  companyManageService;

    /**
	 * 管理员登录验证，并返回该管理员的姓名、id
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
    
    @RequestMapping("/post/CompanyManageController/judge")
	@ResponseBody
    public void judge(InputObject inputObject,OutputObject outputObject) throws Exception{
    	companyManageService.judge(inputObject, outputObject);
    }
    
    /**
	 * 根据管理员id 更改管理员帐号密码
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
    @RequestMapping("/post/CompanyManageController/updateLoginnameAndPassword")
   	@ResponseBody
   	public void updateLoginnameAndPassword(InputObject inputObject,OutputObject outputObject) throws Exception{
    	companyManageService.judge(inputObject, outputObject);
    }
    
    
}
