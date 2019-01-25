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
package ai.houyi.zhuque.auth.model;

import java.util.List;

import ai.houyi.zhuque.dao.model.Menu;
import ai.houyi.zhuque.dao.model.Session;
import ai.houyi.zhuque.dao.model.User;

/**
 *
 * @author weiping wang
 */
public class Subject {
	private User user;
	private List<String> roles;
	private List<String> permissions;
	private List<Menu> menus;
	private Session session;

	public Subject(User user, List<String> roles, List<String> permissions) {
		this.user = user;
		this.roles = roles;
		this.permissions = permissions;
	}

	public static Subject create(User user, List<String> roles, List<String> permissions) {
		return new Subject(user, roles, permissions);

	}

	public boolean isPermitted(String permission) {
		if (permissions != null) {
			return permissions.contains(permission);
		}
		return false;
	}

	public boolean hasRole(String role) {
		if (roles != null) {
			return roles.contains(role);
		}
		return false;
	}

	/**
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public List<String> getRoles() {
		return roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}
}
