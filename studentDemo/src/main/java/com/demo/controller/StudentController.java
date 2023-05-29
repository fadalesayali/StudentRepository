package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojos.Student;
import com.demo.service.StudentService;


@RestController
public class StudentController
{
	@Autowired
	private StudentService studService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		try
		{
			System.out.println(student);
			Student stud=studService.addStudent(student);
			return ResponseEntity.of(Optional.of(stud));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id)
	{
		Student student=studService.getStudentById(id);
		if(student==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(student);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id") int id,@RequestBody Student student)
	{
		try 
		{
			Student stud=	studService.updateStudent(id,student);
		return ResponseEntity.ok().body(stud);
		} catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id)
	{
		try 
		{
			Student student=studService.deleteStudent(id); 
			return ResponseEntity.ok().body(student);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
}

	
	
	
	













	
	
	
	