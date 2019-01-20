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
import ai.houyi.dorado.rest.annotation.GET;
import ai.houyi.dorado.rest.annotation.POST;
import ai.houyi.dorado.rest.annotation.Path;
import ai.houyi.zhuque.auth.service.RoleService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.RoleQueryReq;
import ai.houyi.zhuque.dao.model.Role;
import io.swagger.annotations.Api;

/**
 * @author weiping wang
 */
@Controller
@Path("/roles")
@Api(tags= {"角色管理"})
public class RoleController implements IController<Role, RoleQueryReq, Integer>{
	@Autowired
	private RoleService roleService;
	
	@POST
	public void saveOrUpdate(Role role) {
		if(role.getId()==null) {
			roleService.save(role);
		}else {
			roleService.update(role);
		}
	}
	
	@GET
	@Path("/{id}")
	public Role loadById(Integer id) {
		return roleService.loadById(id);
	}
	
	@POST
	@Path("/{id}")
	public void deleteById(Integer id) {
		roleService.deleteById(id);
	}
	
	@GET
	@Path
	public List<Role> selectAll(){
		return roleService.selectAll();
	}
	
	@POST
	@Path("/list")
	public Page<Role> selectPage(RoleQueryReq queryReq){
		return roleService.selectPageList(queryReq);
	}
}
