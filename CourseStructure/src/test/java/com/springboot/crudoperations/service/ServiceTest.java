package com.springboot.crudoperations.service;

import com.springboot.crudoperations.dao.CourseRepository;
import com.springboot.crudoperations.model.Course;
import com.springboot.crudoperations.model.Topic;
import com.springboot.crudoperations.servive.CourseService;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;

    @Test
    public void getCoursesTest(){

        Course course = new Course("1","Testing" ,"5 hrs", new Topic("1","Unit testing", "1 hr"));
        when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
        Optional<Course> o1 = Optional.of(course);
        assertEquals(o1 ,courseService.getCourse(course.getId()));

    }

    @Test
    public void addCourseTest()
    {
       // Topic topic = new Topic("2","Rest template", "1 hr");
        Course course = new Course("2","Microservices" ,"10 hrs", new Topic("2","Rest template", "1 hr"));
        when(courseRepository.save(course)).thenReturn(course);
        System.out.println(course);
        assertEquals(course, courseService.addCourseData(course, "2"));
        //assertThat(courseService.addCourseData(course, "2")).isEqualTo(course);
    }

    @Test
    public void deleteCourseTest()
    {
        Course course = new Course("2","Microservices" ,"10 hrs", new Topic("2","Rest template", "1 hr"));

        courseService.deleteCourse(course.getId());
        verify(courseRepository , times(1)).deleteById(course.getId());
    }

    @Test
    public void updateCourseTest()
    {
        String topicId = "2";
        Course course = new Course("2","Microservices" ,"10.5 hrs", new Topic("2","Rest template", "1 hr"));
       when(courseRepository.findById("1")).thenReturn(Optional.of(course));
       Topic topic = new Topic("2","Web client", "2 hr");
       course.setTopic(topic);
        when(courseRepository.save(course)).thenReturn(course);
        System.out.println(course);
        assertThat(courseService.updateCourse(course, "2")).isEqualTo(course);

    }
}
