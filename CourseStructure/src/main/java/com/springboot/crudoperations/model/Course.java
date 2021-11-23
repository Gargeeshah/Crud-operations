package com.springboot.crudoperations.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collector;

@Entity
public class Course {


    @Id
    private String id;
    private String courseName;
    private String duration;

    @ManyToOne
    private Topic topic;

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    public Topic getTopic() {
        return topic;
    }

    public Course(String id, String courseName, String duration, Topic topic) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", topic=" + topic +
                '}';
    }

    public Course() {
    }


}


