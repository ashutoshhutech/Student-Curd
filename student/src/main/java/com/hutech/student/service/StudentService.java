package com.hutech.student.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hutech.student.exception.ResourceNotFoundException;
import com.hutech.student.model.Student;

@Service
public interface StudentService {

	public List<Student> getAllStudent();

	public Student getStudent(int id) throws ResourceNotFoundException;

	public Student createStudent(Student student)throws ResourceNotFoundException;

	public String updateStudent(Student student, int id) throws ResourceNotFoundException;

	public String deleteStudent(Student student, int id)throws ResourceNotFoundException;
}
