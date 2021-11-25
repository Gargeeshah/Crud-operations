package com.springboot.crudoperations.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.crudoperations.model.Course;
import com.springboot.crudoperations.model.Topic;
import com.springboot.crudoperations.servive.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class)
public class ControllerTest {

        @MockBean
        private CourseService courseService;

        @Autowired
        private MockMvc mockMvc;

        private static ObjectMapper mapper = new ObjectMapper();

        @Test
        public void testcreateCourse() throws Exception {

            Topic topic = new Topic("2", "JPA", "2 hr");
            Course course = new Course("2", "SpringBoot", "10 hrs", topic);

            String inputJSON = this.mapToJson(course);

            String URI = "/topic/2/course";

            MvcResult result = mockMvc.perform(post("/topic/2/course")
                    .accept(MediaType.APPLICATION_JSON)
                    .content(inputJSON)
                    .contentType(MediaType.APPLICATION_JSON)).andReturn();
            String outputInJson = result.getResponse().getContentAsString();

            assertThat(outputInJson).isEqualTo(inputJSON);
          //  assertEquals(HttpStatus.OK.value(), response.getStatus());
        }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
    }