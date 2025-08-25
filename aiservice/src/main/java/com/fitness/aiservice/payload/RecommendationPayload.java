package com.fitness.aiservice.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RecommendationPayload {


    private String activityId;
    private String userId;
    private String activityType;
    private List<String> improvements;
    private List<String> safety;
    private List<String> suggestions;
    private LocalDateTime createdAt;

}
