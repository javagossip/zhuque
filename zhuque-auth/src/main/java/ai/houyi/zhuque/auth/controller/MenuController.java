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
import ai.houyi.zhuque.auth.service.MenuService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.commons.web.IController;
import ai.houyi.zhuque.core.model.AuthContext;
import ai.houyi.zhuque.core.model.query.MenuQueryReq;
import ai.houyi.zhuque.dao.model.Menu;

/**
 * @author weiping wang
 */
@Controller
@Path("/menus")
public class MenuController implements IController<Menu, MenuQueryReq, Integer> {
	@Autowired
	private MenuService menuService;

	@POST
	@Path
	public void saveOrUpdate(Menu t) {
		if (t.getId() == null) {
			menuService.save(t);
		} else {
			menuService.update(t);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteById(Integer id) {
		menuService.deleteById(id);
	}

	@GET
	@Path("/{id}")
	public Menu loadById(Integer id) {
		return menuService.loadById(id);
	}

	@POST
	@Path("/list")
	public Page<Menu> selectPage(MenuQueryReq queryReq) {
		return menuService.selectPageList(queryReq);
	}

	@GET
	@Path
	public List<Menu> menuTree() {
		return menuService.selectByUserId(AuthContext.currentUser().getId());
	}
}
