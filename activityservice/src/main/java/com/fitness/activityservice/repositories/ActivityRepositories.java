package com.fitness.activityservice.repositories;

import com.fitness.activityservice.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepositories extends MongoRepository<Activity,String> {
    public List<Activity> findByUserId(@Param("userId") String userId);
}
