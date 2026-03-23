package com.assignment.week8assignment.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LogStore {
    ArrayList<String> log = new ArrayList<>();
    public void logAdd(String user,String methodName,Long time){
        log.add(user+" is performing the activity "+ methodName+ " and it took the time of "+time+" to complete");
    }
}
