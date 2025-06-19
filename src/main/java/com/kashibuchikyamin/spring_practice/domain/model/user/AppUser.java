package com.kashibuchikyamin.spring_practice.domain.model.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ユーザの詳細情報を表すクラス。
 */
public class AppUser implements UserDetails {
	private String userName;
	private String email;
	private String password;
	private boolean enabled;

	public AppUser(User user, boolean enabled) {
		this.userName = user.userName();
		this.email = user.email();
		this.password = user.password();
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * 認識のためのメールアドレスを返します。
	 * @return メールアドレス
	 */
	@Override
	public String getUsername() {
		return email;
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
