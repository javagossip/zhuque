/*
 * Copyright 2017-2019 The OpenAds Project
 *
 * The OpenAds Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package ai.houyi.zhuque.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.TemplateQueryReq;
import ai.houyi.zhuque.core.service.TemplateService;
import ai.houyi.zhuque.dao.model.Template;
import io.swagger.annotations.Api;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/templates")
@Api(tags= {"广告位模板管理"})
public class TemplateController implements IController<Template, TemplateQueryReq, Integer> {
	@Autowired
	private TemplateService templateService;

	@POST
	@Path
	public void saveOrUpdate(Template template) {
		if (template.getId() != null) {
			templateService.save(template);
		} else {
			templateService.update(template);
		}
	}

	@POST
	@Path("/delete/{templateId}")
	public void deleteById(Integer templateId) {
		templateService.softDeleteById(templateId);
	}

	@POST
	@Path("/list")
	public void selectAll() {
		templateService.selectAll();
	}

	@GET
	@Path("/{templateId}")
	public Template loadById(Integer templateId) {
		return templateService.loadById(templateId);
	}

	@GET
	@Path("/listByName")
	public List<Template> selectByName(String name) {
		return templateService.selectByName(name);
	}

	@POST
	@Path("/list")
	public Page<Template> selectPage(TemplateQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		return templateService.selectPageList(queryReq);
	}

}
