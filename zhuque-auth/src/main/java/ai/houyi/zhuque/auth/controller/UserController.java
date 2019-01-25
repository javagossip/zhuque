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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ai.houyi.dorado.rest.annotation.Controller;
import ai.houyi.dorado.rest.annotation.DELETE;
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.dorado.rest.annotation.PathVariable;
import ai.houyi.dorado.rest.annotation.RequestBody;
import ai.houyi.zhuque.auth.model.ChangePwdReq;
import ai.houyi.zhuque.auth.model.ResetPasswdReq;
import ai.houyi.zhuque.auth.service.UserService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.UserQueryReq;
import ai.houyi.zhuque.dao.model.Permission;
import ai.houyi.zhuque.dao.model.Role;
import ai.houyi.zhuque.dao.model.User;
import io.swagger.annotations.Api;

/**
 * @author weiping wang
 */
@Controller
@Path("/users")
@Api(tags = "用户管理")
public class UserController implements IController<User, UserQueryReq, Integer> {

	@Autowired
	private UserService userService;

	@POST
	public void saveOrUpdate(User user) {
		if (user.getId() == null) {
			userService.save(user);
		} else {
			userService.update(user);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteById(Integer id) {
		userService.deleteById(id);
	}

	@GET
	@Path("/{id}")
	public User loadById(Integer id) {
		return userService.loadById(id);
	}

	@POST
	@Path("/list")
	public Page<User> selectPage(UserQueryReq queryReq) {
		queryReq.initPageInfoIfNeed();
		return userService.selectPageList(queryReq);
	}

	// 管理员强制更新用户密码
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

	@POST
	@Path("/roles/{userId}")
	public void setRoles(@PathVariable Integer userId, @RequestBody List<Integer> roleIds) {
		userService.updateUserRoles(userId, roleIds);
	}

	@GET
	@Path("/roles/{userId}")
	public List<Role> getUserRoles(Integer userId) {
		return userService.getUserRoles(userId);
	}
	
	@GET
	@Path("/permissions/{userId}")
	public List<Permission> getUserPermissions(Integer userId){
		return userService.getUserPermissions(userId);
	}
}
