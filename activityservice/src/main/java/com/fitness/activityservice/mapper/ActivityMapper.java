package com.fitness.activityservice.mapper;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.models.Activity;

import lombok.Data;

@Data
public class ActivityMapper {


    public static ActivityDto mapToDto(Activity activity){
       ActivityDto dto = new ActivityDto();
       dto.setId(activity.getId());
       dto.setType(activity.getType());
       dto.setDuration(activity.getDuration());
       dto.setCreatedAt(activity.getCreatedAt());
       dto.setUpdatedAt(activity.getUpdatedAt());
       dto.setStartTime(activity.getStartTime());
       dto.setUserID(activity.getUserId());
       dto.setAddtionalMetrics(activity.getAddtionalMetrics());
       dto.setCaloriesBurned(activity.getCaloriesBurned());
       return dto;

    }

}
