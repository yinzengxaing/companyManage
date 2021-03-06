package com.ssm.companyManage.service.impl;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ssm.companyManage.dao.CompanyManageMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.object.PutObject;
import com.ssm.companyManage.service.CompanyManageService;
/**
 * 管理员service实现类
 * @author kongliufeng
 *
 */
@Service
public class CompanyMangeServiceImple implements CompanyManageService {
	@Resource
	private CompanyManageMapper companyManageMapper;

	/**
	 * 管理员登录验证，并返回该管理员的姓名、id
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void judge(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		Map<String, Object> manage = companyManageMapper.judge(params);
		if (manage == null){
			outputObject.setreturnMessage("用户名或密码错误，请重新登录！");
			return;
		}else{
			outputObject.setreturnCode("0");
			outputObject.setLogParams(manage);
		}
	}

	/**
	 * 根据管理员id 更改管理员帐号密码
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void updateLoginnameAndPassword(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		companyManageMapper.updateLoginnameAndPassword(params);
		HttpServletRequest request = PutObject.getRequest();
		HttpSession session = request.getSession();
		//将session 设置为null
		session.removeAttribute("admTsyUser");
	}
	/**
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getAdmin(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> logParams = inputObject.getLogParams();
		outputObject.setBean(logParams);
		
	}

	/**
	 * 退出用户
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void escAdmin(InputObject inputObject, OutputObject outputObject) throws Exception {
		
		HttpServletRequest request = PutObject.getRequest();
		HttpSession session = request.getSession();
		//将session 设置为null
		session.removeAttribute("admTsyUser");
		
	}

}
