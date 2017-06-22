package com.ssm.companyManage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.companyManage.dao.CompanyTrainMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyTrainService;
import com.ssm.companyManage.util.JudgeUtil;
/**
 * 员工培训
* Title: CompanyTrainServiceImpl
* Description: 
* Company: 
* @author zhangtaoxiang
* @param 
* @throws 
* @date 2017-6-16上午9:50:23
 */
@Service
public class CompanyTrainServiceImpl implements CompanyTrainService{

	@Resource
	CompanyTrainMapper companyTrainMapper;
	/**
	 * 显示全部的培训信息
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectAllTrain(InputObject inputObject,	OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		// 进行分页
		int page = Integer.parseInt(map.get("page").toString());
		int limit = 10 ; // 定义每一页的条数
		
		List<Map<String, Object>> list = companyTrainMapper.selectAllTrain(map, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String,Object>>)list;
		// 获取当前的总页数
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		// 保存分页信息的Map
		Map<String, Object> pageMap = new HashMap<String,Object>();
		pageMap.put("page", page);
		int totalPage = total / limit; // 计算页数
		if(total % limit != 0)
			totalPage = totalPage + 1;
		if (total  <= 0){
			totalPage = 1;
		}
		pageMap.put("totalPage", totalPage);
		outputObject.setBean(pageMap);
		outputObject.setBeans(list);
		outputObject.settotal(total);
	}

	/**
	 * 查询所有的员工的名称
	 * @param inputObject
	 * @param outputObject
	 * @return
	 * @throws Exception
	 */
	public void selectTrainById(InputObject inputObject,OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		Map<String, Object> trainMap = companyTrainMapper.selectTrainById(map);
		outputObject.setBean(trainMap);
	}

	/**
	 * 插入培训信息
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void insertTrain(InputObject inputObject, OutputObject outputObject)	throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		String 	trainTitle = map.get("trainTitle").toString();
		String trainLecturer = map.get("trainLecturer").toString();
		String trainTime = map.get("trainTime").toString();
		String other = map.get("other").toString();
		
		if(JudgeUtil.isNull(trainTitle)){
			outputObject.setreturnMessage("标题不能为空！！！");
			return;
		}
		if(JudgeUtil.isNull(trainLecturer)){
			outputObject.setreturnMessage("讲师不能为空！！！");
			return ;
		}
		if(JudgeUtil.isNull(trainTime)){
			outputObject.setreturnMessage("培训时间不能为空！！！");
			return ;
		}
		if(JudgeUtil.isNull(other)){
			outputObject.setreturnMessage("培训内容不能为空！！！");
			return ;
		}
		companyTrainMapper.insertTrain(map);
	}

	/**
	 * 通过trainId进行修改
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void modifyById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		String 	trainTitle = map.get("trainTitle").toString();
		String trainLecturer = map.get("trainLecturer").toString();
		String trainTime = map.get("trainTime").toString();
		String other = map.get("other").toString();
		
		if(JudgeUtil.isNull(trainTitle)){
			outputObject.setreturnMessage("标题不能为空！！！");
			return;
		}
		if(JudgeUtil.isNull(trainLecturer)){
			outputObject.setreturnMessage("讲师不能为空！！！");
			return ;
		}
		if(JudgeUtil.isNull(trainTime)){
			outputObject.setreturnMessage("培训时间不能为空！！！");
			return ;
		}
		if(JudgeUtil.isNull(other)){
			outputObject.setreturnMessage("培训内容不能为空！！！");
			return ;
		}
		companyTrainMapper.modifyById(map);
	}

	/**
	 * 通过trainId进行删除
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteById(InputObject inputObject, OutputObject outputObject)throws Exception {
		Map<String, Object> map = inputObject.getParams();
		companyTrainMapper.deleteById(map);
	}
}
