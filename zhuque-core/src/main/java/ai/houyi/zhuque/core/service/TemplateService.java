/**
 * 
 */
package ai.houyi.zhuque.core.service;

import java.util.List;

import ai.houyi.zhuque.core.BaseService;
import ai.houyi.zhuque.dao.model.Agent;
import ai.houyi.zhuque.dao.model.Template;
import ai.houyi.zhuque.dao.model.TemplateExample;

/**
 * @author Administrator
 *
 */
public interface TemplateService extends BaseService<Template, TemplateExample, Integer>{

	//void save(Template t);
	
	//void update(Template te);
	
	List<Template> selectByName(String name);

}
 