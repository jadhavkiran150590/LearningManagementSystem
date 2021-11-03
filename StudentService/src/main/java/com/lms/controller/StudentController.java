package com.lms.controller;

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

import com.lms.exception.StudentRecordNotFoundException;
import com.lms.model.Student;
import com.lms.repository.StudentRepository;
import com.lms.service.StudentServiceImpl;
import com.lms.vo.RestTemplateVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value="Student Database")
@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@Autowired
	StudentRepository studentRepositoryImpl;

	@ApiOperation(value="Get Student Details")
	@GetMapping("/{studentId}")
	public ResponseEntity<RestTemplateVO> getRestTemplateVO(@PathVariable long studentId) {
		log.info("Retrieving data for Student Id: "+ studentId);
		return ResponseEntity.ok(studentServiceImpl.getRestTemplateVO(studentId));
	}

	@ApiOperation(value="Add Student Details")
	@PostMapping("/")
	public ResponseEntity<Student> addStudentDetails(@RequestBody Student student) {
		
		log.info("Adding Data For Student: "+ student.getStudentName());
		return ResponseEntity.ok(studentServiceImpl.addStudentDetails(student));

		
	}

	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudentDetails(@PathVariable long studentId, @RequestBody Student student)
			throws StudentRecordNotFoundException {

		Student stud = studentRepositoryImpl.findById(studentId)
				.orElseThrow(() -> new StudentRecordNotFoundException("Student Does't exist"));

		return ResponseEntity.ok(studentServiceImpl.updateStudentDetails(student));
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable long studentId) {
		studentServiceImpl.deleteStudentDetails(studentId);
		return ResponseEntity.ok("Student Data Deleted Successfully");
	}
}
