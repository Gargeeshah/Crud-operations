package com.spring.crudoperations.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crudoperations.dao.CourseRepository;
import com.spring.crudoperations.model.Course;
import com.spring.crudoperations.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void addCourseData(Course course, String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.saveAndFlush(course);

    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course course, String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.saveAndFlush(course);
    }


}
