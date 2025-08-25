package com.fitness.activityservice.payload;

import com.fitness.activityservice.enums.ActivityType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Getter
@Setter
public class ActivityPayload {

    private ActivityType type;
    private Integer Duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrics;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
