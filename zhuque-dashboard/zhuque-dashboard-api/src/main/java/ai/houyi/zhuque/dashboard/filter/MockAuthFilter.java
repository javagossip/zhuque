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
package ai.houyi.zhuque.dashboard.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ai.houyi.dorado.rest.annotation.FilterPath;
import ai.houyi.dorado.rest.http.Filter;
import ai.houyi.dorado.rest.http.HttpRequest;
import ai.houyi.dorado.rest.http.HttpResponse;
import ai.houyi.zhuque.core.model.AuthContext;
import ai.houyi.zhuque.core.model.AuthInfo;
import ai.houyi.zhuque.dao.model.User;

/**
 * @author weiping wang
 */
@FilterPath(exclude="/auth/*",include="/**")
public class MockAuthFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(MockAuthFilter.class);
	@Override
	public boolean preFilter(HttpRequest request, HttpResponse response) {
		AuthInfo authInfo=new AuthInfo();
		User user = new User();
		user.setId(1);
		
		authInfo.setUser(user);
		AuthContext.set(authInfo);
		LOG.info("=====AuthFilter execute====");
		return true;
	}
}
