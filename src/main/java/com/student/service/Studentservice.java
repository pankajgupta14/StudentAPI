package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.Student;
import com.student.repositry.*;

@Service
public class Studentservice {
	
	@Autowired
	private Studentdoa studentdoa;
	
	// add data
	public Student create(Student s)
	{
		Student save = this.studentdoa.save(s);
		return save;
	}
	
	//show all data
	public List<Student> readall() {
		 List<Student> list = (List) this.studentdoa.findAll();
		return list;
	}
	
	// get a single value 
	public Student readone(int id) {
		Student s = null;
		try {
		 Optional<Student> id2 = this.studentdoa.findById(id);
		 s = id2.get();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return s;
	}
	
	// update a data
	public Student update(Student s, int id)
	{
		Optional<Student> findById = this.studentdoa.findById(id);
		Student student = findById.get();
		student.setAddress(s.getAddress());
		student.setId(id);
		student.setName(s.getName());
		student.setPhonenum(s.getPhonenum());
		Student save = studentdoa.save(student);
		return save;
	}
	
 
}
