package com.System.Sequrity;

import java.util.List;
import org.springframework.web.cors.*;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import com.System.Service.UserDetails;
@Configuration
@EnableWebSecurity
public class AppSequrity 
{
	@Autowired
	UserDetails UserDetails;
	
	@Bean
	public BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider provide()
	{
		DaoAuthenticationProvider pro=new DaoAuthenticationProvider(UserDetails);
		pro.setPasswordEncoder(encoder());
		return pro;
	
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(List.of("http://127.0.0.1:5500"));
	    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    config.setAllowedHeaders(List.of("*"));
	    config.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);

	    return source;
	}

	@Bean
	public SecurityFilterChain sequrity(HttpSecurity http)
	{
		
		http.csrf(csrf->csrf.disable());
		http.cors(Customizer.withDefaults());
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers("/auth/login").permitAll();
			auth.requestMatchers("/addtecher").hasRole("ADMIN");
			auth.requestMatchers("/ViewTecher").hasRole("ADMIN");
			auth.anyRequest().permitAll();
		}).httpBasic(Customizer.withDefaults()).formLogin(form->form.disable());
		return http.build();
	}
}
