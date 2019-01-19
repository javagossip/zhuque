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
import ai.houyi.dorado.rest.annotation.RequestParam;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.AgentQueryReq;
import ai.houyi.zhuque.core.service.AgentService;
import ai.houyi.zhuque.dao.model.Agent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/agents")
@Api(tags= {"代理商管理api"})
public class AgentController implements IController<Agent, AgentQueryReq, Integer> {
	@Autowired
	private AgentService agentService;

	@POST
	@Path
	@ApiOperation("新建/更新代理商")
	public void saveOrUpdate(Agent agent) {
		if (agent.getId() == null) {
			agentService.save(agent);
		} else {
			agentService.update(agent);
		}
	}

	@POST
	@Path("/{agentId}")
	@ApiOperation("删除代理商")
	public void deleteById(Integer agentId) {
		agentService.softDeleteById(agentId);
	}

	@POST
	@Path("/{agentId}/on")
	public void agentOn(int agentId) {
		agentService.updateStatus(agentId, 1);
	}

	@POST
	@Path("/{agentId}/off")
	public void agentOff(int agentId) {
		agentService.updateStatus(agentId, 0);
	}

	@GET
	@Path("/{agentId}")
	public Agent loadById(Integer agentId) {
		return agentService.loadById(agentId);
	}

	@GET
	@Path("/list/{name}")
	public List<Agent> selectByName(@RequestParam String name) {
		return agentService.selectByName(name);
	}

	@POST
	@Path("/list")
	public Page<Agent> selectPage(AgentQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		return agentService.selectPageList(queryReq);
	}
}
