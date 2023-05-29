package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojos.Student;
import com.demo.repo.StudentRepo;


@Service
public class StudentService {

	@Autowired
	private StudentRepo studRepo;
	
	public Student addStudent(Student stud)
	{
		return studRepo.save(stud);
	}
	
	public Student getStudentById(int id)
	{
		return studRepo.findById(id);
		
	}
	
	public Student updateStudent(int studId,Student stud)
	{
		Student student=studRepo.findById(studId);
		if(student.getId()==studId)
		{
			if(stud.getName()!=null && stud.getName()!="")
			{
				student.setName(stud.getName());
			}
			if(stud.getMobile()!=null && stud.getMobile()!="")
			{
				student.setMobile(stud.getMobile());
			}
			if(stud.getGender()!=null && stud.getGender()!=null)
			{
				student.setGender(stud.getGender());
			}
			if(stud.getEmail()!=null && stud.getEmail()!=null)
			{
				student.setEmail(stud.getEmail());
			}
			
		}
		return studRepo.save(student);
		
	}
	
	public Student deleteStudent(int id)
	{
		Student stud=studRepo.findById(id);
		if(stud!=null)
		{
			studRepo.deleteById(id);
		}
		return stud;
		
	}
	
}















