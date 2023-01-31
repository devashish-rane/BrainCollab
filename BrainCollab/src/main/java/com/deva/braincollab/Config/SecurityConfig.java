package com.deva.braincollab.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
//                  authorize.anyRequest().authenticated()
                authorize.requestMatchers("/**").permitAll()
//                        .requestMatchers("/api/auth/**").permitAll()


        );
		return http.build();
	}

}
