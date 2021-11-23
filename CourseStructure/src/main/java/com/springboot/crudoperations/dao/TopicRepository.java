package com.springboot.crudoperations.dao;

import com.springboot.crudoperations.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {

}
