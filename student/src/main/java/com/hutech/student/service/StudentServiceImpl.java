package com.hutech.student.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.student.exception.ResourceNotFoundException;
import com.hutech.student.model.Student;
import com.hutech.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getStudent(int id) throws ResourceNotFoundException {
		Student std = studentRepository.findById(id).get();

		if (std == null) {
			throw new ResourceNotFoundException("Not found!");
		}

		return std;
	}

	public Student createStudent(Student student) throws ResourceNotFoundException {

		if (student.getStudName() == null) {
			throw new ResourceNotFoundException("Enter the Name!");
		}else if(student.getEmail()==null) {
			throw new ResourceNotFoundException("Enter the Email !");	
		}else if(student.getStream()==null) {
			throw new ResourceNotFoundException("Enter the Stream !");
		}else if(student.getGrade()==null) {
			throw new ResourceNotFoundException("Enter the grade !");
		}
		return studentRepository.save(student);
	}

	public String updateStudent(Student student, int id) throws ResourceNotFoundException {
		Student std = studentRepository.findById(id).get();

		if (std == null) {
			throw new ResourceNotFoundException("Not found!");
		}

		std.setStudName(student.getStudName());

		std.setStream(student.getStream());

		std.setEmail(student.getEmail());

		std.setGrade(student.getGrade());

		studentRepository.save(std);

		return "UPDATED";
	}

	public String deleteStudent(Student student, int id) throws ResourceNotFoundException {
		Student std = studentRepository.findById(id).get();

		if (std == null) {
			throw new ResourceNotFoundException("Not found!");
		}

		studentRepository.deleteById(id);

		return "DELETED";
	}
}
