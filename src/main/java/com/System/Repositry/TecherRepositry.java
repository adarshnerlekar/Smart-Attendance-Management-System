package com.System.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.System.Entity.Techer;
@Repository
public interface TecherRepositry  extends JpaRepository<Techer, Integer>
{
	
	Optional<Techer>findByTechername(String Techername);	
	
	@Query("SELECT t FROM Techer t WHERE t.Techername = :name")
	Techer findByTechernameCustom(@Param("name") String Techername);
	
}
