package com.fitness.aiservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "recommendation")
public class Recommendations {

    @Id
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
