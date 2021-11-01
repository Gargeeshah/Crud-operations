package com.spring.crudoperations.dao;


import com.spring.crudoperations.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {

}
