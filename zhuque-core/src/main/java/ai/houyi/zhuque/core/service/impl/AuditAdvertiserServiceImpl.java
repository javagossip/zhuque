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
import ai.houyi.zhuque.core.model.query.AuditAdvertiserQueryReq;
import ai.houyi.zhuque.core.service.AuditAdvertiserService;
import ai.houyi.zhuque.dao.AdvertiserQualificationMapper;
import ai.houyi.zhuque.dao.AuditAdvertiserMapper;
import ai.houyi.zhuque.dao.model.AdvertiserQualification;
import ai.houyi.zhuque.dao.model.AdvertiserQualificationExample;
import ai.houyi.zhuque.dao.model.AuditAdvertiser;
import ai.houyi.zhuque.dao.model.AuditAdvertiserExample;

/**
 * @author weiping wang
 */
@Service
public class AuditAdvertiserServiceImpl implements AuditAdvertiserService {
	@Autowired
	private AuditAdvertiserMapper auditAdvertiserMapper;
	@Autowired
	private AdvertiserQualificationMapper advertiserQualificationMapper;

	@Override
	public void save(AuditAdvertiser t) {
		auditAdvertiserMapper.insertSelective(t);
	}

	@Override
	public void update(AuditAdvertiser t) {
		auditAdvertiserMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		auditAdvertiserMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		AuditAdvertiser auditAdvertiser = new AuditAdvertiser.Builder().id(pk).deleted(true).build();
		auditAdvertiserMapper.updateByPrimaryKeySelective(auditAdvertiser);
	}

	@Override
	public AuditAdvertiser loadById(Integer pk) {
		return auditAdvertiserMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<AuditAdvertiser> selectAll() {
		return null;
	}

	@Override
	public List<AuditAdvertiser> selectByQueryReq(AuditAdvertiserQueryReq query) {
		return null;
	}

	@Override
	public Page<AuditAdvertiser> selectPageList(AuditAdvertiserQueryReq query) {
		AuditAdvertiserExample example = query.toExample();
		int total = (int) auditAdvertiserMapper.countByExample(example);
		List<AuditAdvertiser> result = auditAdvertiserMapper.selectByExample(example);

		return Page.create(total, query.getPageSize(), result);
	}

	@Override
	public void addAdvertiserQualification(AdvertiserQualification qualification) {
		advertiserQualificationMapper.insertSelective(qualification);
	}

	@Override
	public void deleteAdvertiserQualification(Integer qualificationId) {
		advertiserQualificationMapper.deleteByPrimaryKey(qualificationId);
	}

	@Override
	public List<AdvertiserQualification> getAdvertiserQualificationsByAdvertiserId(Integer auditAdvertiserId) {
		AdvertiserQualificationExample example = AdvertiserQualificationExample.newAndCreateCriteria()
				.andAdvertiserAuditIdEqualTo(auditAdvertiserId).example();
		return advertiserQualificationMapper.selectByExample(example);
	}
}
