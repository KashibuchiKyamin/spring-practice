package com.kashibuchikyamin.spring_practice.infrastructure.database.user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kashibuchikyamin.spring_practice.domain.model.user.User;

@Mapper
public interface UserMapper {

	/**
	 * ユーザを登録するメソッド
	 * @param userName ユーザ名
	 * @param password パスワード
	 */
	@Insert("""
			INSERT INTO users (
				 user_name
				,password
			) VALUES (
				 #{userName}
				,#{password}
			)
			""")
	void registerUser(@Param("userName") String userName, @Param("userName") String password);

	/**
	 * ユーザを取得するメソッド
	 * @param userName ユーザ名
	 * @return ユーザ情報
	 */
	@Select("""
			SELECT user_name, password
			FROM users
			WHERE user_name = #{userName}
			""")
	User findUserByUsername(@Param("userName") String userName);

	/**
	 * ユーザのパスワードを更新するメソッド
	 * @param userName ユーザ名
	 * @param newPassword 新しいパスワード
	 */
	@Update("""
			UPDATE users
			SET password = #{newPassword}
			WHERE user_name = #{userName}
			""")
	void updatePassword(String userName, String newPassword);

	/**
	 * ユーザを削除するメソッド
	 * @param userName	ユーザ名
	 */
	@Delete("""
			DELETE FROM users
			WHERE user_name = #{userName}
			""")
	void deleteUser(String userName);
}
