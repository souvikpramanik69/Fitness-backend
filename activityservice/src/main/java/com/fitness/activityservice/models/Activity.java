package com.fitness.activityservice.models;

import com.fitness.activityservice.enums.ActivityType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Activity {

    @Id
    private String id;
    private ActivityType type;
    private Integer Duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private String userId;
    @Field(name = "metrics")
    private Map<String,Object> addtionalMetrics;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
