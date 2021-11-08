package com.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.model.Student;
import com.lms.repository.StudentRepository;
import com.lms.vo.Course;
import com.lms.vo.CourseList;
import com.lms.vo.RestTemplateVO;
import com.lms.vo.RestTemplateVOAll;

@Component
public class StudentDaoImpl {

	@Autowired
	StudentRepository studentRepositoryImpl;

	@Autowired
	RestTemplate restTemplate;

	public RestTemplateVO getRestTemplateVO(long studentId) {
		// TODO Auto-generated method stub

		RestTemplateVO restTemplateVO = new RestTemplateVO();

		Student student = studentRepositoryImpl.findByStudentId(studentId);

		Course course = restTemplate.getForObject("http://CourseService/courses/" + student.getCourseId(),
				Course.class);

		restTemplateVO.setStudent(student);
		restTemplateVO.setCourse(course);

		return restTemplateVO;
	}

	public Student addStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentRepositoryImpl.save(student);
	}

	public Student updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentRepositoryImpl.save(student);
	}

	public void deleteStudentDetails(long studentId) {
		// TODO Auto-generated method stub
		studentRepositoryImpl.deleteById(studentId);
	}

	public List<RestTemplateVOAll> getRestTemplateVOAll() {
		// TODO Auto-generated method stub
		List<RestTemplateVOAll> restTemplateVOAll = new ArrayList<>();

		List<Student> students = studentRepositoryImpl.findAll();

		System.out.println("*****Student Size: "+ students.size());
		
		
		//CourseList cl =  restTemplate.getForObject("http://CourseService/courses/", CourseList.class);

		CourseList response =
	                restTemplate.getForObject(
	                        "http://CourseService/courses/",
	                        CourseList.class);
		
		System.out.println("\n CourseList Size: "+ response.getCourses().size());
		restTemplateVOAll.add((RestTemplateVOAll) students);
		restTemplateVOAll.add((RestTemplateVOAll) response.getCourses());

		return restTemplateVOAll;
	}

}
