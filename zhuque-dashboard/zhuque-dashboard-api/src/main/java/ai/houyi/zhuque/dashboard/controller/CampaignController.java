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

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.AuthContext;
import ai.houyi.zhuque.core.model.query.CampaignQueryReq;
import ai.houyi.zhuque.core.service.CampaignService;
import ai.houyi.zhuque.dao.model.Campaign;
import ai.houyi.zhuque.dao.model.CampaignExample;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/campaign")
public class CampaignController implements IController<Campaign, CampaignExample, Integer> {
	@Autowired
	private CampaignService campaignService;

	@Override
	public void saveOrUpdate(Campaign t) {
		t.setAdvertiserId(AuthContext.currentUser().getId());
		if (t.getId() == null) {
			campaignService.save(t);
		} else {
			campaignService.update(t);
		}
	}

	@Override
	public void deleteById(Integer id) {
		campaignService.softDeleteById(id);
	}

	@Override
	public Campaign loadById(Integer id) {
		return campaignService.loadById(id);
	}

	@Override
	public Page<Campaign> selectPage(PageQueryReq<CampaignExample> queryReq) {
		CampaignQueryReq _queryReq = (CampaignQueryReq) queryReq;
		_queryReq.setAdvertiserIds(Arrays.asList(AuthContext.currentUser().getId()));

		return campaignService.selectPageList(_queryReq);
	}

}
