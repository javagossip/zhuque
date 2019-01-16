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

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.core.service.TemplateService;
import ai.houyi.zhuque.dao.model.Template;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/Template")
public class TemplateController {
	@Autowired
	private TemplateService templateService;
	
	@POST
	@Path
	public void saveOrupdateTemplate(Template template) {
		if(template.getId() != null) {
			templateService.save(template);
		}
		else {templateService.update(template);
		}	
	}
	
	@POST
	@Path("/delete/{templateid}")
	public void deleteById(int templateid) {
		templateService.softDeleteById(templateid);
	}
	
	@POST
	@Path("/selectAll")
	public void selectAll() {
		templateService.selectAll();	
	}
	
	@GET
	@Path("/{loadById}")
	public Template loadById(Integer pk) {
		return templateService.loadById(pk);
		
	}
	
	
}
