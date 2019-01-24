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
package ai.houyi.zhuque.commons.web;

import ai.houyi.dorado.rest.annotation.ExceptionAdvice;
import ai.houyi.dorado.rest.annotation.ExceptionType;
import ai.houyi.dorado.rest.annotation.Status;
import ai.houyi.zhuque.commons.exception.ZhuqueException;

/**
 * 全局异常处理器
 * 
 * @author weiping wang
 */
@ExceptionAdvice
public class ZhuqueExceptionAdvisor {

	@ExceptionType(value = ZhuqueException.class)
	public Response handleException(ZhuqueException exception) {
		return new Response(1, exception.getMessage(), null);
	}

	@ExceptionType(value = Exception.class)
	public Response handleException(Exception exception) {
		exception.printStackTrace();
		return new Response(1, exception.getMessage(), null);
	}

	@Status(value = 403)
	public Response handleException(AuthFailedException exception) {
		return new Response(1, exception.getMessage(), null);
	}
}
