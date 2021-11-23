package com.springboot.crudoperations.controller;

import com.springboot.crudoperations.model.Course;
import com.springboot.crudoperations.servive.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/topic")
public class CourseController {

    @Autowired
    private CourseService courseService;

    Logger logger = Logger.getLogger(CourseController.class);

    @PostMapping("/{topicId}/course")
    public ResponseEntity addData(@RequestBody Course course, @PathVariable String topicId){
        courseService.addCourseData(course, topicId);
        logger.info("Data added successfully");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{topicId}/course/{id}")
    public ResponseEntity<Course> getData(@PathVariable String id){
        logger.info("Data retrieve successfully");
        return ResponseEntity.ok(courseService.getCourse(id).get());
    }

    @DeleteMapping("/{topicId}/course/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
        logger.info("Data deleted successfully");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{topicId}/course/{id}")
    public ResponseEntity updateCourse(@RequestBody Course course, @PathVariable String topicId){
        courseService.updateCourse(course, topicId);
        logger.info("Data updated successfully");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{topicId}/course/{id}")
    public ResponseEntity patchData(@PathVariable String id, @RequestBody HashMap<Object, Object> fields){
        return ResponseEntity.ok(courseService.patchData(fields, id));
    }


}
