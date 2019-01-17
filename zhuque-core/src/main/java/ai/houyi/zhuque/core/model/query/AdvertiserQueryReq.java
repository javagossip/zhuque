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
package ai.houyi.zhuque.core.model.query;

import org.apache.commons.lang3.StringUtils;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.dao.model.AdvertiserExample;

/**
 *
 * @author weiping wang
 */
public class AdvertiserQueryReq extends QueryReq<AdvertiserExample> {
	private String name;
	private Integer id;
	private Integer status;
	private Integer agentId;

	@Override
	public AdvertiserExample toExample() {
		AdvertiserExample example = new AdvertiserExample();
		AdvertiserExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(name))
			criteria.andNameLike(SQLUtils.toLikeString(name));
		if (id != null)
			criteria.andIdEqualTo(id);
		if (status != null)
			criteria.andStatusEqualTo(status);
		if (agentId != null)
			criteria.andAgentIdEqualTo(agentId);
		
		example.page(pageNo, pageSize);
		return example;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public Integer getStatus() {
		return status;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
