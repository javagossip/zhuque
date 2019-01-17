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
package ai.houyi.zhuque.core.model;

import ai.houyi.zhuque.dao.model.User;

/**
 *
 * @author weiping wang
 */
public class AuthContext {
	private static ThreadLocal<AuthInfo> AUTH_INFO_HOLDER = new ThreadLocal<AuthInfo>();

	public static void set(AuthInfo authInfo) {
		AUTH_INFO_HOLDER.set(authInfo);
	}

	public static AuthInfo get() {
		return AUTH_INFO_HOLDER.get();
	}

	public static User currentUser() {
		AuthInfo authInfo = AUTH_INFO_HOLDER.get();
		if (authInfo == null)
			return null;
		return authInfo.getUser();
	}
}
