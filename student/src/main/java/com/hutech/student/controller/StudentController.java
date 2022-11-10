package com.hutech.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/db/curd")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/stud")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/stud/{id}")
	public Student getStudent(@PathVariable int id) throws ResourceNotFoundException {
		return studentService.getStudent(id);
	}

	@PostMapping("/sv_stud")
	public Student createStudent(@RequestBody Student student) throws ResourceNotFoundException {
		return studentService.createStudent(student);
	}

	@PutMapping("/up_stud/{id}")
	public String updateStudent(@PathVariable int id, @Validated @RequestBody Student studentDetails)
			throws ResourceNotFoundException {
		return studentService.updateStudent(studentDetails, id);
	}

	@DeleteMapping("/del_stud/{id}")
	public String deleteStudent(@PathVariable int id, @Validated @RequestBody Student studentDetails)
			throws ResourceNotFoundException {
		return studentService.deleteStudent(studentDetails, id);
	}

}
