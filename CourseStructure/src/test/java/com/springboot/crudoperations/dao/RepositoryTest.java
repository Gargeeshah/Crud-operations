package com.springboot.crudoperations.dao;

import com.springboot.crudoperations.model.Course;
import com.springboot.crudoperations.model.Topic;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {


    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSaveCourse(){
        System.out.println("hi");
        Course course = getCourse();
        System.out.println(course);
     courseRepository.save(course);
        System.out.println(course.getId());
        assertThat(course.getId()).isGreaterThan("0");
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Course course = courseRepository.findById("1").get();

        assertThat(course.getId()).isEqualTo("1");

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Course course = courseRepository.findById("1").get();

        course.setCourseName("Microservices");

        Course courseUpdated =  courseRepository.save(course);

        assertThat(courseUpdated.getCourseName()).isEqualTo("Microservices");

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteEmployeeTest() {

        Course course = courseRepository.findById("1").get();

        courseRepository.delete(course);
        assertThat(course).isNull();
    }
    private Course getCourse() {
      Course course = new Course();
      course.setId("1");
      course.setCourseName("Docker");
      course.setDuration("5 hr");
      course.setTopic(new Topic("1","docker desktop","2 hr"));
      return course;

    }
}
