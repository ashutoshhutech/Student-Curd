package com.hutech.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findById(int id);

	Student findByEmail(String email);

	Student findByPhoneNumber(String phoneNumber);

}
