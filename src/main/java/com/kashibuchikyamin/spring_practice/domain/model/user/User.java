package com.kashibuchikyamin.spring_practice.domain.model.user;

/**
 * ユーザのレコード。
 * @param userName ユーザ名
 * @param password パスワード
 */
public record User(String userName, String password) {

}
