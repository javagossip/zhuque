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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.commons.Constants;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.AdGroupQueryReq;
import ai.houyi.zhuque.core.service.AdGroupService;
import ai.houyi.zhuque.dao.AdGroupMapper;
import ai.houyi.zhuque.dao.CampaignMapper;
import ai.houyi.zhuque.dao.model.AdGroup;
import ai.houyi.zhuque.dao.model.AdGroupExample;

/**
 *
 * @author weiping wang
 */
@Service
public class AdGroupServiceImpl implements AdGroupService {
	@Autowired
	private AdGroupMapper adGroupMapper;
	@Autowired
	private CampaignMapper campaignMapper;

	@Override
	public void save(AdGroup t) {
		adGroupMapper.insertSelective(t);
	}

	@Override
	public void update(AdGroup t) {
		adGroupMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		adGroupMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		AdGroup adGroup = new AdGroup();
		adGroup.setId(pk);
		adGroup.setDeleted(true);

		adGroupMapper.updateByPrimaryKeySelective(adGroup);
	}

	@Override
	public AdGroup loadById(Integer pk) {
		return adGroupMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<AdGroup> selectAll() {
		ExceptionUtils.throwZhuqueException("unsupport selectAll op for AdGroup");
		return null;
	}

	@Override
	public List<AdGroup> selectByQueryReq(QueryReq<AdGroupExample> queryReq) {
		return adGroupMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<AdGroup> selectPageList(PageQueryReq<AdGroupExample> queryReq) {
		AdGroupQueryReq adGroupQueryReq = (AdGroupQueryReq) queryReq;
		String campaignName = adGroupQueryReq.getCamppaignName();
		Integer campaignId = adGroupQueryReq.getCampaignId();

		if (StringUtils.isNotBlank(campaignName) && campaignId != null) {
			ExceptionUtils.throwZhuqueException("活动名称和活动id不能同时不为空");
		}

		AdGroupExample example = queryReq.toExample();
		if (StringUtils.isNotBlank(campaignName)) {
			List<Integer> campaignIds = campaignMapper.selectAllCampaignIdsByName(campaignName);
			if (campaignIds != null && !campaignIds.isEmpty()) {
				example.getOredCriteria().get(0).andCampaignIdIn(campaignIds);
			}
		}

		int total = (int) adGroupMapper.countByExample(example);
		List<AdGroup> result = adGroupMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public Page<AdGroup> selectPageListByCampaignId(Integer campaignId) {
		AdGroupExample example = new AdGroupExample().createCriteria().andCampaignIdEqualTo(campaignId).example();

		int total = (int) adGroupMapper.countByExample(example);
		List<AdGroup> result = adGroupMapper.selectByExample(example);

		return Page.create(total, Constants.DEFAULT_PAGE_SIZE, result);
	}

	@Override
	public Page<AdGroup> selectPageListByAdvertiserId(Integer advertiserId) {
		return null;
	}

}
