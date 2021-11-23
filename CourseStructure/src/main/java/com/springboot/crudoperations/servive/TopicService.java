package com.springboot.crudoperations.servive;

import com.springboot.crudoperations.dao.TopicRepository;
import com.springboot.crudoperations.model.Topic;
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
