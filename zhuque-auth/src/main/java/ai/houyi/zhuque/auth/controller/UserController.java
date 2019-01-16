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
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.auth.model.ChangePwdReq;
import ai.houyi.zhuque.auth.model.ResetPasswdReq;
import ai.houyi.zhuque.auth.service.UserService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.UserQueryReq;
import ai.houyi.zhuque.dao.model.User;

/**
 * @author weiping wang
 */
@Controller
@Path("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@POST
	@Path
	public void saveOrUpdate(User user) {
		if(user.getId()==null) {
			userService.save(user);
		}else {
			userService.update(user);
		}
	}
	
	@POST
	@Path("/{userId}")
	public void deleteById(int userId) {
		userService.deleteById(userId);
	}
	
	@GET
	@Path("/{userId}")
	public User loadById(int userId) {
		return userService.loadById(userId);
	}
	
	@POST
	@Path("/list")
	public Page<User> selectPage(UserQueryReq queryReq){
		return userService.selectPageList(queryReq);
	}
	
	//管理员强制更新用户密码
	@POST
	@Path("/passwd/reset")
	public void resetPasswd(ResetPasswdReq req) {
		userService.resetPasswd(req);
	}
	
	@POST
	@Path("/passwd/update")
	public void changePasswd(ChangePwdReq req) {
		userService.updatePasswd(req);
	}
}
