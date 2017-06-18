package com.ssm.companyManage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.companyManage.dao.CompanyWagesMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyWagesService;
import com.ssm.companyManage.util.JudgeUtil;

/**
 * 员工薪资实现
* Title: CompanyWagesServiceImpl
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-14下午5:19:17
 */
@Service
public class CompanyWagesServiceImpl implements CompanyWagesService{

	@Resource
	CompanyWagesMapper companyWagesMapper;
	private String regx = "[1-9]?[0-9]*(\\.[0-9]{1,2})?";
	
	/**
	 * 显示多有和通过条件模糊查询
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	//companyWagesMapper.selectAllWages(map, new PageBounds(page, limit));
	public void selectAllWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> params = inputObject.getParams();
		//进行分页
		int page =Integer.parseInt(params.get("page").toString()); //当前页；
		int limit = 10; //定义每一页条数
		List<Map<String,Object>> newsList = companyWagesMapper.selectAllWages(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)newsList;
		//获取当前页数的总数
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		//保存分页信息的Map
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("page", page);
		int totalPage = total/limit; //计算页数
		if (total%limit != 0)
			totalPage = totalPage+1;
		if (total  <= 0){
			totalPage = 1;
		}
		pageMap.put("totalPage",totalPage);
		outputObject.setBeans(newsList);
		outputObject.settotal(total);
		outputObject.setBean(pageMap);
	}
	
	/**
	 * 插入数据
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		String wageBase = map.get("wageBase").toString();
		String wagePlace = map.get("wagePlace").toString();
		String wageAdd = map.get("wageAdd").toString();
		String wageOutAch = map.get("wageOutAch").toString();
		String wageLengYear = map.get("wageLengYear").toString();
		if(JudgeUtil.isNull(wageBase) // 判断是否为空
				|| JudgeUtil.isNull(wagePlace) //
				|| JudgeUtil.isNull(wageAdd)   //
				|| JudgeUtil.isNull(wageOutAch)//
				|| JudgeUtil.isNull(wageLengYear) ){
			outputObject.setreturnMessage("工资不能为空！！！");
			return;
		}
		if(map.get("wageBase").toString().matches(regx) // 判断格式是否正确
			&& map.get("wagePlace").toString().matches(regx) //
			&& map.get("wageAdd").toString().matches(regx) //
			&& map.get("wageOutAch").toString().matches(regx) //
			&& map.get("wageLengYear").toString().matches(regx) ){
			companyWagesMapper.modifyWages(map);
			}
		else{
			outputObject.setreturnMessage("请输入正确的工资格式！！！");
			return;
		}
		companyWagesMapper.insertWages(map);
	}
	
	/**
	 * 通过id进行修改工资信息 
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyWages(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		String wageBase = map.get("wageBase").toString();
		String wagePlace = map.get("wagePlace").toString();
		String wageAdd = map.get("wageAdd").toString();
		String wageOutAch = map.get("wageOutAch").toString();
		String wageLengYear = map.get("wageLengYear").toString();
		if(JudgeUtil.isNull(wageBase) // 判断是否为空
				|| JudgeUtil.isNull(wagePlace) //
				|| JudgeUtil.isNull(wageAdd)   //
				|| JudgeUtil.isNull(wageOutAch)//
				|| JudgeUtil.isNull(wageLengYear) ){
			outputObject.setreturnMessage("工资不能为空！！！");
			return;
		}
		if(map.get("wageBase").toString().matches(regx) // 判断格式是否正确
			&& map.get("wagePlace").toString().matches(regx) //
			&& map.get("wageAdd").toString().matches(regx) //
			&& map.get("wageOutAch").toString().matches(regx) //
			&& map.get("wageLengYear").toString().matches(regx) ){
			companyWagesMapper.modifyWages(map);
			}
		else{
			outputObject.setreturnMessage("请输入正确的工资格式！！！");
			return;
		}
	}
	
	/**
	 * 通过wageId 进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject , OutputObject outputObject) throws Exception{
		Map<String, Object> map = inputObject.getParams();
		companyWagesMapper.deleteById(map);
	}

	/**
	 * 显示所有的职员姓名
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectAllWroker(InputObject inputObject,OutputObject outputObject) throws Exception {
		List<Map<String, Object>> list= companyWagesMapper.selectAllWroker();
		outputObject.setBeans(list);
		outputObject.settotal(list.size());
	}

	/**
	 * 通过wagesId查询信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void selectById(InputObject inputObject, OutputObject outputObject)throws Exception {
		Map<String, Object> map = inputObject.getParams();
		List<Map<String, Object>> wagesMap = companyWagesMapper.selectById(map);
		outputObject.setBeans(wagesMap);
	}
}
