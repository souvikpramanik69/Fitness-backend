package com.fitness.aiservice.controllers;

import com.fitness.aiservice.dto.RecommendationDto;
import com.fitness.aiservice.enums.Status;
import com.fitness.aiservice.payload.RecommendationPayload;
import com.fitness.aiservice.response.ApiResponse;
import com.fitness.aiservice.services.RecommendationService;
import com.fitness.aiservice.services.serviceImpl.RecommendationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecommendationController {

    private final RecommendationServiceImpl recommendationService;

    @GetMapping("/recommendation/user/{userId}")
    public ResponseEntity<ApiResponse<Object,List<RecommendationDto>>> getRecommendationByUserId(@PathVariable String userId){
      ApiResponse<Object,List<RecommendationDto>> response;
    try{
        List<RecommendationDto> result = recommendationService.getUserRecommendation(userId);
        if(result != null){
            response = new ApiResponse<Object,List<RecommendationDto>>(Status.SUCCESS,200,"Recommendation has been retrieved successfully",result);
            return new ResponseEntity<ApiResponse<Object,List<RecommendationDto>>>(response, HttpStatus.OK);
        }
        else {
            response = new ApiResponse<Object,List<RecommendationDto>>(Status.ERROR,404,"User doesn't exist");
            return new ResponseEntity<ApiResponse<Object,List<RecommendationDto>>>(response, HttpStatus.NOT_FOUND);
        }
    }
    catch (Exception e){
        response = new ApiResponse<Object,List<RecommendationDto>>(Status.ERROR,500,e.getMessage());
        return new ResponseEntity<ApiResponse<Object,List<RecommendationDto>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/recommendation/activity/{activityId}")
    public ResponseEntity<ApiResponse<Object,RecommendationDto>> getRecommendationByActivityId( @PathVariable String activityId){
        ApiResponse<Object,RecommendationDto> response;
        try{
            RecommendationDto result = recommendationService.getActivityRecommendation(activityId);
            if(result != null){
                response = new ApiResponse<Object,RecommendationDto>(Status.SUCCESS,200,"Recommendation has been retrieved by activity id",result);
                return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response, HttpStatus.OK);
            }
            else {
                response = new ApiResponse<Object,RecommendationDto>(Status.ERROR,404,"Recommendation not found by activity id");
                return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            response = new ApiResponse<Object,RecommendationDto>(Status.ERROR,500,e.getMessage());
            return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/recommendation")
    public ResponseEntity<ApiResponse<Object,RecommendationDto>> addRecommendation(RecommendationPayload payload){
        ApiResponse<Object,RecommendationDto> response;
        try{
          RecommendationDto result = recommendationService.addRecommendation(payload);
          if(result != null){
              response = new ApiResponse<Object,RecommendationDto>(Status.SUCCESS,201,"Recommendation added successfully",result);
              return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response,HttpStatus.CREATED);
          }
          else {
              response = new ApiResponse<Object,RecommendationDto>(Status.ERROR,404,"User doesn't exist");
              return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response,HttpStatus.NOT_FOUND);
          }
        }catch (Exception e){
            response = new ApiResponse<Object,RecommendationDto>(Status.ERROR,500,e.getMessage());
            return new ResponseEntity<ApiResponse<Object,RecommendationDto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
