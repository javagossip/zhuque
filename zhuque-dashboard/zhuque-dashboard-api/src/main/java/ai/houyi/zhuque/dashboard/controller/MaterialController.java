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
import ai.houyi.zhuque.core.model.query.MaterialQueryReq;
import ai.houyi.zhuque.core.service.MaterialService;
import ai.houyi.zhuque.dao.model.Material;
import io.swagger.annotations.Api;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/materials")
@Api(tags= {"广告素材管理"})
public class MaterialController implements IController<Material, MaterialQueryReq, Integer> {
	@Autowired
	private MaterialService materialService;

	@POST
	@Path
	public void saveOrUpdate(Material t) {
		if (t.getId() == null) {
			materialService.save(t);
		} else {
			materialService.update(t);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteById(Integer id) {
		materialService.deleteById(id);
	}

	@GET
	@Path("/{id}")
	public Material loadById(Integer id) {
		return materialService.loadById(id);
	}

	@POST
	@Path("/list")
	public Page<Material> selectPage(MaterialQueryReq queryReq) {
		return materialService.selectPageList(queryReq);
	}
}
