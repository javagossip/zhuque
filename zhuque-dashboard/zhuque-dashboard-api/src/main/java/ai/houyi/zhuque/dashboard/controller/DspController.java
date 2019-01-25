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
import ai.houyi.dorado.rest.annotation.DELETE;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.DspQueryReq;
import ai.houyi.zhuque.core.service.DspService;
import ai.houyi.zhuque.dao.model.Dsp;
import io.swagger.annotations.Api;

/**
 * @author weiping wang
 */
@Controller
@Path("/dsps")
@Api(tags= {"dsp平台管理"})
public class DspController implements IController<Dsp, DspQueryReq, Integer>{

	@Autowired
	private DspService dspService;

	@POST
	@Path
	public void saveOrUpdate(Dsp dsp) {
		if (dsp.getId() == null) {
			dspService.save(dsp);
		} else {
			dspService.update(dsp);
		}
	}

	@DELETE
	@Path("/{dspId:[0-9]+}")
	public void deleteById(Integer dspId) {
		dspService.softDeleteById(dspId);
	}

	@POST
	@Path("/{dspId}/on")
	public void dspOn(int dspId) {
		dspService.updateStatus(dspId, 1);
	}

	@POST
	@Path("/{dspId}/off")
	public void dspOff(int dspId) {
		dspService.updateStatus(dspId, 0);
	}

	@GET
	@Path("/{dspId:[0-9]+}")
	public Dsp loadById(Integer dspId) {
		return dspService.loadById(dspId);
	}

	@GET
	@Path("/{name}")
	public List<Dsp> selectByName(String name) {
		return dspService.selectByName(name);
	}

	@POST
	@Path("/list")
	public Page<Dsp> selectPage(DspQueryReq queryReq) {
		return dspService.selectPageList(queryReq);
	}
}
