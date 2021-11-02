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

import com.lms.dao.CourseDaoImpl;
import com.lms.model.Course;
import com.lms.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoImplTest {

	@Autowired
	CourseDaoImpl courseDaoImpl;

	@MockBean
	CourseRepository courseRepositoryImpl;

	@Test
	public void getCourseDetailsByIdTest() {

		Course course = new Course(101, "JAVA", 6, 868769.89, "AA11", "Java Full Stack");

		courseDaoImpl.getCourseDetailsById(course.getCourseId());

		verify(courseRepositoryImpl, times(1)).findById(course.getCourseId());
	}

	@Test
	public void getAllCourseDetailsTest() {
		when(courseRepositoryImpl.findAll()).thenReturn(Stream
				.of(new Course(101, "JAVA", 6, 868769.89, "AA11", "Java Full Stack"),
						new Course(102, "Python", 6, 868769.89, "BB11", "Python Full Stack"))
				.collect(Collectors.toList()));
		assertEquals(2, courseDaoImpl.getAllCourseDetails().size());
	}

	@Test
	public void addCourseDetailsTest() {
		Course course = new Course(101, "JAVA", 6, 868769.89, "AA11", "Java Full Stack");

		courseDaoImpl.addCourseDetails(course);

		verify(courseRepositoryImpl, times(1)).save(course);
	}

	@Test
	public void deleteCourseDetailsTest() {
		Course course = new Course(101, "JAVA", 6, 868769.89, "AA11", "Java Full Stack");

		courseDaoImpl.deleteCourseDetails(course.getCourseId());

		verify(courseRepositoryImpl, times(1)).deleteById(course.getCourseId());
	}

}
