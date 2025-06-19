package com.kashibuchikyamin.spring_practice._configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * セキュリティ設定を行うクラスです。
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/login", "/css/**", "/js/**", "/static/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login") // POST先
						.defaultSuccessUrl("/top", true)
						.permitAll())
				.logout(logout -> logout.permitAll());

		return http.build();
	}

	/** 
	 * パスワードエンコーダーを定義します。
	 * @return PasswordEncoderのインスタンス
	 */
	@Bean
	PasswordEncoder passwordEncoder() {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		System.out.println(bCryptPasswordEncoder.encode("password"));

		return bCryptPasswordEncoder;
	}
}
