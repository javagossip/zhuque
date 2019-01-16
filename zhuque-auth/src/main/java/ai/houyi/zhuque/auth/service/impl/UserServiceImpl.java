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

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.houyi.zhuque.auth.model.ChangePwdReq;
import ai.houyi.zhuque.auth.model.ResetPasswdReq;
import ai.houyi.zhuque.auth.service.UserService;
import ai.houyi.zhuque.commons.exception.ZhuqueException;
import ai.houyi.zhuque.commons.model.PageQueryReq;
import ai.houyi.zhuque.commons.model.QueryReq;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.dao.UserMapper;
import ai.houyi.zhuque.dao.UserRoleMapper;
import ai.houyi.zhuque.dao.model.User;
import ai.houyi.zhuque.dao.model.UserExample;
import ai.houyi.zhuque.dao.model.UserRoleExample;

/**
 * @author weiping wang
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void save(User t) {
		userMapper.insertSelective(t);
	}

	@Override
	public void update(User t) {
		userMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Integer pk) {
		userRoleMapper.deleteByExample(new UserRoleExample().createCriteria().andUserIdEqualTo(pk).example());
		userMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
		throw new UnsupportedOperationException("用户不支持软删除");
	}

	@Override
	public User loadById(Integer pk) {
		return userMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<User> selectAll() {
		throw new UnsupportedOperationException("unsupported selectAll operation for user");
	}

	@Override
	public List<User> selectByQueryReq(QueryReq<UserExample> queryReq) {
		return userMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<User> selectPageList(PageQueryReq<UserExample> queryReq) {
		UserExample example = queryReq.toExample();
		int total = (int) userMapper.countByExample(example);
		List<User> result = userMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

	@Override
	public void resetPasswd(ResetPasswdReq req) {
		User user = new User();
		user.setId(req.getUserId());
		user.setPasswd(DigestUtils.md5Hex(req.getPasswd()));

		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void updatePasswd(ChangePwdReq req) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(req.getUserId()).andPasswdEqualTo(DigestUtils.md5Hex(req.getOldPasswd()));

		boolean exists = userMapper.countByExample(example) > 0;
		if (!exists)
			throw new ZhuqueException("用户不存在或者密码不正确");

		User user = new User();
		user.setId(req.getUserId());
		user.setPasswd(DigestUtils.md5Hex(req.getPasswd()));

		userMapper.updateByPrimaryKeySelective(user);
	}
}
