package com.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pojos.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
	 Student findById(int studid);
}
