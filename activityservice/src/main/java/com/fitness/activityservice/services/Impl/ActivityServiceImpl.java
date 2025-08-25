package com.fitness.activityservice.services.Impl;


import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.payload.ActivityPayload;
import com.fitness.activityservice.repositories.ActivityRepositories;
import com.fitness.activityservice.services.ActivityService;
import com.fitness.activityservice.services.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepositories repositories;
    private final UserValidationService userValidationService;


//    ============== Implementing Rabbitmq ================


    public Activity trackActivity(ActivityPayload payload){

        boolean isUserExist = userValidationService.validateUser(payload.getUserId());
        if(isUserExist){
            Activity activity = Activity.builder()
                    .id(UUID.randomUUID().toString())
                    .type(payload.getType())
                    .caloriesBurned(payload.getCaloriesBurned())
                    .Duration(payload.getDuration())
                    .startTime(payload.getStartTime())
                    .userId(payload.getUserId())
                    .addtionalMetrics(payload.getAdditionalMetrics())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            return repositories.save(activity);
        }
        return null;


    }

    public List<Activity> getActivityByUserId(String userId){
        List<Activity> activityList =  repositories.findByUserId(userId);
     if(activityList != null){
         return activityList;
     }
     return null;
    }

    public Activity getActivityById(String activityId){
        Optional<Activity> result = Optional.ofNullable(repositories.findById(activityId).orElseThrow(()->new RuntimeException("Activity not found by id ")));
        return result.orElse(null);
    }
}
