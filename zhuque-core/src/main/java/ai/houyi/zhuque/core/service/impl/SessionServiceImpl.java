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

import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.service.SessionService;
import ai.houyi.zhuque.dao.SessionMapper;
import ai.houyi.zhuque.dao.model.Session;
import ai.houyi.zhuque.dao.model.SessionExample;

/**
 *
 * @author weiping wang
 */
@Service
public class SessionServiceImpl implements SessionService {
	@Autowired
	private SessionMapper sessionMapper;

	@Override
	public void save(Session t) {
		sessionMapper.insertSelective(t);
	}

	@Override
	public void update(Session t) {
		if (t.getId() == null) {
			sessionMapper.insertSelective(t);
		} else {
			sessionMapper.updateByPrimaryKeySelective(t);
		}
	}

	@Override
	public void deleteById(Integer pk) {
		sessionMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		ExceptionUtils.throwZhuqueException("不支持软删除操作");
	}

	@Override
	public Session loadById(Integer pk) {
		return sessionMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Session> selectAll() {
		ExceptionUtils.throwZhuqueException("不支持selectAll操作");
		return null;
	}

	@Override
	public List<Session> selectByQueryReq(QueryReq<Object> query) {
		return null;
	}

	@Override
	public Page<Session> selectPageList(QueryReq<Object> query) {
		return null;
	}

	@Override
	public void deleteBySessionId(String sessionId) {
		SessionExample example = new SessionExample().createCriteria().andSessionIdEqualTo(sessionId).example();
		sessionMapper.deleteByExample(example);
	}
}
