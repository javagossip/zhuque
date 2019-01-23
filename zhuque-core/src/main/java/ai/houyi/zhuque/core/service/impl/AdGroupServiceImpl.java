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

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ai.houyi.zhuque.commons.Constants;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.AdGroupQueryReq;
import ai.houyi.zhuque.core.service.AdGroupService;
import ai.houyi.zhuque.dao.AdGroupMapper;
import ai.houyi.zhuque.dao.CampaignMapper;
import ai.houyi.zhuque.dao.model.AdGroup;
import ai.houyi.zhuque.dao.model.AdGroupExample;
import ai.houyi.zhuque.dao.model.CampaignExample;

/**
 * 广告组管理
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
		t.setUpdateTime(new Date());
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
	public List<AdGroup> selectByQueryReq(AdGroupQueryReq queryReq) {
		return null;
	}

	@Override
	public Page<AdGroup> selectPageList(AdGroupQueryReq queryReq) {
		AdGroupExample example = queryReq.toExample();

		Integer advertiserId = queryReq.getAdvertiserId();
		if(advertiserId!=null) {
			List<Integer> campaignIdList = campaignMapper.selectAllCampaignIdByAdvertiserId(advertiserId);
			if(!CollectionUtils.isEmpty(campaignIdList)) {
			}
		}
		
		if (advertiserId != null && !example.getOredCriteria().isEmpty()) {
			List<Integer> campaignIdList = campaignMapper.selectAllCampaignIdByAdvertiserId(advertiserId);
			if (!CollectionUtils.isEmpty(campaignIdList))
				example.getOredCriteria().get(0).andCampaignIdIn(campaignIdList);
		}

		int total = (int) adGroupMapper.countByExample(example);
		List<AdGroup> result = adGroupMapper.selectByExample(example);
		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public Page<AdGroup> selectPageListByAdvertiserId(Integer advertiserId, Integer pageNo) {
		CampaignExample campaignExample = new CampaignExample().createCriteria().andAdvertiserIdEqualTo(advertiserId)
				.example();
		List<Integer> campaignIdList = campaignMapper.selectByExample(campaignExample).stream().map(a -> a.getId())
				.collect(Collectors.toList());

		AdGroupExample.Criteria criteria = new AdGroupExample().createCriteria();
		if (!CollectionUtils.isEmpty(campaignIdList)) {
			criteria.andCampaignIdIn(campaignIdList);
		}

		AdGroupExample example = criteria.example().page(pageNo, Constants.DEFAULT_PAGE_SIZE);
		int total = (int) adGroupMapper.countByExample(example);
		List<AdGroup> result = adGroupMapper.selectByExample(example);

		return Page.create(total, Constants.DEFAULT_PAGE_SIZE, result);
	}

}
