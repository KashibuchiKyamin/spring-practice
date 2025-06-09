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
	public void registerUser(String userName, String password) {
		userMapper.registerUser(userName, password);

	}

	@Override
	public User findUserByUsername(String userName) {
		User user = userMapper.findUserByUsername(userName);
		return user;
	}

	@Override
	public void updatePassword(String userName, String newPassword) {
		userMapper.updatePassword(userName, newPassword);
	}

	@Override
	public void deleteUser(String userName) {
		userMapper.deleteUser(userName);

	}

}
