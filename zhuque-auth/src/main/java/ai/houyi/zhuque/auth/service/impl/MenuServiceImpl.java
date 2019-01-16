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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.auth.service.MenuService;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
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
		menuMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		menuMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
	}

	@Override
	public Menu loadById(Integer pk) {
		return menuMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Menu> selectAll() {
		return menuMapper.selectByExample(new MenuExample());
	}

	@Override
	public List<Menu> selectByQueryReq(QueryReq<MenuExample> queryReq) {
		return menuMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Menu> selectPageList(PageQueryReq<MenuExample> queryReq) {
		MenuExample example = queryReq.toExample();
		int total = (int) menuMapper.countByExample(example);
		List<Menu> result = menuMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

}
