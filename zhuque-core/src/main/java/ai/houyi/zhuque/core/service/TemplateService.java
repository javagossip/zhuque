/**
 * 
 */
package ai.houyi.zhuque.core.service;

import java.util.List;

import ai.houyi.zhuque.core.IService;
import ai.houyi.zhuque.core.model.query.TemplateQueryReq;
import ai.houyi.zhuque.dao.model.Template;

/**
 * @author Administrator
 *
 */
public interface TemplateService extends IService<Template, TemplateQueryReq, Integer>{
	
	List<Template> selectByName(String name);
}
 