package com.System.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.System.active;
import com.System.Entity.Student;
import com.System.Repositry.StudentRepositry;
@Service
public class StudentService 
{
	@Autowired
	StudentRepositry repositry;
	
	public Student addStudent(Student student)
	{
		Student save = repositry.save(student);
		return save;
	}
    
	public List<Student> getAllStudent()
	{
		List<Student> all = repositry.findAll();
		if(all.isEmpty())
		{
			throw new RuntimeException("Students Are Empty");
		}
		return all;
	}
	
	
	public Student getstudent(Integer id)
	{
		Optional<Student> byId = repositry.findById(id);
		if(byId.isPresent())
		{
			Student student = byId.get();
			return student;
		}
		throw new RuntimeException("Student Not Found");
	}
	
	public String deleteStudent(Integer id)
	{
		boolean existsById = repositry.existsById(id);
		if(existsById==true)
		{
			repositry.deleteById(id);
			return "Student Delete Suessfully";	
		}
		throw new RuntimeException("Studet Id Not Found");
	}
	
	
	public String DeleteAll()
	{
		List<Student> all = repositry.findAll();
		if(all.isEmpty())
		{
			throw new RuntimeException("Students Not Found");
		}
		repositry.deleteAll();
		return "Delete AllStudents";
	}
	
	public Student UpdateStudent(Integer id,Student student )
	{
		Optional<Student> byId = repositry.findById(id);
		if(byId.isPresent())
		{
			Student student2 = byId.get();
			student2.setRollno(student.getRollno());
			student2.setStudentName(student.getStudentName());
			student2.setActive(student.getActive());
			student2.setClass_name(student.getClass_name());
			
			Student save = repositry.save(student2);
			return save;
		}
		throw new RuntimeException("Student Not Found");
	}
	
	public Student UpdateStudentactvie(Integer id,active active)
	{
		Optional<Student> byId = repositry.findById(id);
		if(byId.isPresent())
		{
		  Student student = byId.get();
		  student.setActive(active.getActive());
		  Student save = repositry.save(student);
		  return save;
		}
		throw new RuntimeException("Student NOT Found");
	}
	
	
	
    
}
