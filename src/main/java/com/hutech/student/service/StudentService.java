package com.hutech.student.service;

import java.util.List;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.hutech.student.exception.ResourceNotFoundException;
import com.hutech.student.model.Student;
import com.hutech.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getStudent(int id) throws ResourceNotFoundException {
		Student studentId = studentRepository.findById(id);

		if (studentId != null) {
			return studentId;
		} else
			throw new ResourceNotFoundException("Student not found with id : " + studentId, null);
	}

	public Student createStudent(Student student) {

		if (studentRepository.findByEmail(student.getEmail()) != null)
			throw new ConstraintViolationException("The email is already exist", null);

		if (studentRepository.findByPhoneNumber(student.getPhoneNumber()) != null)
			throw new ConstraintViolationException("The phone Number  is already exist", null);

		return studentRepository.save(student);
	}

	public String updateStudent(Student student, int id) throws ResourceNotFoundException {
		Student studentId = studentRepository.findById(id);

		if (studentId == null) {
			throw new ResourceNotFoundException("Student Id " + id + " Not found!", null);
		}

		studentId.setStudentName(student.getStudentName());

		studentId.setStream(student.getStream());

		studentId.setEmail(student.getEmail());

		studentId.setGrade(student.getGrade());

		studentRepository.save(studentId);

		return "UPDATED";
	}

	public String deleteStudent(int id) throws ResourceNotFoundException {
		Student studentId = studentRepository.findById(id);

		if (studentId == null) {
			throw new ResourceNotFoundException("No student Registred with the id    " + studentId, null);
		}

		studentRepository.deleteById(id);

		return "DELETED";
	}
}
