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
import ai.houyi.zhuque.dao.model.AdGroupExample;

/**
 *
 * @author weiping wang
 */
public class AdGroupQueryReq extends QueryReq<AdGroupExample> {
	private Integer id;
	private String name;
	private Integer advertiserId;
	private Integer campaignId;
	private List<Integer> campaignIds;

	@Override
	public AdGroupExample buildExample() {
		AdGroupExample example = new AdGroupExample();
		example.page(pageNo, pageSize);

		AdGroupExample.Criteria criteria = example.createCriteria();
		if (campaignId != null)
			criteria.andCampaignIdEqualTo(campaignId);
		if (id != null)
			criteria.andIdEqualTo(id);
		if (StringUtils.isNotBlank(name))
			criteria.andNameLike(SQLUtils.toLikeString(name));
		if (!CollectionUtils.isEmpty(campaignIds))
			criteria.andCampaignIdIn(campaignIds);
		
		return example;
	}

	public List<Integer> getCampaignIds() {
		return campaignIds;
	}

	public void setCampaignIds(List<Integer> campaignIds) {
		this.campaignIds = campaignIds;
	}

	/**
	 * @return the advertiserId
	 */
	public Integer getAdvertiserId() {
		return advertiserId;
	}

	/**
	 * @param advertiserId the advertiserId to set
	 */
	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}

	/**
	 * @return the campaignId
	 */
	public Integer getCampaignId() {
		return campaignId;
	}

	/**
	 * @param campaignId the campaignId to set
	 */
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
