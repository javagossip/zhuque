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
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.AdvertiserQueryReq;
import ai.houyi.zhuque.core.service.AdvertiserService;
import ai.houyi.zhuque.dao.AdvertiserMapper;
import ai.houyi.zhuque.dao.model.Advertiser;
import ai.houyi.zhuque.dao.model.AdvertiserExample;

/**
 *
 * @author weiping wang
 */
@Service
public class AdvertiserServiceImpl implements AdvertiserService {
	@Autowired
	private AdvertiserMapper advertiserMapper;

	@Override
	public void save(Advertiser t) {
		advertiserMapper.insertSelective(t);
	}

	@Override
	public void update(Advertiser t) {
		advertiserMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		advertiserMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		Advertiser advertiser = new Advertiser();
		advertiser.setId(pk);
		advertiser.setDeleted(true);

		advertiserMapper.updateByPrimaryKeySelective(advertiser);
	}

	@Override
	public Advertiser loadById(Integer pk) {
		return advertiserMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Advertiser> selectAll() {
		AdvertiserExample example = new AdvertiserExample();
		example.createCriteria().andDeletedEqualTo(false);

		return advertiserMapper.selectByExample(example);
	}

	@Override
	public List<Advertiser> selectByQueryReq(AdvertiserQueryReq queryReq) {
		return advertiserMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Advertiser> selectPageList(AdvertiserQueryReq queryReq) {
		int total = (int) advertiserMapper.countByExample(queryReq.toExample());
		List<Advertiser> result = advertiserMapper.selectByExample(queryReq.toExample());

		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public List<Advertiser> selectByName(String name) {
		AdvertiserExample example = new AdvertiserExample().createCriteria().andNameLike(SQLUtils.toLikeString(name))
				.example();
		return advertiserMapper.selectByExample(example);
	}

	@Override
	public void updateStatus(Integer advertiserId, int status) {
		Advertiser advertiser=new Advertiser();
		advertiser.setId(advertiserId);
		advertiser.setStatus(status);
		
		advertiserMapper.updateByPrimaryKeySelective(advertiser);
	}

}
