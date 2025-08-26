package com.fitness.activityservice.services;

import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.payload.ActivityPayload;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ActivityService {

    Mono<Activity> trackActivity(ActivityPayload payload);
    public List<Activity> getActivityByUserId(String userId);
    public Activity getActivityById(String activityId);

}
