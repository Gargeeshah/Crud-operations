package com.springboot.crudoperations.servive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.crudoperations.dao.CourseRepository;
import com.springboot.crudoperations.model.Course;
import com.springboot.crudoperations.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourseData(Course course, String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.saveAndFlush(course);
        return course;
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course, String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.saveAndFlush(course);
        return course;
    }

    public Course patchData(HashMap<Object, Object> fields, String id) {
        Course course = courseRepository.findById(id).get();

        ObjectMapper objMapper = new ObjectMapper();
        HashMap<String, Object> courseMap = objMapper.convertValue(course, HashMap.class);

        for(String key : courseMap.keySet()){
            if(fields.containsKey(key)){
                Object value =  fields.get(key);
                courseMap.put(key, value);
            }
        }
        Course courseObj = objMapper.convertValue(courseMap, Course.class);
        courseRepository.saveAndFlush(courseObj);
        return courseObj;
    }
}
