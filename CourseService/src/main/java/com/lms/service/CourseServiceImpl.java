package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.CourseDaoImpl;
import com.lms.model.Course;

@Service
public class CourseServiceImpl {

	@Autowired
	CourseDaoImpl courseDaoImpl;

	public Optional<Course> getCourseDetailsById(long courseId) {
		// TODO Auto-generated method stub
		return courseDaoImpl.getCourseDetailsById(courseId);
	}

	public Course getCourseDetailsByName(String courseName) {
		// TODO Auto-generated method stub
		return courseDaoImpl.getCourseDetailsByName(courseName);

	}

	public List<Course> getAllCourseDetails() {
		// TODO Auto-generated method stub
		return courseDaoImpl.getAllCourseDetails();
	}

	public Course addCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return courseDaoImpl.addCourseDetails(course);
	}

	public Course updateCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return courseDaoImpl.updateCourseDetails(course);
	}

	public void deleteCourseDetails(long courseId) {
		// TODO Auto-generated method stub
		courseDaoImpl.deleteCourseDetails(courseId);
	}

	public List<Course> getAllCourseListDetails() {
		// TODO Auto-generated method stub
		return courseDaoImpl.getAllCourseListDetails();
	}

}
