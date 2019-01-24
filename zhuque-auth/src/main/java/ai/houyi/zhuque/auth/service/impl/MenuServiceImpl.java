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
package ai.houyi.zhuque.auth.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.auth.service.MenuService;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.MenuQueryReq;
import ai.houyi.zhuque.dao.MenuMapper;
import ai.houyi.zhuque.dao.model.Menu;
import ai.houyi.zhuque.dao.model.MenuExample;

/**
 * @author weiping wang
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public void save(Menu t) {
		menuMapper.insertSelective(t);
	}

	@Override
	public void update(Menu t) {
		t.setUpdateTime(new Date());
		menuMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		menuMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		ExceptionUtils.throwZhuqueException("unsupport soft delete op for Menu");
	}

	@Override
	public Menu loadById(Integer pk) {
		return menuMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Menu> selectAll() {
		return selectMenus(null);
	}

	private List<Menu> selectMenus(Integer pid) {
		MenuExample example = new MenuExample().createCriteria().andIf(pid == null, add -> add.andPidIsNull())
				.andIf(pid != null, add -> add.andPidEqualTo(pid)).example();
		List<Menu> menuList = menuMapper.selectByExample(example);
		menuList.forEach(menu -> {
			menu.setChildren(selectMenus(menu.getId()));
		});
		return menuList;
	}

	@Override
	public List<Menu> selectByQueryReq(MenuQueryReq queryReq) {
		return menuMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Menu> selectPageList(MenuQueryReq queryReq) {
		return null;
	}

	@Override
	public List<Menu> selectByUserId(Integer userId) {
		return menuMapper.selectUserMenus(userId);
	}
}
