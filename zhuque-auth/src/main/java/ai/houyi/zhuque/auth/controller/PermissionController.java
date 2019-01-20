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
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.query.PermissionQueryReq;
import ai.houyi.zhuque.core.service.PermissionService;
import ai.houyi.zhuque.dao.model.Permission;
import io.swagger.annotations.Api;

/**
 * @author weiping wang
 */
@Controller
@Path("/permissions")
@Api(tags="权限管理")
public class PermissionController implements IController<Permission, PermissionQueryReq, Integer> {
	@Autowired
	private PermissionService permissionService;
	
	@POST
	public void saveOrUpdate(Permission t) {
		if(t.getId()==null) {
			permissionService.save(t);
		}else {
			permissionService.update(t);
		}
	}

	@POST
	@Path("/{id}")
	public void deleteById(Integer id) {
		permissionService.deleteById(id);
	}

	@GET
	@Path("/{id}")
	public Permission loadById(Integer id) {
		return permissionService.loadById(id);
	}

	@GET
	public List<Permission> permissionTree(){
		return permissionService.selectPermissionsAsTree();
	}
	
	@Override
	public Page<Permission> selectPage(PermissionQueryReq queryReq) {
		//DO NOTHING
		return null;
	}
}
