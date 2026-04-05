package com.System.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.System.Entity.Techer;
import com.System.Entity.User;
import com.System.Service.TecherService;

@RestController
public class TecherRest
{
	@Autowired
  TecherService techerService;
	
	@PostMapping("addtecher")
	public ResponseEntity<Techer> AddTecher(@RequestBody Techer techer)
	{
		Techer techer2 = techerService.createTecher(techer);
		return new ResponseEntity<Techer>(techer2,HttpStatus.CREATED);
	}
	
	@GetMapping("ViewTecher")
	public ResponseEntity<List<Techer>> getTechers() 
	{
		List<Techer> techers = techerService.getTechers();
		return new ResponseEntity<List<Techer>>(techers,HttpStatus.OK);
	}
}
