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
import ai.houyi.zhuque.core.model.query.CreativeQueryReq;
import ai.houyi.zhuque.core.service.CreativeService;
import ai.houyi.zhuque.dao.CreativeMapper;
import ai.houyi.zhuque.dao.model.Creative;
import ai.houyi.zhuque.dao.model.CreativeExample;

/**
 *
 * @author weiping wang
 */
@Service
public class CreativeServiceImpl implements CreativeService {
	@Autowired
	private CreativeMapper creativeMapper;
	
	@Override
	public void save(Creative t) {
		creativeMapper.insertSelective(t);
	}

	@Override
	public void update(Creative t) {
		creativeMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		creativeMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		Creative creative = new Creative();
		creative.setId(pk);
		creative.setDeleted(true);
		
		creativeMapper.updateByPrimaryKeySelective(creative);
	}

	@Override
	public Creative loadById(Integer pk) {
		return creativeMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Creative> selectAll() {
		CreativeExample example=new CreativeExample();
		example.createCriteria().andDeletedEqualTo(false);
		
		return creativeMapper.selectByExample(example);
	}

	@Override
	public List<Creative> selectByQueryReq(CreativeQueryReq queryReq) {
		return creativeMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Creative> selectPageList(CreativeQueryReq queryReq) {
		int total = (int) creativeMapper.countByExample(queryReq.toExample());
		List<Creative> result=creativeMapper.selectByExample(queryReq.toExample());
		
		
		return Page.create(total, queryReq.getPageSize(), result);
	}

}
