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
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.BaseController;
import ai.houyi.zhuque.core.service.MaterialService;
import ai.houyi.zhuque.dao.model.Material;
import ai.houyi.zhuque.dao.model.MaterialExample;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/material")
public class MaterialController implements BaseController<Material, MaterialExample, Integer> {
	@Autowired
	private MaterialService materialService;
	
	@Override
	public void saveOrUpdate(Material t) {
		if(t.getId()==null) {
			materialService.save(t);
		}else {
			materialService.update(t);
		}
	}

	@Override
	public void deleteById(Integer id) {
		materialService.deleteById(id);
	}

	@Override
	public Material loadById(Integer id) {
		return materialService.loadById(id);
	}

	@Override
	public Page<Material> selectPage(PageQueryReq<MaterialExample> queryReq) {
		return materialService.selectPageList(queryReq);
	}

}
