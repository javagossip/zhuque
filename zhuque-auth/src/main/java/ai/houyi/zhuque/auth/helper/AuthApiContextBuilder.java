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
package ai.houyi.zhuque.auth.helper;

import org.springframework.stereotype.Component;

import ai.houyi.dorado.swagger.ext.ApiContext;
import ai.houyi.dorado.swagger.ext.ApiContextBuilder;
import ai.houyi.dorado.swagger.ext.ApiKey;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;

/**
 *
 * @author weiping wang
 */
@Component
public class AuthApiContextBuilder implements ApiContextBuilder {
	private static ApiContext apiContext;

	@Override
	public ApiContext buildApiContext() {
		if (apiContext != null)
			return apiContext;

		Info info = new Info()
				.contact(new Contact().name("weiping wang").email("948517839@qq.com")
						.url("https://github.com/javagossip/"))
				.description("认证&授权api服务")
				.license(new License().name("Apache License").url("http://www.apache.org/licenses/LICENSE-2.0"))
				.title("认证&授权api服务").version("v1.0");

		ApiKey apiKey = ApiKey.builder().withName("token").build();

		return ApiContext.builder().withInfo(info).withApiKey(apiKey).build();
	}

}
