package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_address")
	private String studentAddress;

	@Column(name = "student_contact_number")
	private long studentContactNumber;

	@Column(name = "course_id")
	private long courseId;

}
