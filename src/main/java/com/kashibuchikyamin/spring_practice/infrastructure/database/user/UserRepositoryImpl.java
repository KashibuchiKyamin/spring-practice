package com.kashibuchikyamin.spring_practice.infrastructure.database.user;

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

	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void registerUser(String userName, String email, String password) {
		userMapper.registerUser(email, userName, password);

	}

	@Override
	public void updatePassword(String email, String newPassword) {
		userMapper.updatePassword(email, newPassword);
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
