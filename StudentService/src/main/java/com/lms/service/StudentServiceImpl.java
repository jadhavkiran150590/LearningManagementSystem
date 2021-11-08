package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.StudentDaoImpl;
import com.lms.model.Student;
import com.lms.vo.RestTemplateVO;
import com.lms.vo.RestTemplateVOAll;

@Service
public class StudentServiceImpl {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	public RestTemplateVO getRestTemplateVO(long studentId) {
		// TODO Auto-generated method stub
		return studentDaoImpl.getRestTemplateVO(studentId);
	}

	public Student addStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentDaoImpl.addStudentDetails(student);
	}

	public Student updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentDaoImpl.updateStudentDetails(student);
	}

	public void deleteStudentDetails(long studentId) {
		// TODO Auto-generated method stub
		studentDaoImpl.deleteStudentDetails(studentId);
	}

	public List<RestTemplateVOAll> getRestTemplateVOAll() {
		// TODO Auto-generated method stub
		return studentDaoImpl.getRestTemplateVOAll();
	}
	
	
}
