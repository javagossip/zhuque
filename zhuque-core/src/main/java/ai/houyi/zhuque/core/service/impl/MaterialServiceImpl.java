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
import ai.houyi.zhuque.core.model.query.MaterialQueryReq;
import ai.houyi.zhuque.core.service.MaterialService;
import ai.houyi.zhuque.dao.MaterialMapper;
import ai.houyi.zhuque.dao.model.Material;
import ai.houyi.zhuque.dao.model.MaterialExample;

/**
 *
 * @author weiping wang
 */
@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialMapper materialMapper;
	
	@Override
	public void save(Material t) {
		materialMapper.insertSelective(t);
	}

	@Override
	public void update(Material t) {
		materialMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		materialMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		throw new UnsupportedOperationException("不支持软删除");
	}

	@Override
	public Material loadById(Integer pk) {
		return null;
	}

	@Override
	public List<Material> selectAll() {
		throw new UnsupportedOperationException("unsupported selectAll op for material");
	}

	@Override
	public List<Material> selectByQueryReq(MaterialQueryReq queryReq) {
		return materialMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Material> selectPageList(MaterialQueryReq queryReq) {
		MaterialExample example = queryReq.toExample();
		
		int total=(int) materialMapper.countByExample(example);
		List<Material> result = materialMapper.selectByExample(example);
		
		return Page.create(total, queryReq.getPageSize(), result);
	}

}
