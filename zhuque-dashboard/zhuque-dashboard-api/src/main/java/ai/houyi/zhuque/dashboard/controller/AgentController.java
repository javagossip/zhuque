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
import ai.houyi.zhuque.core.model.query.AgentQueryReq;
import ai.houyi.zhuque.core.service.AgentService;
import ai.houyi.zhuque.dao.model.Agent;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/agent")
public class AgentController {
	@Autowired
	private AgentService agentService;

	@POST
	@Path
	public void saveOrUpdateAgent(Agent agent) {
		if (agent.getId() != null) {
			agentService.save(agent);
		} else {
			agentService.update(agent);
		}
	}

	@POST
	@Path("/delete/{agentId}")
	public void deleteById(int agentId) {
		agentService.softDeleteById(agentId);
	}
	
	@POST
	@Path("/on/{agentId}")
	public void agentOn(int agentId) {
		agentService.updateStatus(agentId,1);
	}
	
	@POST
	@Path("/off/{agentId}")
	public void agentOff(int agentId) {
		agentService.updateStatus(agentId,0);
	}
	
	@GET
	@Path("/{agentId}")
	public Agent loadAgentById(int agentId) {
		return agentService.loadById(agentId);
	}
	
	@GET
	@Path("/listByName")
	public List<Agent> selectByName(String name){
		return agentService.selectByName(name);
	}
	
	@POST
	@Path("/list")
	public Page<Agent> selectPage(AgentQueryReq queryReq){
		return agentService.selectPageList(queryReq);
	}
}
