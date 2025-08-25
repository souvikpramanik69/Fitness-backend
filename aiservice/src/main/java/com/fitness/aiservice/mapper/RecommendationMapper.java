package com.fitness.aiservice.mapper;

import com.fitness.aiservice.dto.RecommendationDto;
import com.fitness.aiservice.models.Recommendations;
import lombok.Data;

@Data
public class RecommendationMapper {
    public static RecommendationDto mapToDto(Recommendations recommendations){
         RecommendationDto dto = new RecommendationDto();
         dto.setId(recommendations.getId());
         dto.setSafety(recommendations.getSafety());
         dto.setImprovements(recommendations.getImprovements());
         dto.setSuggestions(recommendations.getSuggestions());
         dto.setActivityId(recommendations.getActivityId());
         dto.setUserId(recommendations.getUserId());
         dto.setActivityType(recommendations.getActivityType());
         return dto;
    }
}
