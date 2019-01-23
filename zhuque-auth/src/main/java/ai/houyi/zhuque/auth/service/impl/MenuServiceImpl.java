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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.auth.service.MenuService;
import ai.houyi.zhuque.commons.exception.ExceptionUtils;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.MenuQueryReq;
import ai.houyi.zhuque.dao.MenuMapper;
import ai.houyi.zhuque.dao.PermissionMapper;
import ai.houyi.zhuque.dao.RolePermissionMapper;
import ai.houyi.zhuque.dao.UserRoleMapper;
import ai.houyi.zhuque.dao.model.Menu;
import ai.houyi.zhuque.dao.model.MenuExample;
import ai.houyi.zhuque.dao.model.PermissionExample;
import ai.houyi.zhuque.dao.model.RolePermissionExample;
import ai.houyi.zhuque.dao.model.UserRoleExample;

/**
 * @author weiping wang
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;

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
		ExceptionUtils.throwZhuqueException("unsupport soft delete op for Menu");
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
	public List<Menu> selectByQueryReq(MenuQueryReq queryReq) {
		return menuMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Menu> selectPageList(MenuQueryReq queryReq) {
		MenuExample example = queryReq.toExample();
		int total = (int) menuMapper.countByExample(example);
		List<Menu> result = menuMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public List<Menu> selectByUserId(Integer userId) {
		UserRoleExample ure = UserRoleExample.newAndCreateCriteria().andUserIdEqualTo(userId).example();
		List<Integer> roleIdList = userRoleMapper.selectByExample(ure).stream().map(ur -> ur.getRoleId())
				.collect(Collectors.toList());

		if (roleIdList == null || roleIdList.isEmpty())
			return Collections.emptyList();

		RolePermissionExample rpe = RolePermissionExample.newAndCreateCriteria().andRoleIdIn(roleIdList).example();
		List<Integer> permissionIdList = rolePermissionMapper.selectByExample(rpe).stream()
				.map(rp -> rp.getPermissionId()).distinct().collect(Collectors.toList());

		if (permissionIdList == null || permissionIdList.isEmpty())
			return Collections.emptyList();

		// 获得拥有权限的所有menu_id
		List<Integer> menuIdList = permissionMapper
				.selectByExample(PermissionExample.newAndCreateCriteria().andIdIn(permissionIdList).example()).stream()
				.filter(p -> p.getMenuId() != null).map(p -> p.getId()).collect(Collectors.toList());
		if (menuIdList == null || menuIdList.isEmpty())
			return Collections.emptyList();
		
		return menuMapper.selectByExample(MenuExample.newAndCreateCriteria().andIdIn(menuIdList).example());
	}

}
