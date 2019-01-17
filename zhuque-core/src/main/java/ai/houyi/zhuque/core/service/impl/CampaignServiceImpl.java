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

import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.CampaignQueryReq;
import ai.houyi.zhuque.core.service.CampaignService;
import ai.houyi.zhuque.dao.CampaignMapper;
import ai.houyi.zhuque.dao.model.Campaign;
import ai.houyi.zhuque.dao.model.CampaignExample;

/**
 *
 * @author weiping wang
 */
@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignMapper campaignMapper;

	@Override
	public void save(Campaign t) {
		campaignMapper.insertSelective(t);
	}

	@Override
	public void update(Campaign t) {
		campaignMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		campaignMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		Campaign campaign = new Campaign();
		campaign.setId(pk);
		campaign.setDeleted(true);

		campaignMapper.updateByPrimaryKeySelective(campaign);
	}

	@Override
	public Campaign loadById(Integer pk) {
		return campaignMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Campaign> selectAll() {
		return campaignMapper.selectByExample(new CampaignExample());
	}

	@Override
	public List<Campaign> selectByQueryReq(CampaignQueryReq queryReq) {
		return campaignMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Campaign> selectPageList(CampaignQueryReq queryReq) {
		CampaignExample example = queryReq.toExample();

		int total = (int) campaignMapper.countByExample(example);
		List<Campaign> result = campaignMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

}
