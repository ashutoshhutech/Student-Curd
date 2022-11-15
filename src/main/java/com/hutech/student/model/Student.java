package com.hutech.student.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "provide your name")
	private String studentName;

	@NotEmpty(message = "provide your stream")
	private String stream;

	@NotEmpty(message = "please provide Email")
	@Email
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "Please provide Grade")
	private String grade;

	@Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
	@NotEmpty(message = "This field cannot be empty")
	@Column(unique = true)
	private String phoneNumber;

	
}
