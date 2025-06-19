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
	 * @param email メールアドレス
	 * @param userName ユーザ名
	 * @param password 暗号化したパスワード
	 */
	@Insert("""
			    INSERT INTO users
			    (email, user_name, password)
			    VALUES
			    (#{email}, #{userName}, #{password})
			""")
	void registerUser(
			@Param("email") String email,
			@Param("userName") String userName,
			@Param("password") String password);

	/**
	 * メールアドレスでユーザを検索するメソッド
	 * @param email メールアドレス
	 * @return ユーザ情報
	 */
	@Select("""
			    SELECT
			    	email, user_name, password
			    FROM
			    	users
			    WHERE
			    	email = #{email}
			""")
	User findUserByEmail(@Param("email") String email);

	/**
	 * ユーザのパスワードを更新するメソッド
	 * @param email メールアドレス
	 * @param newPassword 新しいパスワード
	 */
	@Update("""
			    UPDATE
			    	users
			    SET
			    	password = #{newPassword}
			    WHERE
			    	email = #{email}
			""")
	void updatePassword(@Param("email") String email, @Param("newPassword") String newPassword);

	/**
	 * ユーザを削除するメソッド
	 * @param email メールアドレス
	 */
	@Delete("""
			    DELETE FROM users WHERE email = #{email}
			""")
	void deleteUser(@Param("email") String email);
}