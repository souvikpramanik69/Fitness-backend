package com.fitness.aiservice.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecommendationDto {
    private String id;
    private String activityId;
    private String userId;
    private String activityType;
    private List<String> improvements;
    private List<String> safety;
    private List<String> suggestions;
    @CreatedDate
    private LocalDateTime createdAt;
}
