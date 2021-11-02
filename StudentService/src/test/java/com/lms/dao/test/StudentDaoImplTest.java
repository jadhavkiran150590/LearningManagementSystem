package com.lms.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lms.dao.StudentDaoImpl;
import com.lms.model.Student;
import com.lms.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoImplTest {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	@MockBean
	StudentRepository studentRepositoryImpl;

	@Test
	public void addStudentDetailsTest() {
		Student student = new Student(11, "RAM", "INDIA", 9898989898L, 22);
		studentDaoImpl.addStudentDetails(student);
		verify(studentRepositoryImpl, times(1)).save(student);
	}

	@Test
	public void deleteStudentDetailsTest() {
		Student student = new Student(11, "RAM", "INDIA", 9898989898L, 22);
		studentDaoImpl.deleteStudentDetails(student.getStudentId());
		verify(studentRepositoryImpl, times(1)).deleteById(student.getStudentId());
	}
}
