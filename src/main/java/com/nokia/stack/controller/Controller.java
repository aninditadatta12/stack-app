package com.nokia.stack.controller;

import com.nokia.stack.model.PushData;
import com.nokia.stack.repo.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MongoRepository mongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/test")
    public ResponseEntity testMathod() {

        return new ResponseEntity("It's My Result", HttpStatus.OK);

    }

    @PostMapping(value = "/push")
    public ResponseEntity push(@RequestBody PushData pushData) {

        pushData.setTime(System.currentTimeMillis());

        mongoRepository.save(pushData);

        return new ResponseEntity("Data Pushed To Stack", HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity get() {

        Query query = new Query();
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "time"));
        query.with(sort);
        List<PushData> pushData  = mongoTemplate.find(query, PushData.class);

        return new ResponseEntity(pushData, HttpStatus.OK);
    }

    @DeleteMapping(value = "/pop")
    public ResponseEntity pop() {
        Query query = new Query();
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "time"));
        query.with(sort);

        List<PushData> pushData = mongoTemplate.find(query, PushData.class);
        mongoRepository.delete(pushData.get(0));
        return new ResponseEntity("Popped Successfully", HttpStatus.OK);
    }

}
