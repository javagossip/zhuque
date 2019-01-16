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

import org.springframework.stereotype.Service;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.service.DspService;
import ai.houyi.zhuque.dao.DspMapper;
import ai.houyi.zhuque.dao.model.Dsp;
import ai.houyi.zhuque.dao.model.DspExample;

/**
 * @author weiping wang
 */
@Service
public class DspServiceImpl implements DspService {
	private DspMapper dspMapper;

	@Override
	public void save(Dsp t) {
		dspMapper.insert(t);
	}

	@Override
	public void update(Dsp t) {
		dspMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		dspMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public Dsp loadById(Integer pk) {
		return dspMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Dsp> selectAll() {
		return dspMapper.selectByExample(new DspExample());
	}

	@Override
	public List<Dsp> selectByQueryReq(QueryReq<DspExample> queryReq) {
		DspExample example = queryReq.toExample();
		return dspMapper.selectByExample(example);
	}

	@Override
	public Page<Dsp> selectPageList(PageQueryReq<DspExample> queryReq) {
		DspExample example = queryReq.toExample();
		int total = (int) dspMapper.countByExample(example);
		List<Dsp> dataList = dspMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), dataList);
	}

	@Override
	public void updateStatus(int dspId, int status) {
		Dsp dsp = new Dsp();
		dsp.setId(dspId);
		dsp.setStatus(status);

		dspMapper.updateByPrimaryKeySelective(dsp);
	}

	@Override
	public void softDeleteById(Integer pk) {
		Dsp dsp = new Dsp();
		dsp.setId(pk);
		dsp.setDeleted(true);

		dspMapper.updateByPrimaryKeySelective(dsp);
	}

	@Override
	public List<Dsp> selectByName(String name) {
		if (name == null)
			ExceptionUtils.throwZhuqueException("名称不能为空");
		DspExample example = new DspExample().createCriteria().andNameLike(SQLUtils.toLikeString(name)).example();
		return dspMapper.selectByExample(example);
	}
}
