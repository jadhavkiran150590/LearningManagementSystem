package com.lms.vo;

import java.util.List;


import com.lms.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateVOAll {

	private List<Student> students;

	private List<Course> courses;
}
