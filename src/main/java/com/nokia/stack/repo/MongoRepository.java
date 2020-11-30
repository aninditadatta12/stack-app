package com.nokia.stack.repo;

import com.nokia.stack.model.PushData;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<PushData, String> {
}