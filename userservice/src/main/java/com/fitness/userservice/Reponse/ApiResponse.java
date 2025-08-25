package com.fitness.userservice.Reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitness.userservice.enums.Status;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<D,M> {
   private Status status;
   private int code;
   private M message;
   private D data;
    public ApiResponse( Status status,int code,M message){
       this.status=status;
       this.code=code;
       this.message=message;
    }  public ApiResponse( Status status,int code,M message,D data){
       this.status=status;
       this.code=code;
       this.message=message;
       this.data = data;
    }
}


