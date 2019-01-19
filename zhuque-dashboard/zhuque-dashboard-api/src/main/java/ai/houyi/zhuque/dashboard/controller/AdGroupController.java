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
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.AuthContext;
import ai.houyi.zhuque.core.model.query.AdGroupQueryReq;
import ai.houyi.zhuque.core.service.AdGroupService;
import ai.houyi.zhuque.dao.model.AdGroup;

/**
 * 广告组管理
 * 
 * @author weiping wang
 */
@Controller
@Path("/adgroups")
public class AdGroupController implements IController<AdGroup, AdGroupQueryReq, Integer> {
	@Autowired
	private AdGroupService adGroupService;

	@POST
	@Path
	public void saveOrUpdate(AdGroup t) {
		if (t.getId() == null) {
			adGroupService.save(t);
		} else {
			adGroupService.update(t);
		}
	}

	@POST
	@Path("/{id}")
	public void deleteById(Integer id) {
		adGroupService.softDeleteById(id);
	}

	@GET
	@Path("/{id}")
	public AdGroup loadById(Integer id) {
		return adGroupService.loadById(id);
	}

	@POST
	@Path("/list")
	public Page<AdGroup> selectPage(AdGroupQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		queryReq.setAdvertiserId(AuthContext.currentUser().getId());

		return adGroupService.selectPageList(queryReq);
	}
}
