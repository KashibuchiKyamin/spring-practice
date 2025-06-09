package com.kashibuchikyamin.spring_practice._configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * セキュリティ設定を行うクラスです。
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/** 
	 * パスワードエンコーダーを定義します。
	 * @return PasswordEncoderのインスタンス
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
