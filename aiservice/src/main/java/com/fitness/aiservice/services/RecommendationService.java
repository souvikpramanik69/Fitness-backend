package com.fitness.aiservice.services;

import com.fitness.aiservice.dto.RecommendationDto;
import com.fitness.aiservice.models.Recommendations;
import com.fitness.aiservice.payload.RecommendationPayload;

import java.util.List;

public interface RecommendationService {

    public List<RecommendationDto> getUserRecommendation(String userId);
    public RecommendationDto getActivityRecommendation(String activityId);
    public RecommendationDto addRecommendation(RecommendationPayload payload);



}
