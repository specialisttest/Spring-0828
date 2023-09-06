package ru.specialist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface CourseRepositoryCustomized {
	
	//int getCourseMaxLength();
	List<Course> findByTitle(String title);

}
