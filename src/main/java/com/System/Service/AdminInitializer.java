package com.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.System.Role;
import com.System.Entity.User;
import com.System.Repositry.UserRepositry;

import jakarta.annotation.PostConstruct;

@Component
public class AdminInitializer
{
	@Autowired
	UserRepositry UserRepositry;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostConstruct
	public void CreateAdminIfNotExists()
	{
		if(UserRepositry.findByusername("Adarsh").isEmpty())
		{
			User admin=new User();
			admin.setUsername("Adarsh");
			admin.setPassword(encoder.encode("1234"));
			admin.setRole(Role.ADMIN);
			User save = UserRepositry.save(admin);
			System.err.println(save);
		}
	}

}
