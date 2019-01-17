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

import org.apache.commons.lang3.StringUtils;

import ai.houyi.zhuque.commons.SQLUtils;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.dao.model.CreativeExample;

/**
 *
 * @author weiping wang
 */
public class CreativeQueryReq extends QueryReq<CreativeExample> {
	private Integer auditStatus;
	private String name;
	private Integer status;
	private Integer adGroupId;

	@Override
	public CreativeExample toExample() {
		CreativeExample example = new CreativeExample();

		CreativeExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name))
			criteria.andNameLike(SQLUtils.toLikeString(name));
		if (status != null)
			criteria.andStatusEqualTo(status);
		if (auditStatus != null)
			criteria.andAuditStatusEqualTo(auditStatus);
		if (adGroupId != null)
			criteria.andAdGroupIdEqualTo(adGroupId);

		if (pageNo != null && pageSize != null) {
			example.page(pageNo, pageSize);
		}
		return example;
	}

	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
