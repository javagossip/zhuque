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

import ai.houyi.zhuque.auth.service.PermissionService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.PermissionQueryReq;
import ai.houyi.zhuque.dao.PermissionMapper;
import ai.houyi.zhuque.dao.model.Permission;
import ai.houyi.zhuque.dao.model.PermissionExample;

/**
 * @author weiping wang
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public void save(Permission t) {
		permissionMapper.insertSelective(t);
	}

	@Override
	public void update(Permission t) {
		permissionMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		permissionMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
	}

	@Override
	public Permission loadById(Integer pk) {
		return permissionMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Permission> selectAll() {
		return permissionMapper.selectByExample(new PermissionExample());
	}

	@Override
	public List<Permission> selectByQueryReq(PermissionQueryReq query) {
		return permissionMapper.selectByExample(query.toExample());
	}

	@Override
	public Page<Permission> selectPageList(PermissionQueryReq query) {
		PermissionExample example = query.toExample();

		int total = (int) permissionMapper.countByExample(example);
		List<Permission> result = permissionMapper.selectByExample(example);

		return Page.create(total, query.getPageSize(), result);
	}

	@Override
	public List<Permission> selectPermissionsAsTree() {
		return selectPermissionsAsTree(null);
	}

	public List<Permission> selectPermissionsAsTree(Integer pid) {
		PermissionExample example = new PermissionExample();
		PermissionExample.Criteria criteria = example.createCriteria();

		if (pid == null) {
			criteria.andPidIsNull();
		} else {
			criteria.andPidEqualTo(pid);
		}

		List<Permission> permissionList = permissionMapper.selectByExample(example);
		permissionList.forEach(p -> {
			List<Permission> subPermissions = selectPermissionsAsTree(p.getId());
			if (subPermissions != null && !subPermissions.isEmpty()) {
				p.setChildren(subPermissions);
			}
		});
		return permissionList;
	}
}
