package com.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.System.Role;
import com.System.Entity.Techer;
import com.System.Entity.User;
import com.System.Repositry.TecherRepositry;
import com.System.Repositry.UserRepositry;

@Service
public class TecherService
{
    @Autowired
    UserRepositry UserRepositry;
    
    @Autowired
    TecherRepositry techerRepositry;
    
    @Autowired
    BCryptPasswordEncoder encoder;
	
    
	public Techer createTecher(Techer techer)
	{
        // Create User
        User user = new User();
        user.setUsername(techer.getEmail());   // 👈 email login साठी वापर
        user.setPassword(encoder.encode(techer.getPassword()));
        user.setRole(Role.TECHER);

        User savedUser = UserRepositry.save(user);

        // Link User to Teacher
        techer.setUser(savedUser);

        return techerRepositry.save(techer);

	}
	
	
	public List<Techer> getTechers()
	{
      List<Techer> all = techerRepositry.findAll();
      if(all.isEmpty())
      {
    	     throw new RuntimeException();
      }
     return all;
	}
	
}
