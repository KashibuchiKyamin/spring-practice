package com.kashibuchikyamin.spring_practice.infrastructure.database.user;

import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_practice.application.repository.UserRepository;
import com.kashibuchikyamin.spring_practice.domain.model.user.User;

/**
 * ユーザリポジトリの実装クラス
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	UserMapper userMapper;

	@Override
	public void registerUser(String userName, String password) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public User findUserByUsername(String userName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updatePassword(String userName, String newPassword) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteUser(String userName) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
