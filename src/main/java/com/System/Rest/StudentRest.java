package com.System.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.System.active;
import com.System.Entity.Student;
import com.System.Service.StudentService;

@RestController
public class StudentRest {
	@Autowired
	StudentService service;
	
	@PostMapping("AddStudent")
	public ResponseEntity<Student> AddStudent(@RequestBody Student student)
	{
		Student student2 = service.addStudent(student);
		return new ResponseEntity<Student>(student2,HttpStatus.CREATED);
	}
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getall()
	{
		List<Student> allStudent = service.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent,HttpStatus.OK);
	}
	
	@GetMapping("students/{id}")
	public ResponseEntity<Student>  getstudent(@PathVariable  Integer id)
	{
		Student getstudent = service.getstudent(id);
		return new ResponseEntity<Student>(getstudent,HttpStatus.OK);
	}
   
	@DeleteMapping("DeleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		String deleteStudent = service.deleteStudent(id);
		return new ResponseEntity<String>(deleteStudent,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("DeleteStudent")
	public ResponseEntity<String> Delete()
	{
		String deleteAll = service.DeleteAll();
		return new ResponseEntity<String>(deleteAll,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("UpdateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student)
	{
		Student updateStudent = service.UpdateStudent(id, student);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("UpdateActive/{id}")
	public ResponseEntity<Student> updateActive(@PathVariable Integer id,@RequestBody active active)
	{
		Student updateStudentactvie = service.UpdateStudentactvie(id,active);
		return new ResponseEntity<Student>(updateStudentactvie,HttpStatus.ACCEPTED);
	}
}
