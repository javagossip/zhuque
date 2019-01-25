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
import ai.houyi.dorado.rest.annotation.DELETE;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.CreativeQueryReq;
import ai.houyi.zhuque.core.service.CreativeService;
import ai.houyi.zhuque.dao.model.Creative;
import io.swagger.annotations.Api;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/creatives")
@Api(tags="推广创意管理")
public class CreativeController implements IController<Creative,CreativeQueryReq,Integer>{
	@Autowired
	private CreativeService creativeService;

	@POST
	@Path
	public void saveOrUpdate(Creative creative) {
		if (creative.getId() == null)
			creativeService.save(creative);
		else
			creativeService.update(creative);
	}

	@DELETE
	@Path("/{creativeId}")
	public void deleteById(Integer creativeId) {
		creativeService.deleteById(creativeId);
	}

	@GET
	@Path("/{creativeId}")
	public Creative loadById(Integer creativeId) {
		return creativeService.loadById(creativeId);
	}
	
	@POST
	@Path("/list")
	public Page<Creative> selectPage(CreativeQueryReq queryReq){
		return creativeService.selectPageList(queryReq);
	}
}
