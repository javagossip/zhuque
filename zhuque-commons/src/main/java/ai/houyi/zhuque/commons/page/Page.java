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
package ai.houyi.zhuque.commons.page;

import java.util.List;

/**
 * @author weiping wang
 *
 */
public final class Page<T> {
	private int total;
	private int pageSize;
	private int pageCount;

	private List<T> result;

	private Page(int total, int pageSize, List<T> result) {
		this.total = total;
		this.pageSize = pageSize;

		this.pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		this.result=result;
	}

	public int getTotal() {
		return total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public List<T> getResult() {
		return result;
	}
}
