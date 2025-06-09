package com.kashibuchikyamin.spring_practice.application.repository;

import com.kashibuchikyamin.spring_practice.domain.model.user.User;

public interface UserRepository {
		// ユーザを登録するメソッド
	void registerUser(String userName, String password);

	// ユーザを取得するメソッド
	User findUserByUsername(String userName);

	// ユーザのパスワードを更新するメソッド
	void updatePassword(String userName, String newPassword);

	// ユーザを削除するメソッド
	void deleteUser(String userName);
}
