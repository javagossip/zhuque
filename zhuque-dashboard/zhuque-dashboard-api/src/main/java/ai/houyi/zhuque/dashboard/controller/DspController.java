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
import ai.houyi.zhuque.core.model.query.DspQueryReq;
import ai.houyi.zhuque.core.service.DspService;
import ai.houyi.zhuque.dao.model.Dsp;

/**
 * @author weiping wang
 */
@Controller
@Path("/dsp")
public class DspController {

	@Autowired
	private DspService dspService;

	@POST
	@Path
	public void saveOrUpdateDsp(Dsp dsp) {
		if (dsp.getId() != null) {
			dspService.save(dsp);
		} else {
			dspService.update(dsp);
		}
	}

	@POST
	@Path("/delete/{dspId}")
	public void deleteById(int dspId) {
		dspService.softDeleteById(dspId);
	}

	@POST
	@Path("/on/{dspId}")
	public void dspOn(int dspId) {
		dspService.updateStatus(dspId, 1);
	}

	@POST
	@Path("/off/{dspId}")
	public void dspOff(int dspId) {
		dspService.updateStatus(dspId, 0);
	}

	@GET
	@Path("/{dspId}")
	public Dsp loadById(int dspId) {
		return dspService.loadById(dspId);
	}

	@GET
	@Path("/listByName")
	public List<Dsp> selectByName(String name) {
		return dspService.selectByName(name);
	}

	@POST
	@Path("/list")
	public Page<Dsp> selectPage(DspQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		return dspService.selectPageList(queryReq);
	}
}
