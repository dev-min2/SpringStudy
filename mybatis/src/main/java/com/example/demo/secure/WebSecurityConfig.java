package com.example.demo.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	// 패스워드 암호화 설정
	@Bean 
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll() // 해당 경로의 페이지는 모두 접속허용
				.antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER")
				.anyRequest().authenticated() // 그 외는 모두 로그인해야만 접근이 가능
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("userid")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder() // 접속계정
				.username("user")
				.password("1234")
				.roles("ADMIN") // 권한설정
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
