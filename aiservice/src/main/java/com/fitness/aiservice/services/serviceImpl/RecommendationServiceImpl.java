package com.fitness.aiservice.services.serviceImpl;

import com.fitness.aiservice.dto.RecommendationDto;
import com.fitness.aiservice.mapper.RecommendationMapper;
import com.fitness.aiservice.models.Recommendations;
import com.fitness.aiservice.payload.RecommendationPayload;
import com.fitness.aiservice.repositories.RecommendationRepositories;
import com.fitness.aiservice.services.RecommendationService;
import com.fitness.aiservice.services.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepositories repositories;
    private final UserValidationService userValidationService;

    public List<RecommendationDto> getUserRecommendation(String userId){
        Boolean isUserExist = userValidationService.validUser(userId);
        System.out.println("Response from user service "  + isUserExist);
        if(isUserExist){
            List<Recommendations> isRecommendationExist = repositories.findByUserId(userId);
            if(!isRecommendationExist.isEmpty()){
                List<RecommendationDto> dtoList  = isRecommendationExist.stream().map((item)->{
                    RecommendationDto dto = RecommendationMapper.mapToDto(item);
                    return dto;
                }).toList();
                return dtoList;
            }
          throw new RuntimeException("Recommended not found by user id or user doesn't exist");
        }
        return  null;


    }

    public RecommendationDto getActivityRecommendation(String activityId){
        Optional<Recommendations> isRecommendationExist = Optional.ofNullable(repositories.findByActivityId(activityId).orElse(null));
        return isRecommendationExist.map(RecommendationMapper::mapToDto).orElse(null);
    }

    public RecommendationDto addRecommendation(RecommendationPayload payload){

        Boolean isUserExist = userValidationService.validUser(payload.getUserId());
        System.out.println("Running After Reco "+  isUserExist);
        if(isUserExist){
            Recommendations newRecommendation  = new Recommendations();
            newRecommendation.setId(UUID.randomUUID().toString());
            newRecommendation.setActivityType(payload.getActivityType());
            newRecommendation.setUserId(payload.getUserId());
            newRecommendation.setSuggestions(payload.getSuggestions());
            newRecommendation.setImprovements(payload.getImprovements());
           repositories.save(newRecommendation);
           return RecommendationMapper.mapToDto(newRecommendation);

        }

     else return null;




    }


}
