/**
 * 
 */
package ai.houyi.zhuque.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.TemplateQueryReq;
import ai.houyi.zhuque.core.service.TemplateService;
import ai.houyi.zhuque.dao.TemplateMapper;
import ai.houyi.zhuque.dao.model.Template;
import ai.houyi.zhuque.dao.model.TemplateExample;

/**
 * @author Administrator
 *
 */
@Service
public class TemplateServiceImpl implements TemplateService{
	@Autowired 
	private TemplateMapper templateMapper;
	
	@Override
	public void save(Template t) {
		templateMapper.insert(t);	
	}
	
	@Override
	public void update(Template t) {
		templateMapper.updateByPrimaryKeySelective(t);
	}
	
	@Override
	public void deleteById(Integer id) {
		templateMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void softDeleteById(Integer pk) {
		Template  tem = new Template();
		tem.setId(pk);
		tem.setDeleted(true);
		templateMapper.updateByPrimaryKeySelective(tem);
		
	}

	@Override
	public Template loadById(Integer pk) {
		// TODO 自动生成的方法存根
		return templateMapper.selectByPrimaryKey(pk);	 
	}

	@Override
	public List<Template> selectAll() {
		TemplateExample tem = new TemplateExample();
		return templateMapper.selectByExample(tem);
		
	}

	@Override
	public List<Template> selectByQueryReq(TemplateQueryReq queryReq) {
		// TODO 自动生成的方法存根
		TemplateExample tem = queryReq.toExample();
		return templateMapper.selectByExample(tem);
		
		//return templateMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Template> selectPageList(TemplateQueryReq queryReq) {
		// TODO 自动生成的方法存根
		TemplateExample te = queryReq.toExample();
		int in = (int) templateMapper.countByExample(te);
		List<Template> list = templateMapper.selectByExample(te);
		return Page.create(in, queryReq.getPageSize(), list);
	}
	
	@Override
	public List<Template> selectByName(String name){
		if (name == null) {
			ExceptionUtils.throwZhuqueException("名称不可为空");
		}
		TemplateExample example = new TemplateExample();
		example.createCriteria().andNameLike(SQLUtils.toLikeString(name)).example();
		return templateMapper.selectByExample(example);
		
	}
	
	

	

}
