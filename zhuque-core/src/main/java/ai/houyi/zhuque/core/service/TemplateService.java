/**
 * 
 */
package ai.houyi.zhuque.core.service;

import java.util.List;

import ai.houyi.zhuque.core.IService;
import ai.houyi.zhuque.dao.model.Agent;
import ai.houyi.zhuque.dao.model.Template;
import ai.houyi.zhuque.dao.model.TemplateExample;

/**
 * @author Administrator
 *
 */
public interface TemplateService extends IService<Template, TemplateExample, Integer>{

	//void save(Template t);
	
	//void update(Template te);
	
	List<Template> selectByName(String name);

}
 