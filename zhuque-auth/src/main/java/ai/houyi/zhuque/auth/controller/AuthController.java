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
package ai.houyi.zhuque.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.auth.model.AuthReq;
import ai.houyi.zhuque.auth.model.Subject;
import ai.houyi.zhuque.auth.service.AuthService;
import io.swagger.annotations.Api;

/**
 *
 * @author weiping wang
 */
@Controller
@Path("/auth")
@Api(tags="用户认证api")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@POST
	public Subject auth(AuthReq authReq) {
		return authService.auth(authReq);
	}
}
