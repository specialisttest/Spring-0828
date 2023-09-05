package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

// SUFFIX: Impl !!! (by default)
// className == Original_repository_interface_name + Impl
public class CourseRepositoryImpl implements CourseRepositoryCustomized<Course> {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public List<Course> findByTitle(String title) {
		return 
		em.createQuery("SELECT c FROM Course c WHERE c.title LIKE :search", Course.class)
		   .setParameter("search", "%"+title+"%")
		   .getResultList();
	}
	/*
	@Transactional
	@Override 
	public void delete(Course entity) {
		// custmozied opertaion instead CrudRepository
	}*/
	

}
