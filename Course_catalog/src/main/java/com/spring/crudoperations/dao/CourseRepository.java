package com.spring.crudoperations.dao;

import com.spring.crudoperations.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
