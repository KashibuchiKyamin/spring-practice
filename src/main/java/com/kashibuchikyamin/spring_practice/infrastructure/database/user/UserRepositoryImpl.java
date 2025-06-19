package com.kashibuchikyamin.spring_practice.infrastructure.database.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_practice.application.repository.UserRepository;
import com.kashibuchikyamin.spring_practice.domain.model.user.User;

/**
 * ユーザリポジトリの実装クラス
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	/**
	 * ユーザマッパー
	 */
	UserMapper userMapper;

	/**
	 * パスワードエンコーダー
	 */
	PasswordEncoder passwordEncoder;

	public UserRepositoryImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void registerUser(String email, String userName, String password) {
		userMapper.registerUser(email, userName, passwordEncoder.encode(password));
	}

	@Override
	public void updatePassword(String email, String newPassword) {
		userMapper.updatePassword(email, passwordEncoder.encode(newPassword));
	}

	@Override
	public void deleteUser(String email) {
		userMapper.deleteUser(email);
	}

	@Override
	public User findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}

}
