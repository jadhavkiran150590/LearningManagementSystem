package com.lms.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.CourseNotFoundException;
import com.lms.model.Course;
import com.lms.model.CourseList;
import com.lms.service.CourseServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

	@Autowired
	CourseServiceImpl courseServiceImpl;

	@GetMapping("/{courseId}")
	public ResponseEntity<Optional<Course>> getCourseDetailsById(@PathVariable long courseId) {
		log.info("Retrieving Course Data");
		return ResponseEntity.ok(courseServiceImpl.getCourseDetailsById(courseId));
	}

	@GetMapping("getdatabyname/{courseName}")
	public ResponseEntity<Course> getCourseDetailsByName(@PathVariable String courseName) {
		
		return ResponseEntity.ok(courseServiceImpl.getCourseDetailsByName(courseName));
	}

	@GetMapping("/")
	public ResponseEntity<List<Course>> getAllCourseDetails() {
		return ResponseEntity.ok(courseServiceImpl.getAllCourseDetails());
	}

	@PostMapping("/")
	public ResponseEntity<Course> addCourseDetails(@RequestBody Course course) {
		log.info("Adding Information for Course: "+ course.getCourseName());
		return ResponseEntity.ok(courseServiceImpl.addCourseDetails(course));
	}

	@PutMapping("/{courseId}")
	public ResponseEntity<Course> updateCourseDetails(@PathVariable long courseId, @RequestBody Course course) throws CourseNotFoundException {
		
		Course courseData = courseServiceImpl.getCourseDetailsById(courseId).orElseThrow(()-> new CourseNotFoundException("Course Doesn't exist"));
		
		return ResponseEntity.ok(courseServiceImpl.updateCourseDetails(course));
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<String> deleteCourseDetails(@PathVariable long courseId) {
		courseServiceImpl.deleteCourseDetails(courseId);
		return ResponseEntity.ok("Course Detail Deleted Successfully");
	}
	
	@GetMapping("/courselist")
	public ResponseEntity<List<Course>> getAllCourseListDetails() {
		return ResponseEntity.ok(courseServiceImpl.getAllCourseListDetails());
	}

}
