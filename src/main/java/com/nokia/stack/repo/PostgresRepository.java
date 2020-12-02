package com.nokia.stack.repo;

import com.nokia.stack.model.PushToPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository extends JpaRepository<PushToPostgres,Long> {
}
