package com.abhi.it.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	@Bean
	public InMemoryUserDetailsManager configurerUser() {
		UserDetails adminuser = User.withDefaultPasswordEncoder()
									.username("admin")
									.password("admin")
									.roles("ADMIN","USER")
									.build();
		
		UserDetails normalUser = User.withDefaultPasswordEncoder()
									 .username("user")
									 .password("user")
									 .roles("USER")
									 .build();
		
		return new InMemoryUserDetailsManager(adminuser, normalUser);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((req)->
					req.requestMatchers("/").permitAll()
					.requestMatchers("/user").hasAnyRole("ADMIN", "USER")
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
				).formLogin();
		
		return http.build();
	}
}
