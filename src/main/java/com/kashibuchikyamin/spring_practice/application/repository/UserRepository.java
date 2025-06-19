package com.kashibuchikyamin.spring_practice.application.repository;

import com.kashibuchikyamin.spring_practice.domain.model.user.User;

public interface UserRepository {
	/**
	 * ユーザを登録するメソッド
	 * @param email メールアドレス
	 * @param userName ユーザ名
	 * @param password パスワード
	 * 暗号化はリポジトリ実装側で行う
	 */
	void registerUser(String email, String userName, String password);

	/**
	 * ユーザのパスワードを更新するメソッド
	 * @param email メールアドレス
	 * @param newPassword 新しいパスワード
	 * 暗号化はリポジトリ実装側で行う
	 */
	void updatePassword(String email, String newPassword);

	/**
	 * ユーザを削除するメソッド
	 * @param email メールアドレス
	 */
	void deleteUser(String email);

	/**
	 * メールアドレスでユーザを検索するメソッド
	 * @param email メールアドレス
	 * @return ユーザ情報
	 */
	User findUserByEmail(String email);
}
