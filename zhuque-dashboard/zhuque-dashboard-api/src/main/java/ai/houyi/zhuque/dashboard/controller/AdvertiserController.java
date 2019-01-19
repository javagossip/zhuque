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
import ai.houyi.zhuque.core.model.AuthContext;
import ai.houyi.zhuque.core.model.query.AdvertiserQueryReq;
import ai.houyi.zhuque.core.service.AdvertiserService;
import ai.houyi.zhuque.dao.model.Advertiser;

/**
 * 广告主管理
 * 
 * @author weiping wang
 */
@Controller
@Path("/advertiser")
public class AdvertiserController implements IController<Advertiser, AdvertiserQueryReq, Integer> {
	@Autowired
	private AdvertiserService advertiserService;

	@POST
	@Path
	public void saveOrUpdate(Advertiser advertiser) {
		if (advertiser.getId() == null) {
			advertiserService.save(advertiser);
		} else {
			advertiserService.update(advertiser);
		}
	}

	@POST
	@Path("/delete/{advertiserId}")
	public void deleteById(Integer advertiserId) {
		advertiserService.softDeleteById(advertiserId);
	}

	@POST
	@Path("/on/{advertiserId}")
	public void on(Integer advertiserId) {
		advertiserService.updateStatus(advertiserId, 1);
	}

	@POST
	@Path("/off/{advertiserId}")
	public void off(Integer advertiserId) {
		advertiserService.updateStatus(advertiserId, 0);
	}

	@GET
	@Path("/{advertiserId}")
	public Advertiser loadById(Integer advertiserId) {
		return advertiserService.loadById(advertiserId);
	}

	@GET
	@Path("/list/name/{name}")
	public List<Advertiser> selectByName(String name) {
		return advertiserService.selectByName(name);
	}

	@POST
	@Path("/list")
	public Page<Advertiser> selectPage(AdvertiserQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		queryReq.setAgentId(AuthContext.currentUser().getId());
		return advertiserService.selectPageList(queryReq);
	}
}
