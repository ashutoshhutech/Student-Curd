package com.hutech.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.student.exception.ResourceNotFoundException;
import com.hutech.student.model.Student;
import com.hutech.student.service.StudentService;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/findall")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) throws ResourceNotFoundException {
		return studentService.getStudent(id);
	}

	@PostMapping
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable int id, @Validated @RequestBody Student studentDetails)
			throws ResourceNotFoundException {
		return studentService.updateStudent(studentDetails, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) throws ResourceNotFoundException {
		return studentService.deleteStudent(id);
	}

}
