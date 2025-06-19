package com.kashibuchikyamin.spring_practice.application.service.account;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kashibuchikyamin.spring_practice.application.repository.UserRepository;
import com.kashibuchikyamin.spring_practice.domain.model.user.AppUser;
import com.kashibuchikyamin.spring_practice.domain.model.user.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email + " not found");
		}
		return new AppUser(user, true);
	}
}