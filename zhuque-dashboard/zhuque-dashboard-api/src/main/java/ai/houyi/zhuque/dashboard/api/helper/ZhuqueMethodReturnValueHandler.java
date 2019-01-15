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
package ai.houyi.zhuque.dashboard.api.helper;

import ai.houyi.dorado.rest.http.MethodReturnValueHandler;
import ai.houyi.dorado.rest.util.MethodDescriptor;
import ai.houyi.dorado.rest.util.TypeUtils;

/**
 * @author weiping wang
 *
 */
public class ZhuqueMethodReturnValueHandler implements MethodReturnValueHandler {

	@Override
	public Object handleMethodReturnValue(Object value, MethodDescriptor methodDescriptor) {
		return new Response(0, "ok", value);
	}

	@Override
	public boolean supportsReturnType(MethodDescriptor returnType) {
		return TypeUtils.isSerializableType(returnType.getReturnType());
	}

}
