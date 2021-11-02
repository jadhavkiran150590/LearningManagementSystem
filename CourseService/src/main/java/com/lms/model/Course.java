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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name = "course_id")
	private long courseId;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_duration")
	private int courseDuration;

	@Column(name = "course_price")
	private double coursePrice;

	@Column(name = "course_code")
	private String courseCode;

	@Column(name = "course_description")
	private String courseDescription;

}
