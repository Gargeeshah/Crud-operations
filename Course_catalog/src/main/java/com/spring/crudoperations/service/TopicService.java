package com.spring.crudoperations.service;


import com.spring.crudoperations.dao.TopicRepository;
import com.spring.crudoperations.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    public Optional<Topic> getTopicById(String id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.saveAndFlush(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }

    public void updateTopic(Topic topic) {
        topicRepository.saveAndFlush(topic);
    }
}
