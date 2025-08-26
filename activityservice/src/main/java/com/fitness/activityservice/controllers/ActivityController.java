package com.fitness.activityservice.controllers;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.enums.Status;
import com.fitness.activityservice.mapper.ActivityMapper;
import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.payload.ActivityPayload;
import com.fitness.activityservice.response.ApiResponse;
import com.fitness.activityservice.services.Impl.ActivityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ActivityController {

   private final ActivityServiceImpl activityService;

    @PostMapping("/activities")
    public Mono<ResponseEntity<ApiResponse<Object, ActivityDto>>> trackActivity(@RequestBody ActivityPayload payload) {
        return activityService.trackActivity(payload)
                .map(activity -> {
                    ApiResponse<Object, ActivityDto> response = new ApiResponse<>(
                            Status.SUCCESS,
                            201,
                            "Activity added successfully",
                            ActivityMapper.mapToDto(activity)
                    );
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                })
                .switchIfEmpty(Mono.just(
                        new ResponseEntity<>(
                                new ApiResponse<>(Status.ERROR, 404, "User doesn't exist"),
                                HttpStatus.NOT_FOUND
                        )
                ))
                .onErrorResume(e -> {
                    ApiResponse<Object, ActivityDto> response = new ApiResponse<>(
                            Status.ERROR,
                            500,
                            e.getMessage()
                    );
                    return Mono.just(new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }


   @GetMapping("/user/activity")
   public ResponseEntity<ApiResponse<Object, List<ActivityDto>>> getActivityByUserID
           (@RequestHeader("X-USER-ID") String userId){
        ApiResponse<Object,List<ActivityDto>> response;
try{
         List<Activity> result = activityService.getActivityByUserId(userId);
    System.out.println("Result "  + result);
         if(!result.isEmpty()){
             List<ActivityDto> dtoList = result.stream().map((item)->{
                 ActivityDto dto = ActivityMapper.mapToDto(item);
                 return dto;
             }).toList();
             response = new ApiResponse<Object,List<ActivityDto>>(Status.SUCCESS,200,"Activity has been retrieved by user id",dtoList);
             return new ResponseEntity<ApiResponse<Object,List<ActivityDto>>>(response,HttpStatus.OK);
         }
         else{
             response = new ApiResponse<Object,List<ActivityDto>>(Status.ERROR,404,"Activity not found by this user id");
             return new ResponseEntity<ApiResponse<Object,List<ActivityDto>>>(response,HttpStatus.NOT_FOUND);
         }

}
catch (Exception e){
    response = new ApiResponse<Object,List<ActivityDto>>(Status.ERROR,200,e.getMessage());
    return new ResponseEntity<ApiResponse<Object,List<ActivityDto>>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
}
   }

   @GetMapping("/activity/{Id}")
   public ResponseEntity<ApiResponse<Object,ActivityDto>> getActivityById(@PathVariable String Id){
     ApiResponse<Object,ActivityDto> response;
     try{
          Activity result = activityService.getActivityById(Id);
          if(result != null){
              response = new ApiResponse<Object,ActivityDto>
                      (Status.SUCCESS,200,"Activity has been retrieved successfully",ActivityMapper.mapToDto(result));
              return new ResponseEntity<ApiResponse<Object,ActivityDto>>(response,HttpStatus.OK);
          }
          else {
              response = new ApiResponse<Object,ActivityDto>
                      (Status.ERROR,404,"Activity doesn't exist");
              return new ResponseEntity<ApiResponse<Object,ActivityDto>>(response,HttpStatus.NOT_FOUND);
          }
     }catch (Exception e){
         response = new ApiResponse<Object,ActivityDto>
                 (Status.ERROR,500,e.getMessage());
         return new ResponseEntity<ApiResponse<Object,ActivityDto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
     }
   }



}
