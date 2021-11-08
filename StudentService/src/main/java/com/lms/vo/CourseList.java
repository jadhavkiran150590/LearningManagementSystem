package com.lms.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class CourseList {

	private List<Course> courses;
	
	public CourseList() {
		courses = new ArrayList<>();
    }
}
