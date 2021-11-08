package com.lms.model;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CourseList {

private List<Course> courses;
	
	public CourseList() {
		courses = new ArrayList<>();
    }
	
	
}
