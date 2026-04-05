package com.System.Service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.System.Repositry.UserRepositry;
@Service
public class UserDetails  implements UserDetailsService
{

	@Autowired
	UserRepositry repositry;


	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<com.System.Entity.User> byusername = repositry.findByusername(username);
		if(byusername.isPresent())
		{
			com.System.Entity.User user = byusername.get();
			return org.springframework.security.core.userdetails.User.withUsername(username).
					password(user.getPassword()).roles(user.getRole().name()).build();
			
		}
		throw new RuntimeException("Username not Found");
	}	
	
}
