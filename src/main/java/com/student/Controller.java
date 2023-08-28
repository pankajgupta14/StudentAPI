package com.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.Student;
import com.student.service.Studentservice;

@RestController
public class Controller {

	@Autowired
	Studentservice service;

	@PostMapping("/student")
	public ResponseEntity<Optional<Student>> create(@RequestBody Student s) {
		Student ss = null;
		try {
			ss = this.service.create(s);
			System.out.println(ss);
			return ResponseEntity.ok(Optional.of(ss));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> read()
	{
		List<Student> readall = this.service.readall();
		if(readall.size()<=0) {
		return	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	return ResponseEntity.of(Optional.of(readall)) ;	 
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> readone(@PathVariable("id") int id ){
		Student s= null;
		try {
			 s = this.service.readone(id);
			 System.err.println(s);
			 return ResponseEntity.ok(s);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// update the data 
	@PutMapping("/student/{id}")
	public ResponseEntity<Optional<Student>> update(@RequestBody Student s ,@PathVariable("id") int id){
		System.out.println(s);
		try {
		Student update = this.service.update(s  , id);
		System.out.println(update);
		return ResponseEntity.ok(Optional.of(update));
		}
		catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
