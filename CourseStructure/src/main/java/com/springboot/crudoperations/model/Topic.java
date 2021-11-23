package com.springboot.crudoperations.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private String id;
    private String topicName;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", topicName='" + topicName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Topic(String id, String topicName, String description) {
        this.id = id;
        this.topicName = topicName;
        this.description = description;
    }

    public Topic() {
    }
}
