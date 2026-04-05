
package com.System.Rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.System.Entity.Techer;
import com.System.Repositry.TecherRepositry;

import jakarta.websocket.Session;

@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	TecherRepositry repositry;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	 @GetMapping("me")
	    public Map<String, String> getLoggedUser(Authentication authentication) {

	        String username = authentication.getName();

	        String role = authentication.getAuthorities()
	                .iterator()
	                .next()
	                .getAuthority();

	        Map<String, String> response = new HashMap<>();
	        response.put("username", username);
	        response.put("role", role);

	        return response;
	    }
	 
	 
	 @PostMapping("login")
	 public ResponseEntity<?> login(@RequestBody Map<String, String> request)
	 {
               
		 
	     String username = request.get("username");
	     String password = request.get("password");

	     if(username.equals("Adarsh") && password.equals("1234")) {
	         return ResponseEntity.ok(Map.of("role", "ADMIN"));
	     }
	     
	     Techer tech = repositry.findByTechernameCustom(username);
	     
	     System.err.println("Tech object: " + tech);
	
	     
	    
	     if(tech!=null && username.equals(tech.getTechername()) &&  password.equals("1212"))
	    		 {
	         return ResponseEntity.ok(Map.of("role", "TECHER"));
	         
	     }
	     return ResponseEntity.status(401).body("Invalid credentials");
	 }


}
