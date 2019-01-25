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

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.dao.model.CampaignExample;

/**
 *
 * @author weiping wang
 */
public class CampaignQueryReq extends QueryReq<CampaignExample> {
	private String name;
	private List<Integer> advertiserIds;
	private Integer status;

	@Override
	public CampaignExample buildExample() {
		CampaignExample example = new CampaignExample();
		CampaignExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(name))
			criteria.andNameLike(SQLUtils.toLikeString(name));
		if (!CollectionUtils.isEmpty(advertiserIds))
			criteria.andAdvertiserIdIn(advertiserIds);
		if (status != null)
			criteria.andStatusEqualTo(status);

		if (pageNo != null && pageSize != null) {
			example.page(pageNo, pageSize);
		}
		return example;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param advertiserIds the advertiserIds to set
	 */
	public void setAdvertiserIds(List<Integer> advertiserIds) {
		this.advertiserIds = advertiserIds;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
