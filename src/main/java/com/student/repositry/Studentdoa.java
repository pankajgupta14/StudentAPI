package com.student.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.dto.Student;

public interface Studentdoa extends CrudRepository<Student, Integer> {
   
}
