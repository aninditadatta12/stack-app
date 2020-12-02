package com.nokia.stack.service;

import com.nokia.stack.model.PushData;
import com.nokia.stack.model.PushToMongo;
import com.nokia.stack.model.PushToPostgres;
import com.nokia.stack.repo.MongoRepository;
import com.nokia.stack.repo.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.nokia.stack.service.Service {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    MongoRepository mongoRepository;

    @Autowired
    PostgresRepository postgresRepository;

    @Override
    public void push(PushData pushData){
        //pushData.setTime(System.currentTimeMillis());
        //mongoRepository.save(pushData);

        if (pushData.getDb().equals("postgres")){

            PushToPostgres pushToPostgres= new PushToPostgres();
            pushToPostgres.setData(pushData.getData());
            pushToPostgres.setCreatedtimestamp(System.currentTimeMillis());
            postgresRepository.save(pushToPostgres);

        }

        else if (pushData.getDb().equals("mongo")){

            PushToMongo pushToMongo= new PushToMongo();
            pushToMongo.setData(pushData.getData());
            pushToMongo.setCreatedtimestamp(System.currentTimeMillis());
            mongoRepository.save(pushToMongo);
        }
    }

    public ResponseEntity get(String db){
        if (db.equals("postgres")) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createdtimestamp"));
            return new ResponseEntity(postgresRepository.findAll(sort), HttpStatus.OK);
        }
        else if (db.equals("mongo")) {
            Query query = new Query();
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createdtimestamp"));
            query.with(sort);
            mongoTemplate.find(query, PushToMongo.class);

            return new ResponseEntity(mongoTemplate.find(query, PushToMongo.class),HttpStatus.OK);
        }
        return new ResponseEntity("db value incorrect",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity pop(String db){

        if (db.equals("postgres")) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createdtimestamp"));
            List<PushToPostgres> pop = postgresRepository.findAll(sort);
            if (pop.size()>0){
                postgresRepository.delete(pop.get(0));
            }

            return new ResponseEntity("Pop Successful from db: "+db, HttpStatus.OK);
        }
        if (db.equals("mongo")) {
            Query query = new Query();
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createdtimestamp"));
            query.with(sort);

            List<PushToMongo> pop = mongoTemplate.find(query, PushToMongo.class);
            if (pop.size()>0) {
                mongoRepository.delete(pop.get(0));
            }
            return new ResponseEntity("Pop Successful from db: "+db, HttpStatus.OK);
        }
        return new ResponseEntity("db value incorrect",HttpStatus.BAD_REQUEST);
    }
}
