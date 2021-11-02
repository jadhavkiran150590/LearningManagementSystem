package com.lms.vo;

import lombok.Data;

import com.lms.model.Student;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateVO {

	private Student student;

	private Course course;

}
