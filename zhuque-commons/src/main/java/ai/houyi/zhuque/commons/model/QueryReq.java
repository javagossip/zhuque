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
package ai.houyi.zhuque.commons.model;

import ai.houyi.zhuque.commons.Constants;

/**
 *
 * @author weiping wang
 */
public abstract class QueryReq<E> {

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	protected Integer pageNo;
	protected Integer pageSize;

	public void initPageInfoIfNeed() {
		if (pageNo != null && pageNo > 0)
			pageNo = pageNo - 1;
		if (pageNo == null)
			pageNo = Constants.INIT_PAGE_NO - 1;
		if (pageSize == null)
			pageSize = Constants.DEFAULT_PAGE_SIZE;

	}

	public final E toExample() {
		initPageInfoIfNeed();
		return buildExample();
	}
	
	public abstract E buildExample();
}
