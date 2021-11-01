package com.spring.crudoperations.controller;

import com.spring.crudoperations.model.Topic;
import com.spring.crudoperations.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {


    @Autowired
    private TopicService topicService;

    @GetMapping("{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable String id){
        return ResponseEntity.ok(topicService.getTopicById(id).get());
    }

    @PostMapping("/add")
    public ResponseEntity addTopic(@RequestBody Topic topic){
       topicService.addTopic(topic);
       return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
        return new ResponseEntity(HttpStatus.OK);
    }
}
