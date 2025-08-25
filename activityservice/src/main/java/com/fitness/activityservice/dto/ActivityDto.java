package com.fitness.activityservice.dto;

import com.fitness.activityservice.enums.ActivityType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityDto {

    private String id;
    private ActivityType type;
    private Integer Duration;
    private Integer caloriesBurned;
    private String userID;
    private LocalDateTime startTime;
    private Map<String,Object> addtionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
