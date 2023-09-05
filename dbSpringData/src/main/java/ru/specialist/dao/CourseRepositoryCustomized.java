package ru.specialist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface CourseRepositoryCustomized<T> {
	
	//int getCourseMaxLength();
	//void delete(Course entity);
	List<Course> findByTitle(String title);

}
