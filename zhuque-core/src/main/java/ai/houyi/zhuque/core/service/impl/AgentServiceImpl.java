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
package ai.houyi.zhuque.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.service.AgentService;
import ai.houyi.zhuque.dao.AgentMapper;
import ai.houyi.zhuque.dao.model.Agent;
import ai.houyi.zhuque.dao.model.AgentExample;

/**
 *
 * @author weiping wang
 */
@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentMapper agentMapper;

	@Override
	public void save(Agent t) {
		agentMapper.insertSelective(t);
	}

	@Override
	public void update(Agent t) {
		agentMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		agentMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		Agent agent = new Agent();
		agent.setId(pk);
		agent.setDeleted(true);

		agentMapper.updateByPrimaryKeySelective(agent);
	}

	@Override
	public Agent loadById(Integer pk) {
		return agentMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Agent> selectAll() {
		return agentMapper.selectByExample(new AgentExample());
	}

	@Override
	public List<Agent> selectByQueryReq(QueryReq<AgentExample> queryReq) {
		return agentMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Agent> selectPageList(PageQueryReq<AgentExample> queryReq) {
		AgentExample example = queryReq.toExample();

		int total = (int) agentMapper.countByExample(example);
		List<Agent> result = agentMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public void updateStatus(int agentId, int status) {
		Agent agent = new Agent();
		agent.setId(agentId);
		agent.setStatus(status);

		agentMapper.updateByPrimaryKeySelective(agent);
	}

	@Override
	public List<Agent> selectByName(String name) {
		if (name == null)
			ExceptionUtils.throwZhuqueException("名称不能为空");

		AgentExample example = new AgentExample().createCriteria().andNameLike(SQLUtils.toLikeString(name)).example();
		return agentMapper.selectByExample(example);
	}
}
