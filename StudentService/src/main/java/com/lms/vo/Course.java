package com.lms.vo;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private long courseId;

	private String courseName;

	private int courseDuration;

	private double coursePrice;

	private String courseCode;

	private String courseDescription;

}
