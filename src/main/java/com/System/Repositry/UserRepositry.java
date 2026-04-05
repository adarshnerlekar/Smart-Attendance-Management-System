package com.System.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.System.Entity.Techer;
import com.System.Entity.User;

@Repository
public interface UserRepositry  extends JpaRepository<User,Integer>
{

	Optional<User>findByusername(String username);
	
	

}