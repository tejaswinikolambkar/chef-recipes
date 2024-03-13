package com.project.Bona.dto;

import lombok.*;

@Data
public class Status {

    private StatusType status;
    private String message;

    public static enum StatusType{
        SUCCESS,FAILURE;
    }
}
