package com.ssm.companyManage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.companyManage.dao.CompanyNewsMapper;
import com.ssm.companyManage.object.InputObject;
import com.ssm.companyManage.object.OutputObject;
import com.ssm.companyManage.service.CompanyNewsService;
import com.ssm.companyManage.util.JudgeUtil;
/**
 * 处理news 的service 实现类
 * @author yinzengxiang
 *
 */
@Service
public class CompanyNewsServiceImpl implements CompanyNewsService {
	@Resource
	private CompanyNewsMapper companyNewsMapper ;
	/**
	 * 获取所有的新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getNewsList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//进行分页
		//获取分页信息
/*		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> newsList = companyNewsMapper.getNewsList(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)newsList;
		//获取当前页数的总数
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(newsList);
		outputObject.settotal(total);*/
		List<Map<String,Object>> newsList = companyNewsMapper.getNewsList(params);
		outputObject.setBeans(newsList);
		outputObject.settotal(newsList.size());
		
	}

	/**
	 *	添加一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void addNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		
		String title = params.get("title").toString();
		String content = params.get("content").toString();
		String createTime = params.get("createTime").toString();
		//判断信息是否完整
		if (JudgeUtil.isNull(title) || JudgeUtil.isNull(content) || JudgeUtil.isNull(createTime)){
			outputObject.setreturnMessage("请将信息补充完整!");
			return;
		}
		//检查新闻标题是否已经存在
		Map<String, Object> newsByTitle = companyNewsMapper.getNewsByTitle(params);
		if (newsByTitle != null){
			outputObject.setreturnMessage("您输入的新闻标题已经存在，请重新输入！");
			return;
		}
		params.put("createId","1");
		companyNewsMapper.addNews(params);
	}
	/**
	 *	删除一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void deleteNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		companyNewsMapper.deleteNews(params);
	}
	
	/**
	 *	修改一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void updateNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		String id = params.get("id").toString();
		//检查修改后的标题是否已经存在
		Map<String, Object> newsByTitle = companyNewsMapper.getNewsByTitle(params);
		if (newsByTitle != null){
			String idByTitle = newsByTitle.get("id").toString();
			if (!idByTitle.endsWith(id)){
				outputObject.setreturnMessage("您输入的新闻标题已经存在，请重新输入!");
				return;
			}
			
		}
		companyNewsMapper.updateNews(params);
	}
	/**
	 *	根据id获取一条新闻
	 * @param inputObject
	 * @param outputObject
	 * @throws Exception
	 */
	public void getNewsById(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		Map<String, Object> newsById = companyNewsMapper.getNewsById(params);
		outputObject.setBean(newsById);
	}
}
