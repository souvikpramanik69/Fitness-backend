package com.fitness.aiservice.repositories;

import com.fitness.aiservice.models.Recommendations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepositories extends MongoRepository<Recommendations,String> {

    public List<Recommendations> findByUserId(String userId);
    public Optional<Recommendations> findByActivityId(String activityId);
}
