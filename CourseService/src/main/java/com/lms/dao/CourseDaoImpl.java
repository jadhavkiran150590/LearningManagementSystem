package com.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.lms.model.Course;
import com.lms.repository.CourseRepository;

@Component
public class CourseDaoImpl {

	@Autowired
	CourseRepository courseRepositoryImpl;

	public Optional<Course> getCourseDetailsById(long courseId) {
		// TODO Auto-generated method stub
		return courseRepositoryImpl.findById(courseId);
	}

	public Course getCourseDetailsByName(String courseName) {
		// TODO Auto-generated method stub
		return courseRepositoryImpl.findByCourseName(courseName);
	}

	public List<Course> getAllCourseDetails() {
		// TODO Auto-generated method stub

		List<Course> item = courseRepositoryImpl.findAll(Sort.by(Sort.Direction.DESC, "coursePrice"));
		return item;
	}

	public Course addCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return courseRepositoryImpl.save(course);
	}

	public Course updateCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return courseRepositoryImpl.save(course);
	}

	public void deleteCourseDetails(long courseId) {
		// TODO Auto-generated method stub
		courseRepositoryImpl.deleteById(courseId);
	}

	public List<Course> getAllCourseListDetails() {
		// TODO Auto-generated method stub
		return courseRepositoryImpl.findAll();
	}

}
