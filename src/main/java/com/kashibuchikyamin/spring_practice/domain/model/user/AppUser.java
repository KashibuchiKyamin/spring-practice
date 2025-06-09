package com.kashibuchikyamin.spring_practice.domain.model.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ユーザの詳細情報を表すクラス。
 */
public class AppUser implements UserDetails {

	private String username;
	private String password;
	private boolean enabled;

	public AppUser(User user, boolean enabled) {
		this.username = user.userName();
		this.password = user.password();
		this.enabled = enabled;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

}
