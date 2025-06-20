package com.kashibuchikyamin.spring_practice.domain.model.user;

/**
 * ユーザのレコード。
 * @param email メールアドレス
 * @param userName ユーザ名
 * @param password パスワード
 */
public record User(String email, String userName, String password) {
	
}