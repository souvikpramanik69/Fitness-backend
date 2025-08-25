package com.fitness.activityservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitness.activityservice.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<M,D> {

    private Status status;
    private int code;
    private M message;
    private D data;



    public ApiResponse(Status status,int code,M message,D data){
     this.status = status;
     this.code = code;
     this.message = message;
     this.data=data;

    }
    public ApiResponse(Status status,int code,M message){
        this.status = status;
        this.code = code;
        this.message = message;

    }

}
